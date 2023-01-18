package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Agent
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import kotlinx.coroutines.flow.Flow


interface Repository {

    fun addBike(bike: Bike)

    fun addAgent(agent: Agent)
    fun replaceAgents(agents: List<Agent>)

    fun getBikes(): List<Bike>?

    fun getAnswers(): List<Answer>?

    fun addAnswer(answer: Answer)

    fun observeBikes(): Flow<List<Bike>?>
    fun observeAgents(): Flow<List<Agent>?>
    fun getAgents(): List<Agent>?
}

