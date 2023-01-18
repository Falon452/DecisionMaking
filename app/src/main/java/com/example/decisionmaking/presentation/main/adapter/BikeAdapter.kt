package com.example.decisionmaking.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.decisionmaking.databinding.ItemBinding
import com.example.decisionmaking.domain.model.Bike
import com.example.decisionmaking.presentation.util.BaseViewHolder
import com.example.decisionmaking.presentation.util.BindingViewHolder
import com.example.decisionmaking.presentation.util.ItemDiffer

class BikeAdapter: ListAdapter<Bike, BaseViewHolder<Bike>>(
    ItemDiffer(Bike::id)
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Bike> =
        ItemViewHolder(parent)


    override fun onBindViewHolder(holder: BaseViewHolder<Bike>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(private val parent: ViewGroup) :
        BindingViewHolder<Bike, ItemBinding>(
            ItemBinding::inflate,
            parent
        ) {

        override fun ItemBinding.bind(item: Bike) {
            with(item) {
                nameTextView.text = name
                priceTextView.text = price.plus("$")
                weightTextView.text = weight.plus("kg")
                gearsTextView.text = numberOfGears
            }
        }
    }

}