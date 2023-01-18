package com.example.decisionmaking.presentation.agent.mapper

import com.example.decisionmaking.domain.model.Agent

class AgentSelector {

    fun select(agent: Agent, selectedAgent: Agent): Agent =
        agent.copy(
            isSelected = agent.id == selectedAgent.id
        )
}