package com.piotr.androidtemplate.base.di

import com.piotr.androidtemplate.service.posts.PostsService
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

object ServiceModule {

  operator fun invoke() = Kodein.Module(name = "ServiceModule") {
    bind<PostsService>() with singleton { instance<Retrofit>().create(PostsService::class.java) }
  }
}