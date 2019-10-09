package com.piotr.androidtemplate.service.posts

import com.piotr.androidtemplate.service.posts.model.NetworkPost
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {

  @GET("posts")
  suspend fun getPosts(): Response<List<NetworkPost>>
}