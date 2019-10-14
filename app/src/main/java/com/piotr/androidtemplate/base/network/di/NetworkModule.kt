package com.piotr.androidtemplate.base.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.piotr.androidtemplate.BuildConfig
import com.piotr.androidtemplate.base.network.calladapter.DeferredCallAdapterFactory
import com.piotr.androidtemplate.base.network.interceptor.ConnectivityInterceptor
import com.piotr.androidtemplate.base.network.logger.NetworkLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

  operator fun invoke() = Kodein.Module(name = "NetworkModule") {

    bind<Gson>() with singleton { GsonBuilder().create() }
    bind() from singleton { NetworkLogger() }

    bind<OkHttpClient>() with singleton {
      OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(instance()).also {
          it.level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(ConnectivityInterceptor(instance()))
        .build()
    }

    bind<Retrofit>() with singleton {
      Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .client(instance())
        .addConverterFactory(GsonConverterFactory.create(instance()))
        .addCallAdapterFactory(DeferredCallAdapterFactory())
        .build()
    }
  }
}