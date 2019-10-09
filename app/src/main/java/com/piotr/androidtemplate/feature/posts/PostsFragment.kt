package com.piotr.androidtemplate.feature.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.fragment.BaseFragment

class PostsFragment : BaseFragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_posts, container, false)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {

  }
}