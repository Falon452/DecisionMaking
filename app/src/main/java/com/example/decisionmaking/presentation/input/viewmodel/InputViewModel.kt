package com.example.decisionmaking.presentation.input.viewmodel


import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.BikeType
import com.example.decisionmaking.presentation.input.state.InputState
import com.example.decisionmaking.presentation.util.NullSafeMutableLiveData
import com.example.decisionmaking.presentation.util.reduce
import kotlinx.coroutines.flow.MutableStateFlow

internal class InputViewModel(
    val repo: Repository,
) : ViewModel() {

    private val state = MutableStateFlow(null)


    fun onAddButtonClicked(
        editText: EditText,
        bikeType: BikeType,
    ) {
//        val newItem = Item(
//            name = editText.text.toString(),
//            bikeType = bikeType,
//        )
//        addItemUseCase.run(newItem)
//        state.reduce {
//            it.copy(
//                items = it.items.plus(newItem)
//            )
//        }
    }

    fun onBestBikeButton() {
//        state.reduce {
//            it.copy(
//                bestItem = getBestBikeButtonUseCase.run()
//            )
//        }
    }
}
