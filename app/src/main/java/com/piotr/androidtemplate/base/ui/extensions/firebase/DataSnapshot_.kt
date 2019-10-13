package com.piotr.androidtemplate.base.ui.extensions.firebase

import com.google.firebase.database.DataSnapshot

inline fun <reified T> DataSnapshot.toDataClassList(): List<T> =
  children.map { it.value.toDataClass<T>() }