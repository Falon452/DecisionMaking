package com.example.decisionmaking.data

import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Agent
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryImpl : Repository {

    private val cacheBike = MutableStateFlow<List<Bike>?>(null)
    private val cacheAgent = MutableStateFlow<List<Agent>?>(null)
    private val cacheAnswer = MutableStateFlow<List<Answer>?>(null)
    private val cacheAnswers = MutableStateFlow<List<List<Answer>>?>(null)

    override fun addBike(bike: Bike) {
        cacheBike.tryEmit(
            cacheBike.value?.plus(bike) ?: listOf(bike)
        )
    }


    override fun addAgent(agent: Agent) {
        cacheAgent.tryEmit(
            cacheAgent.value?.plus(agent) ?: listOf(agent)
        )

    }

    override fun replaceAgents(agents: List<Agent>) {
        cacheAgent.value = agents
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

    override fun observeBikes(): Flow<List<Bike>?> =
        cacheBike

    override fun observeAgents(): Flow<List<Agent>?> =
        cacheAgent

    override fun getAgents(): List<Agent>? =
        cacheAgent.value


}