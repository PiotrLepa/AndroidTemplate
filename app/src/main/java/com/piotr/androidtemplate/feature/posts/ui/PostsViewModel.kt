package com.piotr.androidtemplate.feature.posts.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.piotr.androidtemplate.base.ui.extensions.firebase.toDataClassList
import com.piotr.androidtemplate.base.ui.firebase.FirebaseInteractor
import com.piotr.androidtemplate.base.ui.viewmodel.BaseViewModel
import com.piotr.androidtemplate.delegate.post.UiPost
import com.piotr.androidtemplate.feature.posts.network.PostsRepository

class PostsViewModel(
  repository: PostsRepository,
  firebaseInteractor: FirebaseInteractor
) : BaseViewModel() {

  private val refresh = MutableLiveData<Unit>(Unit)
  val posts = refresh.switchMap { repository.getPosts(viewModelScope) }

  val postsFirebase = firebaseInteractor.listenForChanges { it.toDataClassList<UiPost>() }

  fun refresh() {
    refresh.postValue(Unit)
  }
}