package com.example.decisionmaking.presentation.result.ui

import com.example.decisionmaking.domain.model.Score

interface ResultContract {

    interface ResultPresenter {

        fun setView(view: ResultView)
    }

    interface ResultView {
        fun setResults(scores: List<Score>)
    }
}