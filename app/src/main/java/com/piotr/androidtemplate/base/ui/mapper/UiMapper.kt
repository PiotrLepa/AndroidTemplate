package com.piotr.androidtemplate.base.ui.mapper

interface UiMapper<in N, out U> {

  fun mapToUi(network: N): U
}