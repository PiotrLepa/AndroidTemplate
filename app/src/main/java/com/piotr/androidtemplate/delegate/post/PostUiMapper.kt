package com.piotr.androidtemplate.delegate.post

import com.piotr.androidtemplate.base.ui.mapper.UiMapper
import com.piotr.androidtemplate.service.posts.model.NetworkPost

class PostUiMapper : UiMapper<NetworkPost, UiPost> {

  override fun mapToUi(network: NetworkPost) =
    UiPost(
      id = network.id,
      title = network.title,
      body = network.body
    )
}