package com.piotr.androidtemplate.feature.posts.network.mapper

import com.piotr.androidtemplate.base.ui.mapper.UiMapper
import com.piotr.androidtemplate.feature.posts.ui.model.UiPost
import com.piotr.androidtemplate.service.posts.model.NetworkPost

class PostUiMapper : UiMapper<NetworkPost, UiPost> {

  override fun mapToUi(network: NetworkPost) =
    UiPost(
      id = network.id,
      title = network.title,
      body = network.body
    )
}