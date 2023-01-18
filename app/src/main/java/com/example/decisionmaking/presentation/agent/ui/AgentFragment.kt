package com.example.decisionmaking.presentation.agent.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentAgentsBinding
import com.example.decisionmaking.presentation.agent.adapter.AgentAdapter
import com.example.decisionmaking.presentation.agent.router.AgentRouter
import com.example.decisionmaking.presentation.main.viewmodel.AgentViewModel
import com.example.decisionmaking.presentation.ui.Injector
import com.example.decisionmaking.presentation.util.viewBinding


class AgentFragment : Fragment(R.layout.fragment_agents) {

    private val binding by viewBinding(FragmentAgentsBinding::bind)
    private val recyclerAdapter by lazy {
        AgentAdapter()
    }
    private val viewModel: AgentViewModel by viewModels {
        Injector.AgentViewModel
    }
    private val router by lazy {
        AgentRouter(findNavController())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setListeners()
        setObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun setViews() {
        setRecycler()
    }

    private fun setRecycler() {
        binding.recyclerView.adapter = recyclerAdapter
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            binding.startQuestions.isEnabled = state?.any { it.isSelected } == true
            binding.getResults.isEnabled = state?.all { it.finishedQuestions } == true
            recyclerAdapter.submitList(state)
        }
    }

    private fun setListeners() {
        with(binding) {
            addButton.setOnClickListener {
                viewModel.onAddButtonClicked(binding.nameAdd)
                binding.nameAdd.text.clear()
            }
            startQuestions.setOnClickListener {
                viewModel.goToQuestions(router)
            }
            recyclerAdapter.function = { viewModel.onSelectClicked(it) }
            getResults.setOnClickListener { viewModel.onResultClicked(router) }
        }
    }
}
