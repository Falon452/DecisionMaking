package com.example.decisionmaking.domain.di

import com.example.decisionmaking.di.DataDI

class DomainDI(
    private val dataDI: DataDI,
) {

    fun provideAddItemUseCase() = AddItemUseCase(dataDI.provideRepository())
    fun provideGetItemUseCase() = GetItemsUseCase(dataDI.provideRepository())
    fun provideGetBestBikeButtonUseCase() = GetBestBikeButtonUseCase(dataDI.provideRepository())
}