package com.piotr.androidtemplate.base.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.piotr.androidtemplate.base.ui.extensions.view.getDimenPixel

class VerticalSpacingDecorator(
  @DimenRes private val spaceRes: Int
) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    val itemOffset = parent.getDimenPixel(spaceRes)
    // add bottom margin only between items
    val position = parent.getChildAdapterPosition(view)
    val totalCount = parent.adapter?.itemCount ?: return

    if (position < totalCount - 1) {
      outRect.bottom = itemOffset
    }
  }
}