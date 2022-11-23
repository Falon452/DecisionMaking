package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Item

interface Repository {

    fun getItems(): List<Item>

    fun addItem(item: Item)
}
