package com.piotr.androidtemplate.base.ui.dialog

import android.content.Context

interface ContextAccessor {

  fun getContext(): Context?
  fun requireContext(): Context
}