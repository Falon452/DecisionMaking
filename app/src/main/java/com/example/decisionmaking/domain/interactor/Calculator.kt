package com.example.decisionmaking.domain.interactor

import android.util.Log
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.domain.model.FeatureType
import com.example.decisionmaking.domain.model.Question
import com.example.decisionmaking.domain.model.QuestionTarget
import com.example.decisionmaking.domain.model.QuestionTextGenerator
import com.example.decisionmaking.domain.model.Score

class Calculator(
    private var featuresToCompare: List<FeatureType>,
    private val bikes: List<Bike>
) {

    fun getQuestions(): List<Question> {
        val questions = mutableListOf<Question>()

        //Features questions generation
        for (i in featuresToCompare.indices)
            for (j in 0 until i) {
                questions.add(
                    Question(
                        i, j, 0,
                        QuestionTextGenerator.generateFeatureQuestion(
                            featuresToCompare[i],
                            featuresToCompare[j]
                        ),
                        QuestionTarget.FEATURES
                    )
                )
            }
        //Comparison on each feature questions generator
        for (i in featuresToCompare.indices) {
            for (bike1Ind in bikes.indices)
                for (bike2Ind in 0 until bike1Ind) {
                    questions.add(
                        Question(
                            bike1Ind, bike2Ind, i,
                            QuestionTextGenerator.generateItemFeatureQuestion(
                                featuresToCompare[i],
                                bikes[bike1Ind],
                                bikes[bike2Ind]
                            ),
                            QuestionTarget.ITEMS
                        )
                    )
                }
        }
        //Shuffle questions
        questions.shuffle()
        Log.d("info","All generated questions $questions")
        return questions
    }

    fun calculate(answers: List<Answer>): List<Score> {
        val featureMatrix = CalculationMatrix(featuresToCompare.size)
        val bikeComparisonsMatrixes: Array<CalculationMatrix> =
            Array(featuresToCompare.size) { CalculationMatrix(bikes.size) }

        for (ans in answers) {
            when (ans.questionTarget) {
                QuestionTarget.ITEMS -> bikeComparisonsMatrixes[ans.tableNumber].changeValue(
                    ans.firstItemId,
                    ans.secondItemId,
                    ans.score.toFloat()
                )
                QuestionTarget.FEATURES -> featureMatrix.changeValue(
                    ans.firstItemId,
                    ans.secondItemId,
                    ans.score.toFloat()
                )
            }
        }

        val featurePriorities = featureMatrix.extractPriorities()
        val evaluatedScores = Array(bikes.size) { 0f }

        for (compMatrixInd in bikeComparisonsMatrixes.indices) {
            Log.d("info","CompMatrix ${compMatrixInd}:  ${bikeComparisonsMatrixes[compMatrixInd]}")
            val localPriorities = bikeComparisonsMatrixes[compMatrixInd].extractPriorities()
            for (bikeInd in localPriorities.indices) {
                evaluatedScores[bikeInd] += localPriorities[bikeInd] * featurePriorities[compMatrixInd]
            }
        }
        var outputRanking = mutableListOf<Score>()
        for (i in evaluatedScores.indices)
            outputRanking = outputRanking.plus(
                Score(
                    bike = bikes[i],
                    score = evaluatedScores[i]
                )
            ) as MutableList<Score>
        Log.d("info","OutputRankings:  $outputRanking")

        return outputRanking.sortedBy(Score::score).toList()
    }
}