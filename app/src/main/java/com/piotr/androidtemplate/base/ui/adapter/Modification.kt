package com.piotr.androidtemplate.base.ui.adapter

import com.piotr.androidtemplate.base.ui.adapter.base.BaseDelegateItem

data class Modification<T : BaseDelegateItem>(
  val item: T,
  val modification: (T) -> T
) {
  fun modify(): T = modification(item)
}