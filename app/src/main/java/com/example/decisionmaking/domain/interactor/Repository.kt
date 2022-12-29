package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import kotlinx.coroutines.flow.Flow


interface Repository {

    fun addBike(bike: Bike)

    fun getBikes(): List<Bike>?

    fun getAnswers(): List<Answer>?

    fun addAnswer(answer: Answer)

    fun observe(): Flow<List<Bike>?>
}

