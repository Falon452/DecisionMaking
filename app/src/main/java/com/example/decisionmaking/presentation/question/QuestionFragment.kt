package com.example.decisionmaking.presentation.question

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentQuestionBinding
import com.example.decisionmaking.di.DataDI
import com.example.decisionmaking.presentation.question.viewmodel.QuestionContract
import com.example.decisionmaking.presentation.question.viewmodel.QuestionContract.QuestionView
import com.example.decisionmaking.presentation.question.viewmodel.QuestionPresenter
import com.example.decisionmaking.presentation.util.viewBinding
import java.time.Duration

class QuestionFragment : Fragment(R.layout.fragment_question), QuestionView {

    private val binding by viewBinding(FragmentQuestionBinding::bind)
    private val presenter: QuestionContract.QuestionPresenter = QuestionPresenter(
        DataDI.repo
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextQuestionButton.setOnClickListener {
            presenter.onNextQuestionClicked(binding)
        }
        presenter.setView(this)
    }

    override fun setNewQuestion(text: String) {
        binding.question.setText(text)
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun unCheckAllRadioButtons() {
        binding.radioGroup.clearCheck()
    }

    override fun navigateToResult() {
        findNavController().navigate(QuestionFragmentDirections.navigateToResult())
    }

}