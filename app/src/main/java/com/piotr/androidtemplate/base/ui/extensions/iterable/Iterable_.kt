package com.piotr.androidtemplate.base.ui.extensions.iterable

import com.piotr.androidtemplate.base.ui.adapter.base.BaseDelegateItem

inline fun <reified T : BaseDelegateItem> Iterable<BaseDelegateItem>.replaceItemsForType(
  list: List<T>,
  startIndexOnEmptyList: Int = 0
): MutableList<BaseDelegateItem> {
  val copy = toMutableList()
  var index = copy.indexOfFirst { it is T }
  if (index == -1) {
    index = startIndexOnEmptyList
  }
  copy.removeAll { it is T }
  copy.addAll(index, list)

  return copy
}

inline fun <reified T> Iterable<*>.findIsInstance(): T =
  filterIsInstance<T>().first()