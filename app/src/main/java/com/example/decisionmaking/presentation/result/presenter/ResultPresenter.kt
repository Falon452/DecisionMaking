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
    val numberOfAgents = checkNotNull(repo.getAgents()).size
    private val calculator = Calculator(
        listOf(
            FeatureType.WEIGHT,
            FeatureType.PRICE,
            FeatureType.GEARS,
        ),
        bikes = repo.getBikes().orEmpty(),
        agentsNumber = numberOfAgents,
    )

    override fun setView(view: ResultView) {
        this.view = view
        val answers: List<Answer> = repo.getAnswers().orEmpty()
        val listOfAnswers = mutableListOf<List<Answer>>()
        for (i in 1..numberOfAgents) {
            listOfAnswers.add(answers.filter{it.agentId == i})
        }
        val scores = calculator.calculate(listOfAnswers)
        view.setResults(
            scores.sortedByDescending(Score::score)
        )
    }
}
