package com.piotr.androidtemplate.base.di

import org.kodein.di.Kodein

object ServiceModule {

  operator fun invoke() = Kodein.Module(name = "ServiceModule") {

  }
}