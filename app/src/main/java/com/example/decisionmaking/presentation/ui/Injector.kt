package com.example.decisionmaking.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.domain.di.DomainDI
import com.example.decisionmaking.presentation.input.viewmodel.InputViewModel

object Injector {

    private val dataDI = DataDI()
    private val domainDI = DomainDI(dataDI)

    val InputViewModelFactory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return InputViewModel(
                addItemUseCase = domainDI.provideAddItemUseCase(),
                getItemsUseCase = domainDI.provideGetItemUseCase(),
                getBestBikeButtonUseCase = domainDI.provideGetBestBikeButtonUseCase()
            ) as T
        }
    }



}