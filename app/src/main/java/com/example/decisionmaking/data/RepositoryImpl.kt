package com.example.decisionmaking.data

import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryImpl : Repository {

    private val cacheBike = MutableStateFlow<List<Bike>?>(null)
    private val cacheAnswer = MutableStateFlow<List<Answer>?>(null)

    override fun addBike(bike: Bike) {
        cacheBike.tryEmit(
            cacheBike.value?.plus(bike) ?: listOf(bike)
        )
    }

    override fun getBikes(): List<Bike>? =
        cacheBike.value

    override fun getAnswers(): List<Answer>? =
        cacheAnswer.value

    override fun addAnswer(answer: Answer) {
        cacheAnswer.tryEmit(
            cacheAnswer.value?.plus(answer) ?: listOf(answer)
        )
    }

    override fun observe(): Flow<List<Bike>?> =
        cacheBike

}