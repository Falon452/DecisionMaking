package com.example.decisionmaking.presentation.input.state

import com.example.decisionmaking.domain.model.Item

data class InputState(
    val items: List<Item>,
    val bestItem: Item? = null,
)
