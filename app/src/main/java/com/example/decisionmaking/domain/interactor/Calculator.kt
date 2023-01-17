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
    private val bikes: List<Bike>,
    private val agentsNumber: Int
) {

    fun getQuestions(agentId:Int): List<Question> {
        val questions = mutableListOf<Question>()

        //Features questions generation
        for (i in featuresToCompare.indices)
            for (j in 0 until i) {
                questions.add(
                    Question(
                        i, j, 0, agentId,
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
                            bike1Ind, bike2Ind, i, agentId,
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
    /* Answer order is irrelevant, although they should be grouped by agents in theirs id order */
    fun calculate(answers: List<List<Answer>>): List<Score> {
        val featureMatrix = List(agentsNumber){ i-> CalculationMatrix(featuresToCompare.size)}
        val bikeComparisonsMatrixes: List<Array<CalculationMatrix>> =
            List(agentsNumber){ i-> Array(featuresToCompare.size) { CalculationMatrix(bikes.size) }}

        for (agent in 0..agentsNumber) {
            for (ans in answers[agent]) {
                when (ans.questionTarget) {
                    QuestionTarget.ITEMS -> bikeComparisonsMatrixes[agent][ans.tableNumber].changeValue(
                        ans.firstItemId,
                        ans.secondItemId,
                        ans.score.toFloat()
                    )
                    QuestionTarget.FEATURES -> featureMatrix[agent].changeValue(
                        ans.firstItemId,
                        ans.secondItemId,
                        ans.score.toFloat()
                    )
                }
            }
        }
        val featurePriorities = List(agentsNumber){ i-> featureMatrix[i].extractPriorities()}
        var outputRanking = mutableListOf<Score>()
        val evaluatedScores = List(agentsNumber){ i -> Array(bikes.size) { 0f }}

            for (agents in 0..agentsNumber) {
                for (compMatrixInd in bikeComparisonsMatrixes[agents].indices) {
                    Log.d(
                        "info",
                        "CompMatrix ${compMatrixInd}:  ${bikeComparisonsMatrixes[agents][compMatrixInd]}"
                    )
                    val localPriorities = bikeComparisonsMatrixes[agents][compMatrixInd].extractPriorities()
                    for (bikeInd in localPriorities.indices) {
                        evaluatedScores[agents][bikeInd] += localPriorities[bikeInd] * featurePriorities[agents][compMatrixInd]
                    }
                }

            }

        //AIP aggregation -> geometric and arithmetic mean is usable.
        // here arithmetic
        for (bikeId in 0..bikes.size) {
            var tmpScore =0f
            evaluatedScores.forEach(){
                tmpScore += it[bikeId]
            }
            tmpScore /= agentsNumber
            outputRanking = outputRanking.plus(
                Score(
                    bike = bikes[bikeId],
                    score = tmpScore
                )
            ) as MutableList<Score>
        }
        Log.d("info", "OutputRankings:  $outputRanking")
        return outputRanking.sortedBy(Score::score).toList()
    }
}