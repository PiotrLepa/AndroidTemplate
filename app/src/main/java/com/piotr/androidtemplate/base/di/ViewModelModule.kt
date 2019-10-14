package com.piotr.androidtemplate.base.di

import com.piotr.androidtemplate.base.di.extensions.bindViewModel
import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory
import com.piotr.androidtemplate.feature.posts.ui.PostsViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

object ViewModelModule {

  operator fun invoke() = Kodein.Module(name = "ViewModelModule") {
    bind() from singleton { ViewModelFactory(kodein) }

    bindViewModel<PostsViewModel>() with provider { PostsViewModel(instance()) }
  }
}