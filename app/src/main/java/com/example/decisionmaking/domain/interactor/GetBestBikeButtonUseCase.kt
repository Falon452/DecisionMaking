package com.example.decisionmaking.domain.interactor

import com.example.decisionmaking.domain.model.Item

class GetBestBikeButtonUseCase(
    private val repository: Repository,
) {

    fun run(): Item {
        val items = repository.getItems() // TODO calculate best bike
        return items[0]
    }
}
