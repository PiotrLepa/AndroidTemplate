package com.piotr.androidtemplate.base.ui.extensions.iterable

inline fun <reified T> List<T>.second(): T =
  getOrNull(1) ?: throw NoSuchElementException("Second element doesn't exist. List size: $size")