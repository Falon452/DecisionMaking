package com.example.decisionmaking.domain.model

data class Bike(
    val id: Int,
    val weight: Int,
    val name: String,
    val features: Map<Features,String>
)
