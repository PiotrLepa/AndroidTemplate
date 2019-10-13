package com.piotr.androidtemplate.base.ui.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.piotr.androidtemplate.base.ui.extensions.firebase.toMap
import com.piotr.androidtemplate.base.ui.livedata.FirebaseLiveData

class FirebaseInteractor(
  private val ref: DatabaseReference
) {

  fun <T> setListValue(list: List<T>) {
    ref.setValue(list.map { it.toMap() })
  }

  fun <T> listenForChanges(transform: (DataSnapshot) -> T): LiveData<T> =
    FirebaseLiveData<T>(ref, transform)
}