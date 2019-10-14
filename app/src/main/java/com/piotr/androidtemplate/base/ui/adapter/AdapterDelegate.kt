package com.piotr.androidtemplate.base.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate<T> {

  /**
   * Called to determine whether this AdapterDelegate is the responsible for the given data
   * element.
   */
  fun isForViewType(item: T): Boolean

  /**
   * Creates the  [RecyclerView.ViewHolder] for the given data source item
   */
  fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

  /**
   * Called to bind the [RecyclerView.ViewHolder] to the item of the datas source set
   */
  fun onBindViewHolder(
    item: T,
    holder: RecyclerView.ViewHolder
  )
}