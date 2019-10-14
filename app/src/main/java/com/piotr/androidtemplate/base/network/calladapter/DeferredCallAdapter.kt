package com.piotr.androidtemplate.base.network.calladapter

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class DeferredCallAdapter<T>(
  private val responseType: Type
) : CallAdapter<T, Deferred<Response<T>>> {

  override fun responseType() = responseType

  override fun adapt(call: Call<T>): Deferred<Response<T>> {
    val deferred = CompletableDeferred<Response<T>>()

    deferred.invokeOnCompletion {
      if (deferred.isCancelled) {
        call.cancel()
      }
    }

    call.enqueue(object : Callback<T> {
      override fun onResponse(call: Call<T>, response: Response<T>) {
        deferred.complete(response)
      }

      override fun onFailure(call: Call<T>, t: Throwable) {
        deferred.completeExceptionally(t)
      }
    })

    return deferred
  }
}