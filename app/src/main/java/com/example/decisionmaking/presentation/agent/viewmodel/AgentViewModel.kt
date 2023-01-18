package com.example.decisionmaking.presentation.main.viewmodel


import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Agent
import com.example.decisionmaking.presentation.agent.mapper.AgentSelector
import com.example.decisionmaking.presentation.agent.router.AgentRouter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class AgentViewModel(
    val repo: Repository,
    val agentSelector: AgentSelector,
) : ViewModel() {

    val state: MutableLiveData<List<Agent>?> = MutableLiveData(null)
    private val nextIdAgent: Int
        get() = (state.value?.size?.plus(1)) ?: 1
    init {
        viewModelScope.launch {
            repo.observeAgents()
                .onEach {
                    state.value = it
                }
                .launchIn(this)
        }

    }

    fun onResume() {
        if (state.value != null)
            onSelectClicked(Agent("to uncheck agent when entrig", 2412341))
    }

    fun onAddButtonClicked(nameAdd: EditText) {
        repo.addAgent(Agent(nameAdd.text.toString(), nextIdAgent))
    }

    fun goToQuestions(router: AgentRouter) {
        router.navigateToQuestions()
    }

    fun onResultClicked(router: AgentRouter) {
        router.navigateToResults()
    }

    fun onSelectClicked(selectedAgent: Agent) {
        state.value = state.value?.map {
            agentSelector.select(it, selectedAgent)
        }
        repo.replaceAgents(checkNotNull(state.value))
    }
}
