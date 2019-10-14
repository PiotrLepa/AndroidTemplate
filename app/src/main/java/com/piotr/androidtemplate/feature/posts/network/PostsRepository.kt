package com.piotr.androidtemplate.feature.posts.network

import androidx.lifecycle.LiveData
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.delegate.post.UiPost
import kotlinx.coroutines.CoroutineScope

interface PostsRepository {

  fun getPosts(scope: CoroutineScope): LiveData<CallState<List<UiPost>>>
}