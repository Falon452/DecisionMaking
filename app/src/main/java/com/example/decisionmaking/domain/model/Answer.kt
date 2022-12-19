package com.example.decisionmaking.domain.model


data class Answer(
    val score: Int,
    val row: Int,
    val column: Int,
    val tableNumber: Int,
)