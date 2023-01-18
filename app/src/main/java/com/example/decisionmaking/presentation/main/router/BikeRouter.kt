package com.example.decisionmaking.presentation.main.router

import androidx.navigation.NavController
import com.example.decisionmaking.presentation.main.ui.BikeFragmentDirections

internal class BikeRouter(
    private val navController: NavController
) {

    fun navigateToInputBike() {
        navController.navigate(
            BikeFragmentDirections.navigateToInputBike()
        )

    }

    fun navigateToAgents() {
        navController.navigate(
            BikeFragmentDirections.navigateToAgents()
        )
    }
}