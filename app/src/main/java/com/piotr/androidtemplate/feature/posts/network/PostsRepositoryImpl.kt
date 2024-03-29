package com.piotr.androidtemplate.feature.posts.network

import androidx.lifecycle.LiveData
import com.piotr.androidtemplate.base.network.repository.BaseRepository
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.delegate.post.PostUiMapper
import com.piotr.androidtemplate.delegate.post.UiPost
import com.piotr.androidtemplate.service.posts.PostsService
import kotlinx.coroutines.CoroutineScope

class PostsRepositoryImpl(
  private val service: PostsService,
  private val mapper: PostUiMapper
) : BaseRepository(), PostsRepository {

  override fun getPosts(scope: CoroutineScope): LiveData<CallState<List<UiPost>>> =
    service.getPosts()
      .unpackAndTransform(scope) {
        it.map(mapper::mapToUi)
      }
}