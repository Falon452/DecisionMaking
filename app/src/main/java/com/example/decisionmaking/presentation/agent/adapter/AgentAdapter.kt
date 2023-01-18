package com.example.decisionmaking.presentation.agent.adapter

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.decisionmaking.R
import com.example.decisionmaking.databinding.ItemAgentBinding
import com.example.decisionmaking.databinding.ItemBinding
import com.example.decisionmaking.domain.model.Agent
import com.example.decisionmaking.presentation.util.BaseViewHolder
import com.example.decisionmaking.presentation.util.BindingViewHolder
import com.example.decisionmaking.presentation.util.ItemDiffer

class AgentAdapter: ListAdapter<Agent, BaseViewHolder<Agent>>(
    ItemDiffer(Agent::id)
) {
    var function: ((Agent) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Agent> =
        ItemViewHolder(parent)


    override fun onBindViewHolder(holder: BaseViewHolder<Agent>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(parent: ViewGroup) :
        BindingViewHolder<Agent, ItemAgentBinding>(
            ItemAgentBinding::inflate,
            parent
        ) {

        override fun ItemAgentBinding.bind(item: Agent) {
            with(item) {
                nameTextView.text = name

                select.setOnClickListener {

                    function?.invoke(getItem(layoutPosition)).also {
                        println(layoutPosition)
                        println(getItem(layoutPosition))
                    }
                }
                select.isEnabled = !item.finishedQuestions

                if (item.isSelected)
                    nameTextView.setBackgroundColor(Color.parseColor("#FF00BCD4"))
            }
        }
    }

}