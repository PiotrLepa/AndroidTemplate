package com.piotr.androidtemplate.base.ui.adapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.piotr.androidtemplate.base.ui.adapter.AdapterDelegate
import kotlin.reflect.KClass

abstract class BaseAdapterDelegate<T : BaseDelegateItem>(
  private val type: KClass<T>,
  @LayoutRes private val layoutId: Int
) : AdapterDelegate<BaseDelegateItem> {

  override fun isForViewType(item: BaseDelegateItem) = type.java.isInstance(item)

  override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(layoutId, parent, false)
    return object : RecyclerView.ViewHolder(view) {}
  }

  @Suppress("UNCHECKED_CAST")
  override fun onBindViewHolder(
    item: BaseDelegateItem,
    holder: ViewHolder
  ) {
    bind(item as T, holder)
  }

  abstract fun bind(
    item: T,
    holder: ViewHolder
  )
}