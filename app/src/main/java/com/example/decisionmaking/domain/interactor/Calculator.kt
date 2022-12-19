package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.domain.model.Question
import com.example.decisionmaking.domain.model.Score

class Calculator(
    private val repository: Repository
) {

    fun getQuestions() : List<Question> {
        val bikes: List<Bike>? = repository.getBikes()
        if (bikes != null) {

        }
        return emptyList()
    }

    fun calculate() : List<Score> =
        emptyList()
}