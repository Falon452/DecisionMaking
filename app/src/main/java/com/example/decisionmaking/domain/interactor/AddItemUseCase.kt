package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Item

class AddItemUseCase(
    private val repository: Repository,
) {

    fun run(item: Item) = repository.addItem(item)
}
