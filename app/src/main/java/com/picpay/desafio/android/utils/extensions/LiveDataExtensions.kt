package com.picpay.desafio.android.utils.extensions

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.updateAsync(callback: T.() -> T) {
    this.value?.let {
        val newValue = callback(it)
        this.postValue(newValue)
    }
}