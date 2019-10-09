package com.piotr.androidtemplate.base.ui.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.livedata.ViewLifecycleOwner
import com.piotr.androidtemplate.base.ui.navigation.OnFragmentInteractionListener

abstract class BaseActivity : AppCompatActivity(),
    ViewLifecycleOwner {

  override fun getViewLifecycleOwner(): LifecycleOwner = this

  override fun onBackPressed() {
    val currentFragment = getCurrentFragment()
    if (currentFragment is OnFragmentInteractionListener) {
      if (!currentFragment.backPressed()) {
        // Fragment requests to cancel back navigation
        return
      }
    }

    super.onBackPressed()
  }

  protected fun getCurrentFragment(): Fragment? {
    return supportFragmentManager
        .findFragmentById(R.id.navHostFragment)
        ?.childFragmentManager
        ?.fragments
        ?.get(0)
  }
}