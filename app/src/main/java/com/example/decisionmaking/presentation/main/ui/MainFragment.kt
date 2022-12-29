package com.example.decisionmaking.presentation.main.ui

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentMainBinding
import com.example.decisionmaking.domain.model.BikeType
import com.example.decisionmaking.presentation.main.adapter.MainAdapter
import com.example.decisionmaking.presentation.input.viewmodel.InputBikeViewModel
import com.example.decisionmaking.presentation.main.router.MainRouter
import com.example.decisionmaking.presentation.main.viewmodel.MainViewModel
import com.example.decisionmaking.presentation.ui.Injector
import com.example.decisionmaking.presentation.util.viewBinding
import kotlinx.coroutines.flow.onEach


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val recyclerAdapter by lazy {
        MainAdapter()
    }
    private val viewModel: MainViewModel by viewModels {
        Injector.MainViewModel
    }
    private val router by lazy {
        MainRouter(findNavController())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setListeners()
        setObservers()
    }

    private fun setViews() {
        setRecycler()
    }

    private fun setRecycler() {
        binding.recyclerView.adapter = recyclerAdapter
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner) {
            recyclerAdapter.submitList(it)
        }
    }

    private fun setListeners() {
        with(binding) {
            addBikeButton.setOnClickListener {
                viewModel.onAddButtonClicked(router)
            }
            startQuestions.setOnClickListener {
                viewModel.onStartClicked(router)
            }
        }
    }
}
