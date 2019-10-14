package com.piotr.androidtemplate.base.ui.navigation

interface OnFragmentInteractionListener {
  /** Return true if should navigate, else false*/
  fun backPressed(): Boolean
}