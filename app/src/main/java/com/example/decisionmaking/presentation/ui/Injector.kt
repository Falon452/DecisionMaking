package com.example.decisionmaking.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.presentation.agent.mapper.AgentSelector
import com.example.decisionmaking.presentation.input.viewmodel.InputBikeViewModel
import com.example.decisionmaking.presentation.main.viewmodel.AgentViewModel
import com.example.decisionmaking.presentation.main.viewmodel.BikeViewModel

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
    val BikeViewModel: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return BikeViewModel(
                repo = DataDI.repo,
            ) as T }
    }
    val AgentViewModel: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return AgentViewModel(
                repo = DataDI.repo,
                agentSelector = AgentSelector(),
            ) as T }
    }



}