package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.*
import java.util.PriorityQueue

class Calculator(
    private val repository: Repository,
    private var featuresToCompare: List<Features>,
    private val bikes: List<Bike>
) {

    fun getQuestions() : List<Question> {
        //bikes = repository.getBikes() ?: return emptyList()

        val questions = mutableListOf<Question>();

            //Features questions generation
            for(i in featuresToCompare.indices)
                for(j in 0 until i){
                    questions.add(
                        Question(
                            i,j,0,
                            QuestionTextGenerator.generateFeatureQuestion(featuresToCompare[i],featuresToCompare[j]),
                            QuestionTarget.FEATURES
                        ))
                }
            //Comparison on each feature questions generator
            for(i in featuresToCompare.indices)
            {
                for(bike1Ind in bikes.indices)
                    for(bike2Ind in 0 until bike1Ind){
                        questions.add(
                            Question(
                                bike1Ind,bike2Ind,i,
                                QuestionTextGenerator.generateItemFeatureQuestion(featuresToCompare[i],bikes[bike1Ind],bikes[bike2Ind]),
                                QuestionTarget.ITEMS
                            ))
                    }
            }
            //Shuffle questions
            questions.shuffle()
            return questions;

    }

    fun calculate(answers:List<Answer>) : List<Score> {
        val featureMatrix = CalculationMatrix(featuresToCompare.size)
        val bikeComparisonsMatrixes : Array<CalculationMatrix> = Array<CalculationMatrix>(featuresToCompare.size){CalculationMatrix(bikes.size)};

        for(ans in answers)
        {
            when(ans.questionTarget) {
                QuestionTarget.ITEMS -> bikeComparisonsMatrixes[ans.tableNumber].changeValue(ans.firstItemId,ans.secondItemId,ans.score.toFloat());
                QuestionTarget.FEATURES -> featureMatrix.changeValue(ans.firstItemId,ans.secondItemId,ans.score.toFloat());
            }
        }

        val featurePriorities = featureMatrix.extractPriorities();
        val evaluatedScores = Array<Float>(bikes.size){0f};

        for(compMatrixInd in bikeComparisonsMatrixes.indices)
        {
            val localPriorities =bikeComparisonsMatrixes[compMatrixInd].extractPriorities();
            for(bikeInd in localPriorities.indices)
            {
                evaluatedScores[bikeInd] += localPriorities[bikeInd]*featurePriorities[compMatrixInd];
            }
        }
        val outputRanking = PriorityQueue<Score>();
        for(i in evaluatedScores.indices)
            outputRanking.add(Score(bikes[i],evaluatedScores[i]))

        return outputRanking.toList();
    }
}