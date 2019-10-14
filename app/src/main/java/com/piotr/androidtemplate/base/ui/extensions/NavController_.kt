package com.piotr.androidtemplate.base.ui.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import timber.log.Timber

fun NavController.safeNavigate(directions: NavDirections) {
  try {
    navigate(directions)
  } catch (ex: IllegalArgumentException) {
    Timber.e(ex)
  }
}

fun NavController.safeNavigate(@IdRes resId: Int, args: Bundle) {
  try {
    navigate(resId, args)
  } catch (ex: IllegalArgumentException) {
    Timber.e(ex)
  }
}