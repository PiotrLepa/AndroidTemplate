package com.piotr.androidtemplate.base.ui.view

import androidx.annotation.DrawableRes
import com.piotr.androidtemplate.R

enum class ErrorViewIcon(@DrawableRes val iconRes: Int) {
  DEFAULT(R.drawable.ic_error),
  NO_INTERNET_CONNECTION(R.drawable.ic_no_internet_connection),
  NO_DATA(R.drawable.ic_no_data)
}