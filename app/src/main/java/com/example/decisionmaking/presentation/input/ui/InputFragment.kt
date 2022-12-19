package com.example.decisionmaking.presentation.input.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentInputBinding
import com.example.decisionmaking.domain.model.BikeType
import com.example.decisionmaking.presentation.input.adapter.InputAdapter
import com.example.decisionmaking.presentation.input.viewmodel.InputViewModel
import com.example.decisionmaking.presentation.ui.Injector
import com.example.decisionmaking.presentation.util.viewBinding


class InputFragment : Fragment(R.layout.fragment_input) {

    private val binding by viewBinding(FragmentInputBinding::bind)
    private val recyclerAdapter by lazy {
        InputAdapter()
    }
    private val viewModel: InputViewModel by viewModels {
        Injector.InputViewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setListeners()
        setObservers()
    }

    private fun setViews() {
        setRecycler()
        setSpinner()
    }

    private fun setRecycler() {
        binding.recyclerView.adapter = recyclerAdapter
    }

    private fun setSpinner() {
        with(binding.addItemLayout.typeSpinner) {
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                BikeType.values(),
            )
                .also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
                .also { adapter = it }
        }
    }

    private fun setObservers() {
//        viewModel.viewState.observe(viewLifecycleOwner) {
//            recyclerAdapter.submitList(it.items)
//            binding.bestItem.nameTextView.text = it.bestItem?.name
//            binding.bestItem.typeTextView.text = it.bestItem?.bikeType?.name
//        }
    }

    private fun setListeners() {
        with(binding) {
            bestBikeButton.setOnClickListener {
                viewModel.onBestBikeButton()
            }
            addItemLayout.addButton.setOnClickListener {
                viewModel.onAddButtonClicked(
                    editText = addItemLayout.nameEditText,
                    bikeType = addItemLayout.typeSpinner.selectedItem as BikeType
                )
            }

        }
    }
}
