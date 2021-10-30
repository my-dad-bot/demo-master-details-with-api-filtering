package com.shohoz.superApp.base.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel


private const val TAG = "BaseViewModel"

open class BaseViewModel : ViewModel() {


    override fun onCleared() {
        super.onCleared()
        viewModelScope.coroutineContext.cancel()
    }
}