package com.example.decisionmaking.domain.di

import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.domain.interactor.AddItemUseCase
import com.example.decisionmaking.domain.interactor.GetBestBikeButtonUseCase
import com.example.decisionmaking.domain.interactor.GetItemsUseCase

class DomainDI(
    private val dataDI: DataDI,
) {

    fun provideAddItemUseCase() = AddItemUseCase(dataDI.provideRepository())

    fun provideGetItemUseCase() = GetItemsUseCase(dataDI.provideRepository())
    fun provideGetBestBikeButtonUseCase() = GetBestBikeButtonUseCase(dataDI.provideRepository())
}