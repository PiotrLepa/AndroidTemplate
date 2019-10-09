package com.piotr.androidtemplate.base.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface ViewLifecycleOwner {

  fun getViewLifecycleOwner(): LifecycleOwner

  fun <T> LiveData<T>.observeBy(observer: (T) -> Unit) {
    val resultObserver = Observer<T> { observer(it) }
    observe(getViewLifecycleOwner(), resultObserver)
  }
}