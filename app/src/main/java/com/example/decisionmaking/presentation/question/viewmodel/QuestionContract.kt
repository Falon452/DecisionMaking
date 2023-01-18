package com.example.decisionmaking.presentation.question.viewmodel

import com.example.decisionmaking.databinding.FragmentQuestionBinding

interface QuestionContract {

    interface QuestionPresenter {

        fun setView(view: QuestionView)

        fun onNextQuestionClicked(binding: FragmentQuestionBinding)
    }

    interface QuestionView {

        fun unCheckAllRadioButtons()
        fun setNewQuestion(text: String)
        fun showToast(text: String)
        fun navigateUp()
    }
}