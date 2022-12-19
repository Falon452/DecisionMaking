package com.example.decisionmaking.presentation.question

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.FragmentQuestionBinding
import com.example.decisionmaking.presentation.util.viewBinding

class QuestionFragment : Fragment(R.layout.fragment_question) {

    private val binding by viewBinding(FragmentQuestionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.scale.setOnCheckedChangeListener { radiogroup, id ->
            when(id) {
                binding.scale1.id -> println("scale1")
                binding.scale2.id -> println("scale2")
                binding.scale3.id -> println("scale3")
                binding.scale4.id -> println("scale4")
                binding.scale5.id -> println("scale5")
                binding.scale6.id -> println("scale6")
                binding.scale7.id -> println("scale7")
                binding.scale8.id -> println("scale8")
                binding.scale9.id -> println("scale9")
                binding.scale10.id -> println("scale10")
            }

        }
    }
}