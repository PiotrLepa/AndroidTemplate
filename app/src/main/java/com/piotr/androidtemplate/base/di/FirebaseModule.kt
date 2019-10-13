package com.piotr.androidtemplate.base.di

import com.google.firebase.database.FirebaseDatabase
import com.piotr.androidtemplate.base.ui.firebase.FirebaseInteractor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory

object FirebaseModule {

  operator fun invoke() = Kodein.Module("FirebaseModule") {

    bind<FirebaseInteractor>() with factory { path: String ->
      FirebaseInteractor(
        FirebaseDatabase.getInstance().reference.child(
          path
        )
      )
    }
  }
}