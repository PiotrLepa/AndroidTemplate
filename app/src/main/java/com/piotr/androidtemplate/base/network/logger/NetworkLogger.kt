package com.piotr.androidtemplate.base.network.logger

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class NetworkLogger : HttpLoggingInterceptor.Logger {

  override fun log(message: String) {
    Timber.d(message)
  }
}