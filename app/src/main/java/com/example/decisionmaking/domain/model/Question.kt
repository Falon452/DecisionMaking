package com.example.decisionmaking.domain.model

data class Question(
    val row: Int,
    val column: Int,
    val tableNumber: Int,
    val question: String,
)
