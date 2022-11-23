package com.example.decisionmaking.presentation.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<in T>(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)
}

class ItemDiffer<T : Any>(private val getIdentifier: (T) -> Any) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        getIdentifier(oldItem) == getIdentifier(newItem)

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}

abstract class BindingViewHolder<in T, V : ViewBinding>(
    inflate: (inflater: LayoutInflater, container: ViewGroup, attach: Boolean) -> V,
    parent: ViewGroup,
    @StyleRes theme: Int = 0,
    protected val viewBinding: V =
        parent.context.wrapInTheme(theme)
            .let { context -> LayoutInflater.from(context) }
            .let { inflater -> inflate(inflater, parent, false) }
) : BaseViewHolder<T>(viewBinding.root) {

    val containerView: View
        get() = viewBinding.root

    final override fun bind(item: T) {
        viewBinding.bind(item)
    }

    abstract fun V.bind(item: T)
}

private fun Context.wrapInTheme(@StyleRes theme: Int = 0): Context =
    if (theme != 0) {
        ContextThemeWrapper(this, theme)
    } else {
        this
    }
