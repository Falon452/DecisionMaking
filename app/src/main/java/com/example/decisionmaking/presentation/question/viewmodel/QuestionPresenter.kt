package com.example.decisionmaking.presentation.question.viewmodel

import com.example.decisionmaking.databinding.FragmentQuestionBinding
import com.example.decisionmaking.domain.interactor.Calculator
import com.example.decisionmaking.domain.interactor.Repository
import com.example.decisionmaking.domain.model.Answer
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
                scaleLeft5.id -> 0
                scaleLeft4.id -> 1
                scaleLeft3.id -> 2
                scaleLeft2.id -> 3
                scaleLeft1.id -> 4
                scale0.id -> 5
                scaleRight1.id -> 6
                scaleRight2.id -> 7
                scaleRight3.id -> 8
                scaleRight4.id -> 9
                scaleRight5.id -> 10
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
        view.setNewQuestion(currentQuestion.questionText)
        questionIndex++
    }
}