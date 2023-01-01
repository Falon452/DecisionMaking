package com.example.decisionmaking.presentation.input.viewmodel


import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.presentation.main.ui.MainFragmentDirections

internal class InputBikeViewModel(
    val repo: Repository,
) : ViewModel() {

    fun onAddButtonClicked(
        name: String,
        weight: String,
        numberOfGears: String,
        price: String,
        navController: NavController,
    ) {
        repo.addBike(
            Bike(
                id = name.hashCode() + weight.hashCode() + numberOfGears.hashCode(),
                weight = weight,
                name = name,
                numberOfGears = numberOfGears,
                price = price,
            )
        )
        navController.navigateUp()
    }
}
