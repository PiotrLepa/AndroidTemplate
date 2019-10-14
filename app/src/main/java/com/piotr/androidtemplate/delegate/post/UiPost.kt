package com.piotr.androidtemplate.delegate.post

import com.piotr.androidtemplate.base.ui.adapter.base.BaseDelegateItem

data class UiPost(
  override val id: Int,
  val title: String,
  val body: String
) : BaseDelegateItem