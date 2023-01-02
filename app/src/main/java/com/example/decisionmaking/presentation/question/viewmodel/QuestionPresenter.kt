package com.example.decisionmaking.presentation.question.viewmodel

import com.example.decisionmaking.databinding.FragmentQuestionBinding
import com.example.decisionmaking.domain.interactor.Calculator
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.FeatureType
import com.example.decisionmaking.domain.model.Question
import com.example.decisionmaking.presentation.question.viewmodel.QuestionContract.QuestionPresenter


internal class QuestionPresenter(
    private val repo: Repository,
) : QuestionPresenter {

    private lateinit var view: QuestionContract.QuestionView
    private val calculator = Calculator(
        listOf(
            FeatureType.WEIGHT,
            FeatureType.PRICE,
            FeatureType.GEARS,
        ),
        bikes = repo.getBikes() ?: emptyList()
    )
    private val questions: List<Question> = calculator.getQuestions()
    private var questionIndex = 0
    private val currentQuestion: Question
        get() = questions[questionIndex]

    override fun setView(view: QuestionContract.QuestionView) {
        this.view = view
        view.setNewQuestion(currentQuestion.questionText)
    }

    override fun onNextQuestionClicked(binding: FragmentQuestionBinding) {
        val score = with(binding) {
            when (radioGroup.checkedRadioButtonId) {
                scaleLeft5.id -> 6
                scaleLeft4.id -> 5
                scaleLeft3.id -> 4
                scaleLeft2.id -> 3
                scaleLeft1.id -> 2
                scale0.id -> 1
                scaleRight1.id -> 1/2
                scaleRight2.id -> 1/3
                scaleRight3.id -> 1/4
                scaleRight4.id -> 1/5
                scaleRight5.id -> 1/6
                else -> {
                    view.showToast("Please select scale")
                    return
                }
            }
        }
        repo.addAnswer(
            currentQuestion.createAnswer(score)
        )

        if (isLastQuestion()) {
            view.navigateToResult()
        } else {
            setNewQuestion()
        }
    }

    private fun isLastQuestion(): Boolean =
        questions.size - 1 == questionIndex


    private fun setNewQuestion() {
        view.unCheckAllRadioButtons()
        questionIndex++
        view.setNewQuestion(currentQuestion.questionText)
    }
}