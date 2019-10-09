package com.piotr.androidtemplate.base.di

import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

object ViewModelModule {

  operator fun invoke() = Kodein.Module(name = "ViewModelModule") {
    bind() from singleton { ViewModelFactory(kodein) }
  }
}