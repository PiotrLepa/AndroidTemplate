package com.piotr.androidtemplate.base.di.extensions

import androidx.lifecycle.ViewModel
import org.kodein.di.Kodein.Builder
import org.kodein.di.Kodein.Builder.TypeBinder
import org.kodein.di.generic.bind

inline fun <reified T : ViewModel> Builder.bindViewModel(): TypeBinder<ViewModel> =
  bind<ViewModel>(tag = T::class.java.name)