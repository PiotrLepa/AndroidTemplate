package com.piotr.androidtemplate.base.ui.mapper

interface NetworkMapper<in U, out N> {

  fun mapToNetwork(ui: U): N
}