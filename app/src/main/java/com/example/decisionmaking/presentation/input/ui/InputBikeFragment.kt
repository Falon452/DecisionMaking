package com.example.decisionmaking.presentation.input.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentAddItemBinding
import com.example.decisionmaking.presentation.input.viewmodel.InputBikeViewModel
import com.example.decisionmaking.presentation.ui.Injector
import com.example.decisionmaking.presentation.util.viewBinding


class InputBikeFragment : Fragment(R.layout.fragment_add_item) {

    private val binding by viewBinding(FragmentAddItemBinding::bind)
    private val viewModel: InputBikeViewModel by viewModels {
        Injector.InputBikeViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setListeners()
        setObservers()
    }

    private fun setViews() {
    }

    private fun setObservers() {
    }

    private fun setListeners() {
        with(binding) {
            addButton.setOnClickListener {
                viewModel.onAddButtonClicked(
                    nameEditText.text.toString(),
                    weightEditText.text.toString(),
                    numberOfGearsEditText.text.toString(),
                    priceEditText.text.toString(),
                    findNavController(),
                )
            }
        }
    }
}
