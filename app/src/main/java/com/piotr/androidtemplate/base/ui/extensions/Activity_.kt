package com.piotr.androidtemplate.base.ui.extensions

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory

inline fun <reified T : ViewModel> FragmentActivity.viewModel(viewModelFactory: ViewModelFactory) =
  ViewModelProvider(this, viewModelFactory)[T::class.java]