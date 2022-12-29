package com.example.decisionmaking.presentation.main.router

import androidx.navigation.NavController
import com.example.decisionmaking.presentation.main.ui.MainFragmentDirections

internal class MainRouter(
    private val navController: NavController
) {

    fun navigateToInputBike() {
        navController.navigate(
            MainFragmentDirections.navigateToInputBikeFragment()
        )

    }

    fun navigateToQuestions() {
        navController.navigate(
            MainFragmentDirections.navigateToQuestionsFragment()
        )
    }
}