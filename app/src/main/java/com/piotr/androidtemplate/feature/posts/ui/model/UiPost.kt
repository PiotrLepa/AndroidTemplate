package com.piotr.androidtemplate.feature.posts.ui.model

import com.piotr.androidtemplate.base.ui.adapter.base.BaseDelegateItem

data class UiPost(
  override val id: Int,
  val title: String,
  val body: String
) : BaseDelegateItem