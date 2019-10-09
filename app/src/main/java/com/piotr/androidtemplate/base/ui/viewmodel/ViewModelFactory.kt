package com.piotr.androidtemplate.base.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.generic.provider

class ViewModelFactory(private val kodein: Kodein) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val provider: () -> ViewModel = kodein.direct.provider(modelClass.name)
    return provider() as T
  }
}