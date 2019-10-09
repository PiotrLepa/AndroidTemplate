package com.piotr.androidtemplate.base.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.StringRes
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.view.ErrorViewIcon.DEFAULT
import kotlinx.android.synthetic.main.view_error.view.errorImageView
import kotlinx.android.synthetic.main.view_error.view.errorTextView

class ErrorView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttrs: Int = 0
) : LinearLayout(context, attrs, defStyleAttrs) {

  var errorMessage: CharSequence
    get() = errorTextView.text
    set(value) {
      errorTextView.text = value
    }

  var errorIcon: ErrorViewIcon = DEFAULT
    set(value) {
      errorImageView.setImageResource(value.iconRes)
      field = value
    }

  init {
    View.inflate(context, R.layout.view_error, this)
  }

  fun setAndShow(@StringRes messageRes: Int, icon: ErrorViewIcon = DEFAULT) {
    errorMessage = context.getString(messageRes)
    errorIcon = icon
  }
}