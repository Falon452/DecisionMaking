package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Item

class GetItemsUseCase(
    private val repository: Repository,
) {

    fun run() : List<Item> = repository.getItems()
}
