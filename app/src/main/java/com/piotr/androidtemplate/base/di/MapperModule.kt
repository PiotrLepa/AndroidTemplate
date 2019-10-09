package com.piotr.androidtemplate.base.di

import com.piotr.androidtemplate.delegate.post.PostUiMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

object MapperModule {

  operator fun invoke() = Kodein.Module(name = "MapperModule") {
    bind() from singleton { PostUiMapper() }
  }
}