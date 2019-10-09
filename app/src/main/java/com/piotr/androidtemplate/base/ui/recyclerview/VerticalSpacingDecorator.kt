package com.piotr.androidtemplate.base.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpacingDecorator(private val itemOffset: Int) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    // add bottom margin only between items
    val position = parent.getChildAdapterPosition(view)
    val totalCount = parent.adapter?.itemCount ?: return

    if (position < totalCount - 1) {
      outRect.bottom = itemOffset
    }
  }
}