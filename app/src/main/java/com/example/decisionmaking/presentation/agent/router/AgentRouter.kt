package com.example.decisionmaking.presentation.agent.router

import androidx.navigation.NavController
import com.example.decisionmaking.presentation.agent.ui.AgentFragmentDirections

internal class AgentRouter(
    private val navController: NavController
) {

    fun navigateToQuestions() {
        navController.navigate(
            AgentFragmentDirections.navigateToQuestionsFragment()
        )
    }

    fun navigateToResults() {
        navController.navigate(
            AgentFragmentDirections.navigateToResult()
        )
    }
}