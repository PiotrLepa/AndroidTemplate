package com.piotr.androidtemplate.feature.posts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.extensions.loadLayoutAnimation
import com.piotr.androidtemplate.base.ui.fragment.BaseFragment
import com.piotr.androidtemplate.base.ui.livedata.CallState
import com.piotr.androidtemplate.base.ui.livedata.CallState.Error
import com.piotr.androidtemplate.base.ui.livedata.CallState.Progress
import com.piotr.androidtemplate.base.ui.livedata.CallState.Success
import com.piotr.androidtemplate.base.ui.recyclerview.VerticalSpacingDecorator
import com.piotr.androidtemplate.delegate.post.UiPost
import com.piotr.androidtemplate.feature.posts.ui.adapter.PostsAdapter
import kotlinx.android.synthetic.main.fragment_posts.recyclerView

class PostsFragment : BaseFragment() {

  private val viewModel: PostsViewModel by viewModel()

  private val listAdapter by lazy { PostsAdapter() }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_posts, container, false)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    setupRecyclerView()
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
        listAdapter.submitList(state.result)
      }
      is Error -> {

      }
    }
  }

  private fun setupRecyclerView() {
    with(recyclerView) {
      layoutManager = LinearLayoutManager(requireContext())
      adapter = listAdapter
      layoutAnimation = loadLayoutAnimation(R.anim.layout_fall_down)
      addItemDecoration(VerticalSpacingDecorator(R.dimen.item_space))
    }
  }
}