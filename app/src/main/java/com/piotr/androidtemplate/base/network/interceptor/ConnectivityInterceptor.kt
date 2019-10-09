package com.piotr.androidtemplate.base.network.interceptor

import android.content.Context
import android.net.ConnectivityManager
import com.piotr.androidtemplate.base.network.NoInternetConnectionException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val context: Context) : Interceptor {

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    if (!isOnline(context)) {
      throw NoInternetConnectionException()
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
}