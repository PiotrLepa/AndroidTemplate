package com.piotr.androidtemplate.service.posts

import com.piotr.androidtemplate.service.posts.model.NetworkPost
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {

  @GET("posts")
  fun getPosts(): Deferred<Response<List<NetworkPost>>>
}