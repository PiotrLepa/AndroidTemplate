package com.piotr.androidtemplate.base.di

import org.kodein.di.Kodein

object RepositoryModule {

  operator fun invoke() = Kodein.Module(name = "RepositoryModule") {

  }
}