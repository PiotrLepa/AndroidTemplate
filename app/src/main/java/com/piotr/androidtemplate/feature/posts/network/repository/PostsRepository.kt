package com.piotr.androidtemplate.feature.posts.network.repository

import androidx.lifecycle.LiveData
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.feature.posts.ui.model.UiPost
import kotlinx.coroutines.CoroutineScope

interface PostsRepository {

  fun getPosts(scope: CoroutineScope): LiveData<CallState<List<UiPost>>>
}