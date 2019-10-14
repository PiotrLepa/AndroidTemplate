package com.piotr.androidtemplate.base.ui.extensions.iterable

fun <E> MutableList<E>.clearAndAdd(newItems: List<E>) {
  clear()
  addAll(newItems)
}