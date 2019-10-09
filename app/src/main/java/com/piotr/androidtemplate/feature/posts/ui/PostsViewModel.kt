package com.piotr.androidtemplate.feature.posts.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.piotr.androidtemplate.base.ui.viewmodel.BaseViewModel
import com.piotr.androidtemplate.feature.posts.network.PostsRepository

class PostsViewModel(
  repository: PostsRepository
) : BaseViewModel() {

  private val refresh = MutableLiveData<Unit>(Unit)
  val posts = refresh.switchMap { repository.getPosts(viewModelScope) }

  fun refresh() {
    refresh.postValue(Unit)
  }
}