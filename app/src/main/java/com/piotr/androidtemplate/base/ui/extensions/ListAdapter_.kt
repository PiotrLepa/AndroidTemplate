package com.piotr.androidtemplate.base.ui.extensions

import androidx.recyclerview.widget.ListAdapter
import com.piotr.androidtemplate.base.ui.adapter.Modification
import com.piotr.androidtemplate.base.ui.adapter.base.BaseDelegateItem

infix fun <T : BaseDelegateItem> T.modifyWith(modification: (T) -> T): Modification<T> =
  Modification(this, modification)

infix fun <T : BaseDelegateItem> List<T>.modifyAllWith(modification: (T) -> T): Array<Modification<T>> =
  map { Modification(it, modification) }.toTypedArray()

inline fun <reified T> ListAdapter<*, *>.findUnique(): T {
  val found = currentList.filterIsInstance<T>()
  check(found.isNotEmpty()) { "No item found for type" }
  check(found.size <= 1) { "Multiple items found for type" }
  return found.first()
}

inline fun <reified T> ListAdapter<*, *>.findFirst(): T {
  val found = currentList.filterIsInstance<T>()
  check(found.isNotEmpty()) { "No item found for type" }
  return found.first()
}

inline fun <reified T> ListAdapter<*, *>.findAll(): List<T> = currentList.filterIsInstance<T>()