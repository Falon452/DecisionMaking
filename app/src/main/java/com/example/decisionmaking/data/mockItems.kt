package com.example.decisionmaking.data

import com.example.decisionmaking.domain.model.BikeType
import com.example.decisionmaking.domain.model.Item


val emptyItems = emptyList<Item>()

val bikeItems = listOf(
    Item(name = "my bike", BikeType.MOUNTAIN),
    Item(name = "roadyy", BikeType.ROAD),
)