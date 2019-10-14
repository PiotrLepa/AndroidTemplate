package com.piotr.androidtemplate.base.network.interceptor

import android.net.ConnectivityManager
import com.piotr.androidtemplate.base.network.NoInternetConnectionException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val connectivityManager: ConnectivityManager) : Interceptor {

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    if (!isOnline(connectivityManager)) {
      throw NoInternetConnectionException()
    }

    val builder = chain.request()
      .newBuilder()
    return chain.proceed(builder.build())
  }

  private fun isOnline(connectivityManager: ConnectivityManager) =
    connectivityManager.activeNetworkInfo?.isConnected ?: false
}