package com.shohoz.superApp.base.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T>(
    private inline val onClick: (T) -> Unit,
    diffCallback: DiffUtil.ItemCallback<T>
): ListAdapter<T, BaseViewHolder<T>>(diffCallback) {
    private var listener: ListChangeListener? = null

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    override fun onCurrentListChanged(previousList: MutableList<T>, currentList: MutableList<T>) {
        super.onCurrentListChanged(previousList, currentList)
        listener?.onCurrentListChanged()
    }

    fun setListChangedListener(listener: ListChangeListener) {
        this.listener = listener
    }

    interface ListChangeListener {
        fun onCurrentListChanged()
    }

}