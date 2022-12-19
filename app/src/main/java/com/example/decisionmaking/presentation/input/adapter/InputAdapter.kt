package com.example.decisionmaking.presentation.input.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.decisionmaking.databinding.ItemBinding
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.presentation.util.BaseViewHolder
import com.example.decisionmaking.presentation.util.BindingViewHolder
import com.example.decisionmaking.presentation.util.ItemDiffer

class InputAdapter: ListAdapter<Bike, BaseViewHolder<Bike>>(
    ItemDiffer(Bike::id)
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Bike> =
        ItemViewHolder(parent)


    override fun onBindViewHolder(holder: BaseViewHolder<Bike>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(parent: ViewGroup) :
        BindingViewHolder<Bike, ItemBinding>(
            ItemBinding::inflate,
            parent
        ) {

        override fun ItemBinding.bind(item: Bike) {
            with(item) {
                nameTextView.text = item.id.toString()
            }
        }
    }

}