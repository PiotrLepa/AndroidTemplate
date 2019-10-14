package com.piotr.androidtemplate.base.ui.extensions.view

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.glide.GlideApp

fun ImageView.setImage(url: String) {
  GlideApp.with(this)
    .load(url)
    .centerInside()
    .into(this)
}

fun ImageView.setRoundedCornersImage(url: String) {
  GlideApp.with(this)
    .load(url)
    .transform(
      RoundedCorners(getDimenPixel(R.dimen.cornerRadius))
    )
    .into(this)
}