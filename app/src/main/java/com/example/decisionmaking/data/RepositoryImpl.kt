package com.example.decisionmaking.data

import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryImpl : Repository {

    private val cacheBike = MutableStateFlow<List<Bike>?>(null)
    private val cacheAnswer = MutableStateFlow<List<Answer>?>(null)

    override fun addBikes(bikes: List<Bike>) {
        cacheBike.tryEmit(bikes)
    }

    override fun getBikes(): List<Bike>? =
        cacheBike.value

    override fun getAnswers(): List<Answer>? =
        cacheAnswer.value

    override fun addAnswers(answers: List<Answer>) {
        cacheAnswer.tryEmit(answers)
    }

}