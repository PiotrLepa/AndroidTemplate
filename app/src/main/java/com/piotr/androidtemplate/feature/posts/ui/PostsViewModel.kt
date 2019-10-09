package com.piotr.androidtemplate.feature.posts.ui

import androidx.lifecycle.viewModelScope
import com.piotr.androidtemplate.base.ui.viewmodel.BaseViewModel
import com.piotr.androidtemplate.feature.posts.network.repository.PostsRepository

class PostsViewModel(
  repository: PostsRepository
) : BaseViewModel() {

  val posts = repository.getPosts(viewModelScope)
}