package com.example.decisionmaking.presentation.main.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Agent
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.presentation.main.router.BikeRouter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class BikeViewModel(
    val repo: Repository,
) : ViewModel() {

    val state: MutableLiveData<List<Bike>?> = MutableLiveData(null)
    val agents: MutableLiveData<List<Agent>?> = MutableLiveData(null)

    init {
        viewModelScope.launch {
            repo.observeBikes()
                .onEach {
                    state.value = it
                }
                .launchIn(this)
            repo.observeAgents()
                .onEach {
                    agents.value = it
                }
                .launchIn(this)

        }
    }

    fun onAddButtonClicked(router: BikeRouter) {
        router.navigateToInputBike()
    }

    fun onStartClicked(router: BikeRouter) {
        router.navigateToAgents()
    }
}
