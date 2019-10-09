package com.piotr.androidtemplate.base.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegateManager<T> {

  private val delegates = LinkedHashMap<Int, AdapterDelegate<T>>()

  fun addDelegate(delegate: AdapterDelegate<T>) {
    delegates[delegates.size] = delegate
  }

  fun getViewType(item: T): Int {
    return delegates.entries.firstOrNull { it.value.isForViewType(item) }?.key
      ?: throw IllegalArgumentException("No proper adapter delegate defined for type: $item")
  }

  fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RecyclerView.ViewHolder {
    return delegates[viewType]?.onCreateViewHolder(parent)
      ?: throw IllegalArgumentException("Unsupported viewType: $viewType")
  }

  fun onBindViewHolder(
    item: T,
    holder: RecyclerView.ViewHolder
  ) {
    delegates[getViewType(item)]?.onBindViewHolder(item, holder)
      ?: throw IllegalArgumentException("Unsupported viewType: ${getViewType(item)}")
  }
}