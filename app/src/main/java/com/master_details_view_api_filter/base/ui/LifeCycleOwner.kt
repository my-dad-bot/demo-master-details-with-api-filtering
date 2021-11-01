package com.master_details_view_api_filter.base.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

inline fun <T> LifecycleOwner.observeLiveData(
    liveData: MutableLiveData<T>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(this, { it?.let(action) })
}

fun <T> LifecycleOwner.observeEvent(
    liveData: LiveData<SingleEvent<T>>,
    action: (t: SingleEvent<T>) -> Unit
) {
    liveData.observe(this, { it?.let { t -> action(t) } })
}
