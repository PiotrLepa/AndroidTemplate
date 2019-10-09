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
import kotlinx.coroutines.async
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseRepository {

  fun <T> createCallAsync(
    scope: CoroutineScope,
    transform: suspend () -> Response<T>
  ): Deferred<Response<T>> =
    scope.async { transform() }

  fun <T, U> Deferred<Response<T>>.unpackAndTransform(
    scope: CoroutineScope,
    transform: (T) -> U
  ): LiveData<CallState<U>> =
    liveData(scope.coroutineContext) {
      emit(Progress())
      val response = this@unpackAndTransform.await()
      if (response.isSuccessful) {
        emit(tryTransform(response.body(), transform))
      } else {
        emit(Error(HttpException(response)))
      }
    }

  private fun <T, U> tryTransform(body: T?, transform: (T) -> U): CallState<U> =
    if (body != null) {
      val transformed = transform(body)
      Success(transformed)
    } else {
      Error(EmptyResponseException())
    }
}