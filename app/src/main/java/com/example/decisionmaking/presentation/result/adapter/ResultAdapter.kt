package com.example.decisionmaking.presentation.result.adapter

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.recyclerview.widget.ListAdapter
import com.example.decisionmaking.databinding.ResultItemBinding
import com.example.decisionmaking.domain.model.Score
import com.example.decisionmaking.presentation.util.BaseViewHolder
import com.example.decisionmaking.presentation.util.BindingViewHolder
import com.example.decisionmaking.presentation.util.ItemDiffer

class ResultAdapter: ListAdapter<Score, BaseViewHolder<Score>>(
    ItemDiffer(Score::bike)
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Score> =
        ItemViewHolder(parent)


    override fun onBindViewHolder(holder: BaseViewHolder<Score>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(parent: ViewGroup) :
        BindingViewHolder<Score, ResultItemBinding>(
            ResultItemBinding::inflate,
            parent
        ) {

        override fun ResultItemBinding.bind(item: Score) {
            val params = LinearLayout.LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                item.score,
            )
//            val view = this@bind.root.findViewById(R.id.scoreTextView) as View
//            view.layoutParams = params

            this@bind.scoreTextView.layoutParams = params
            nameTextView.text = item.bike.name
        }
    }

}