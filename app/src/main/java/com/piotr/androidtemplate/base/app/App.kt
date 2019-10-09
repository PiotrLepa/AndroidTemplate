package com.piotr.androidtemplate.base.app

import android.app.Application
import com.piotr.androidtemplate.BuildConfig
import com.piotr.androidtemplate.base.di.RepositoryModule
import com.piotr.androidtemplate.base.di.ServiceModule
import com.piotr.androidtemplate.base.di.ViewModelModule
import com.piotr.androidtemplate.base.network.di.NetworkModule
import net.danlew.android.joda.JodaTimeAndroid
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application(), KodeinAware {

  override val kodein by Kodein.lazy {
    import(androidXModule(this@App))
    import(ViewModelModule())
    import(NetworkModule())
    import(RepositoryModule())
    import(ServiceModule())
  }

  override fun onCreate() {
    super.onCreate()
    initDateTime()
    initTimber()
  }

  private fun initDateTime() {
    JodaTimeAndroid.init(this)
  }

  private fun initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(DebugTree())
    }
  }
}
