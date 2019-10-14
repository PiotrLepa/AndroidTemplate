package com.piotr.androidtemplate.service.posts.model

data class NetworkPost(
  val id: Int,
  val userId: Int,
  val title: String,
  val body: String
)