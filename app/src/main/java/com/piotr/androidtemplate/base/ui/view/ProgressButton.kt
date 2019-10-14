package com.piotr.androidtemplate.base.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.piotr.androidtemplate.R
import kotlinx.android.synthetic.main.view_progress_button.view.button
import kotlinx.android.synthetic.main.view_progress_button.view.progressBar

class ProgressButton @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttrs: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttrs) {

  var text: String = ""

  var textOnLoading: String = ""

  var isLoading: Boolean
    get() = progressBar.isVisible
    set(value) {
      progressBar.isVisible = value
      button.text = if (value) "$textOnLoading..." else text
    }

  init {
    View.inflate(getContext(), R.layout.view_progress_button, this)

    with(context.obtainStyledAttributes(attrs, R.styleable.ProgressButton, 0, 0)) {

      text = getString(R.styleable.ProgressButton_android_text).orEmpty()
      textOnLoading = getString(R.styleable.ProgressButton_textOnLoading).orEmpty()
      isLoading = getBoolean(R.styleable.ProgressButton_isLoading, false)

      recycle()
    }
  }

  fun setOnClickListener(listener: () -> Unit) {
    button.setOnClickListener {
      listener()
    }
  }
}