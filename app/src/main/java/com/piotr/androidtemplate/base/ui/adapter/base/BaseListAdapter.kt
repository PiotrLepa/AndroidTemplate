package com.piotr.androidtemplate.base.ui.adapter.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.piotr.androidtemplate.base.ui.adapter.AdapterDelegate
import com.piotr.androidtemplate.base.ui.adapter.AdapterDelegateManager
import com.piotr.androidtemplate.base.ui.adapter.Modification

abstract class BaseListAdapter(
  vararg delegates: AdapterDelegate<BaseDelegateItem>
) : ListAdapter<BaseDelegateItem, ViewHolder>(
  DefaultDelegateDiff
) {

  private val delegateManager =
    AdapterDelegateManager<BaseDelegateItem>()

  init {
    delegates.forEach(delegateManager::addDelegate)
  }

  override fun getItemViewType(position: Int): Int = delegateManager.getViewType(getItem(position))

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder =
    delegateManager.onCreateViewHolder(parent, viewType)

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) =
    delegateManager.onBindViewHolder(getItem(position), holder)

  fun modifyList(vararg modifications: Modification<*>) {
    val items = currentList.toMutableList()
    modifications.forEach {
      val original = it.item
      val copy = it.modify()
      val oldIndex = items.indexOf(original)
      items.removeAt(oldIndex)
      items.add(oldIndex, copy)
    }
    submitList(items.toList())
  }

  inline fun <reified T : BaseDelegateItem> refreshItemsForType(list: List<T>) {
    val oldItems = currentList.toMutableList()
    val index = oldItems.indexOfFirst { it is T }
    if (index != -1) {
      oldItems.removeAll { it is T }
      oldItems.addAll(index, list)
      submitList(oldItems)
    }
  }

  fun refreshList(list: List<BaseDelegateItem>) {
    submitList(null)
    submitList(list)
  }
}