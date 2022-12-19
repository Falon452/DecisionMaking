package com.example.decisionmaking.domain.model


data class Answer(
    val score: Int,
    val firstItemId: Int,
    val secondItemId: Int,
    val tableNumber: Int,
    val questionTarget: QuestionTarget
)