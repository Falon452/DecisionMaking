package com.example.decisionmaking.presentation.input.viewmodel


import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.decisionmaking.domain.interactor.AddItemUseCase
import com.example.decisionmaking.domain.interactor.GetBestBikeButtonUseCase
import com.example.decisionmaking.domain.interactor.GetItemsUseCase
import com.example.decisionmaking.domain.model.BikeType
import com.example.decisionmaking.domain.model.Item
import com.example.decisionmaking.presentation.input.state.InputState
import com.example.decisionmaking.presentation.util.NullSafeMutableLiveData
import com.example.decisionmaking.presentation.util.reduce

internal class InputViewModel(
    private val addItemUseCase: AddItemUseCase,
    getItemsUseCase: GetItemsUseCase,
    private val getBestBikeButtonUseCase: GetBestBikeButtonUseCase
) : ViewModel() {

    private val state = NullSafeMutableLiveData(
        InputState(
            items = getItemsUseCase.run()
        )
    )
    val viewState: LiveData<InputState> = state


    fun onAddButtonClicked(
        editText: EditText,
        bikeType: BikeType,
    ) {
        val newItem = Item(
            name = editText.text.toString(),
            bikeType = bikeType,
        )
        addItemUseCase.run(newItem)
        state.reduce {
            it.copy(
                items = it.items.plus(newItem)
            )
        }
    }

    fun onBestBikeButton() {
        state.reduce {
            it.copy(
                bestItem = getBestBikeButtonUseCase.run()
            )
        }
    }
}
