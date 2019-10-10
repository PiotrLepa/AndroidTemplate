package com.piotr.androidtemplate.base.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.piotr.androidtemplate.base.network.EmptyResponseException
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.base.ui.livedata.CallState.Error
import com.piotr.androidtemplate.base.ui.livedata.CallState.Progress
import com.piotr.androidtemplate.base.ui.livedata.CallState.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseRepository {

  fun <T, U> Deferred<Response<T>>.unpackAndTransform(
    scope: CoroutineScope,
    transform: (T) -> U
  ): LiveData<CallState<U>> =
    liveData(scope.coroutineContext) {
      try {
        emit(Progress())
        emit(unpackResponse(this@unpackAndTransform, transform))
      } catch (e: Exception) { // catch our exception eg ConnectivityException
        emit(Error(e))
      }
    }

  private suspend fun <T, U> unpackResponse(
    deferred: Deferred<Response<T>>,
    transform: (T) -> U
  ): CallState<U> = with(deferred.await()) {
    return if (isSuccessful) {
      transformOrError(body(), transform)
    } else {
      Error(HttpException(this))
    }
  }

  private fun <T, U> transformOrError(body: T?, transform: (T) -> U): CallState<U> =
    if (body != null) {
      val transformed = transform(body)
      Success(transformed)
    } else {
      Error(EmptyResponseException())
    }
}