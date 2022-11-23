package com.example.decisionmaking.presentation.util

import androidx.lifecycle.MutableLiveData

class NullSafeMutableLiveData<T>(value: T) : MutableLiveData<T>(value) {

    override fun getValue(): T = checkNotNull(super.getValue())
}

fun <T> NullSafeMutableLiveData<T>.reduce(block: (T) -> T) {
    this.value =  block(this.value)
}
