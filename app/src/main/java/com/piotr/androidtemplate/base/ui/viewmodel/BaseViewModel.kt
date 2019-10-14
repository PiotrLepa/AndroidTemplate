package com.piotr.androidtemplate.base.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

  private val liveDataMap = mutableMapOf<LiveData<*>, Observer<*>>()

  fun <T : Any> LiveData<T>.observeInternal(observer: (T) -> Unit): LiveData<T> {
    val obs = Observer<T>(observer)
    observeForever(observer)
    liveDataMap[this] = obs
    return this
  }

  @CallSuper
  override fun onCleared() {
    clearLiveDataMap()
  }

  @Suppress("UNCHECKED_CAST")
  private fun clearLiveDataMap() {
    liveDataMap.entries.forEach {
      it.key.removeObserver(it.value as Observer<Any>)
    }
  }
}