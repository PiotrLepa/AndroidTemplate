package com.piotr.androidtemplate.feature.posts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.fragment.BaseFragment
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.base.ui.livedata.CallState.Error
import com.piotr.androidtemplate.base.ui.livedata.CallState.Progress
import com.piotr.androidtemplate.base.ui.livedata.CallState.Success
import com.piotr.androidtemplate.feature.posts.ui.model.UiPost

class PostsFragment : BaseFragment() {

  private val viewModel: PostsViewModel by viewModel()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_posts, container, false)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    observePosts()
  }

  private fun observePosts() {
    viewModel.posts.observeBy(::renderPostsCallState)
  }

  private fun renderPostsCallState(state: CallState<List<UiPost>>) {
    when (state) {
      is Progress -> {

      }
      is Success -> {

      }
      is Error -> {

      }
    }
  }
}