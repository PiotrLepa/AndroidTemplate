package com.piotr.androidtemplate.base.network.calladapter

import kotlinx.coroutines.Deferred
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class DeferredCallAdapterFactory : CallAdapter.Factory() {
  override fun get(
    returnType: Type,
    annotations: Array<Annotation>,
    retrofit: Retrofit
  ): CallAdapter<*, *>? {
    require(getRawType(returnType) == Deferred::class.java) {
      "Deferred return type must be parameterized as Deferred<Response<T>> or Deferred<Response<out T>>"
    }

    val responseType = getParameterUpperBound(0, returnType as ParameterizedType)
    val rawDeferredType = getRawType(responseType)
    require(rawDeferredType == Response::class.java) {
      "Deferred return type must be parameterized as Deferred<Response<T>> or Deferred<Response<out T>>"
    }
    require(responseType is ParameterizedType) {
      "Response must be parameterized as Response<T> or Response<out T>"
    }

    val bodyType = getParameterUpperBound(0, responseType)
    return DeferredCallAdapter<Any>(bodyType)
  }
}