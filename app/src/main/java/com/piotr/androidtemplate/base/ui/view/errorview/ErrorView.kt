package com.piotr.androidtemplate.base.ui.view.errorview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.R.string
import com.piotr.androidtemplate.base.network.EmptyResponseException
import com.piotr.androidtemplate.base.network.NoInternetConnectionException
import com.piotr.androidtemplate.base.ui.view.errorview.ErrorViewIcon.DEFAULT
import com.piotr.androidtemplate.base.ui.view.errorview.ErrorViewIcon.NO_DATA
import com.piotr.androidtemplate.base.ui.view.errorview.ErrorViewIcon.NO_INTERNET_CONNECTION
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
    isVisible = false
  }

  fun show(@StringRes messageRes: Int, icon: ErrorViewIcon = DEFAULT) {
    errorMessage = context.getString(messageRes)
    errorIcon = icon
    isVisible = true
  }

  fun show(exception: Exception, @StringRes defaultMessage: Int) {
    val error = resolveError(exception, defaultMessage)
    show(error.first, error.second)
  }

  private fun resolveError(
    exception: Exception,
    defaultMessage: Int
  ): Pair<Int, ErrorViewIcon> = when (exception) {
    is NoInternetConnectionException -> string.no_internet_connection to NO_INTERNET_CONNECTION
    is EmptyResponseException -> string.no_data_to_show to NO_DATA
    else -> defaultMessage to DEFAULT
  }
}