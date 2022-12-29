package com.example.decisionmaking.presentation.main.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.presentation.main.router.MainRouter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class MainViewModel(
    val repo: Repository,
) : ViewModel() {

    val state: MutableLiveData<List<Bike>?> = MutableLiveData(null)

    init {
        viewModelScope.launch {
            repo.observe()
                .onEach {
                    state.value = it
                }
                .launchIn(this)
        }
    }

    fun onAddButtonClicked(router: MainRouter) {
        router.navigateToInputBike()
    }

    fun onStartClicked(router: MainRouter) {
        router.navigateToQuestions()
    }
}
