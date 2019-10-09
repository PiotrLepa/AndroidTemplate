package com.piotr.androidtemplate.base.ui.adapter.base

import androidx.recyclerview.widget.DiffUtil

object DefaultDelegateDiff : DiffUtil.ItemCallback<BaseDelegateItem>() {

  override fun areItemsTheSame(
    oldItem: BaseDelegateItem,
    newItem: BaseDelegateItem
  ): Boolean {
    return oldItem.generateId() == newItem.generateId()
  }

  override fun areContentsTheSame(
    oldItem: BaseDelegateItem,
    newItem: BaseDelegateItem
  ): Boolean {
    return oldItem == newItem
  }
}