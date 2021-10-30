package com.shohoz.superApp.base.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T, onClick: (T) -> Unit)

}