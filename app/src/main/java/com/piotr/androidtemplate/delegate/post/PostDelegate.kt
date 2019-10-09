package com.piotr.androidtemplate.delegate.post

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.adapter.base.BaseAdapterDelegate
import kotlinx.android.synthetic.main.item_post.view.postBody
import kotlinx.android.synthetic.main.item_post.view.postId
import kotlinx.android.synthetic.main.item_post.view.postTitle

class PostDelegate : BaseAdapterDelegate<UiPost>(UiPost::class, R.layout.item_post) {

  override fun bind(item: UiPost, holder: ViewHolder) {
    with(holder.itemView) {
      postId.text = item.id.toString()
      postTitle.text = item.title
      postBody.text = item.body
    }
  }
}