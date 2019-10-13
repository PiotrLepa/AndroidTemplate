package com.piotr.androidtemplate.base.ui.livedata

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class FirebaseLiveData<T>(
  private val firebaseRef: DatabaseReference,
  private val transform: (DataSnapshot) -> T
) : MutableLiveData<T>() {

  private var listener: ValueEventListener? = null

  override fun onActive() {
    listener = firebaseRef.addValueEventListener(object : ValueEventListener {
      override fun onCancelled(error: DatabaseError) {
      }

      override fun onDataChange(snapshot: DataSnapshot) {
        postValue(transform(snapshot))
      }
    })
  }

  override fun onInactive() {
    listener?.let { firebaseRef.removeEventListener(it) }
  }
}