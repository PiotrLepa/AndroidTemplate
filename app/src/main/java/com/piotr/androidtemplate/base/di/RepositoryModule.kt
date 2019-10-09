package com.piotr.androidtemplate.base.di

import com.piotr.androidtemplate.feature.posts.network.repository.PostsRepository
import com.piotr.androidtemplate.feature.posts.network.repository.PostsRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object RepositoryModule {

  operator fun invoke() = Kodein.Module(name = "RepositoryModule") {
    bind<PostsRepository>() with singleton {
      PostsRepositoryImpl(
        instance(),
        instance()
      )
    }
  }
}