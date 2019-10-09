package com.piotr.androidtemplate.base.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val context: Context) : Interceptor {

  companion object {
    const val NO_INTERNET_CONNECTION = "No internet connection"
  }

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    if (!isOnline(context)) {
      throw NetworkConnectivityException()
    }

    val builder = chain.request()
        .newBuilder()
    return chain.proceed(builder.build())
  }

  private fun isOnline(context: Context): Boolean {
    val connectivityManager = context.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager// TODO change to kodein
    val netInfo = connectivityManager.activeNetworkInfo
    return netInfo != null && netInfo.isConnected
  }

  class NetworkConnectivityException : IOException(NO_INTERNET_CONNECTION)

}