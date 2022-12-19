package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike


interface Repository {

    fun addBikes(bikes: List<Bike>)

    fun getBikes(): List<Bike>?

    fun getAnswers(): List<Answer>?

    fun addAnswers(answers: List<Answer>)
}

