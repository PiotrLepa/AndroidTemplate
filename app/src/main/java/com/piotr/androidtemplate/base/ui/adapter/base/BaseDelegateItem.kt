package com.piotr.androidtemplate.base.ui.adapter.base

interface BaseDelegateItem {
  val id: Any
  fun generateId(): String = "${javaClass.simpleName}$id"
}