package com.example.decisionmaking.presentation.result.presenter

import com.example.decisionmaking.domain.interactor.Calculator
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Answer
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.domain.model.FeatureType
import com.example.decisionmaking.domain.model.QuestionTarget
import com.example.decisionmaking.domain.model.QuestionTarget.FEATURES
import com.example.decisionmaking.domain.model.QuestionTarget.ITEMS
import com.example.decisionmaking.domain.model.Score
import com.example.decisionmaking.presentation.result.ui.ResultContract.ResultPresenter
import com.example.decisionmaking.presentation.result.ui.ResultContract.ResultView

class ResultPresenter(private val repo: Repository) : ResultPresenter {

    private lateinit var view: ResultView

    private val calculator = Calculator(
        listOf(
            FeatureType.WEIGHT,
            FeatureType.PRICE,
            FeatureType.GEARS,
        ),
        bikes = repo.getBikes().orEmpty(),
    )

    override fun setView(view: ResultView) {
        this.view = view
        val answers = repo.getAnswers().orEmpty()
        val scores = calculator.calculate(answers)
        view.setResults(
            scores.sortedByDescending(Score::score)
        )
    }
}
