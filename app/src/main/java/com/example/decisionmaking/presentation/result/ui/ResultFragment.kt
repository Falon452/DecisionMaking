package com.example.decisionmaking.presentation.result.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentResultBinding
import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.domain.model.Score
import com.example.decisionmaking.presentation.result.adapter.ResultAdapter
import com.example.decisionmaking.presentation.result.presenter.ResultPresenter
import com.example.decisionmaking.presentation.result.ui.ResultContract.ResultView
import com.example.decisionmaking.presentation.util.viewBinding


class ResultFragment : Fragment(R.layout.fragment_result), ResultView{

    private val presenter = ResultPresenter(DataDI.repo)
    private val adapter = ResultAdapter()
    private val binding by viewBinding(FragmentResultBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setRecycler()
    }

    private fun setViews() {
        presenter.setView(this)
    }

    private fun setRecycler() {
        binding.recyclerView.adapter = adapter
    }

    override fun setResults(scores: List<Score>) {
        adapter.submitList(scores)
    }
}
