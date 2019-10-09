package com.piotr.androidtemplate.base.ui.livedata

sealed class CallState<T> {
  class Progress<T> : CallState<T>()
  class Success<T>(val result: T) : CallState<T>()
  class Error<T>(val cause: Exception) : CallState<T>()
}