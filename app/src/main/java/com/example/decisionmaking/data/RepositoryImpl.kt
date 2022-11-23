package com.example.decisionmaking.data

import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Item
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryImpl : Repository {

    private val cache = MutableStateFlow(bikeItems)

    override fun getItems(): List<Item> =
        cache.value

    override fun addItem(item: Item) {
        cache.tryEmit(cache.value.plus(item))
    }
}