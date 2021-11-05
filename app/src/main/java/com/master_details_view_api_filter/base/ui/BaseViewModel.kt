package com.shohoz.superApp.base.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel


private const val TAG = "BaseViewModel"

open class BaseViewModel : ViewModel() {

    val messages = MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()

    val handler = CoroutineExceptionHandler { _, exception ->
        loader.value = false
        run {
            messages.value = exception.message
            exception.printStackTrace()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancel()
    }
}