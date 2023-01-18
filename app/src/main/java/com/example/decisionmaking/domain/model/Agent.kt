package com.example.decisionmaking.domain.model

data class Agent(
    val name: String,
    val id: Int,
    val isSelected: Boolean = false,
    val finishedQuestions: Boolean = false,
)