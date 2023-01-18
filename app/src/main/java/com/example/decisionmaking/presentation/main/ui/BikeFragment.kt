package com.example.decisionmaking.presentation.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentBikesBinding
import com.example.decisionmaking.presentation.agent.adapter.AgentAdapter
import com.example.decisionmaking.presentation.main.adapter.BikeAdapter
import com.example.decisionmaking.presentation.main.router.BikeRouter
import com.example.decisionmaking.presentation.main.viewmodel.AgentViewModel
import com.example.decisionmaking.presentation.main.viewmodel.BikeViewModel
import com.example.decisionmaking.presentation.ui.Injector
import com.example.decisionmaking.presentation.util.viewBinding


class BikeFragment : Fragment(R.layout.fragment_bikes) {

    private val binding by viewBinding(FragmentBikesBinding::bind)
    private val recyclerAdapter by lazy {
        BikeAdapter()
    }
    private val viewModel: BikeViewModel by viewModels {
        Injector.BikeViewModel
    }
    private val router: BikeRouter by lazy {
        BikeRouter(findNavController())
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
        viewModel.agents.observe(viewLifecycleOwner) { it ->
            if (it != null)
                binding.addBikeButton.isEnabled = it.all { !it.finishedQuestions }
        }

    }

    private fun setListeners() {
        with(binding) {
            addBikeButton.setOnClickListener {
                viewModel.onAddButtonClicked(router)
            }
            goToAgents.setOnClickListener {
                viewModel.onStartClicked(router)
            }
        }
    }
}
