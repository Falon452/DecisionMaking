package com.example.decisionmaking.presentation.input.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.decisionmaking.databinding.ItemBinding
import com.example.decisionmaking.domain.model.Item
import com.example.decisionmaking.presentation.util.BaseViewHolder
import com.example.decisionmaking.presentation.util.BindingViewHolder
import com.example.decisionmaking.presentation.util.ItemDiffer

class InputAdapter: ListAdapter<Item, BaseViewHolder<Item>>(
    ItemDiffer(Item::name)
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> =
        ItemViewHolder(parent)


    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(parent: ViewGroup) :
        BindingViewHolder<Item, ItemBinding>(
            ItemBinding::inflate,
            parent
        ) {

        override fun ItemBinding.bind(item: Item) {
            with(item) {
                nameTextView.text = item.name
                typeTextView.text = item.bikeType.name
            }
        }
    }

}