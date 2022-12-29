package com.example.decisionmaking.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.presentation.input.viewmodel.InputBikeViewModel
import com.example.decisionmaking.presentation.main.viewmodel.MainViewModel

object Injector {

    val InputBikeViewModel: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return InputBikeViewModel(
                repo = DataDI.repo,
            ) as T }
    }
    val MainViewModel: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return MainViewModel(
                repo = DataDI.repo,
            ) as T }
    }


}