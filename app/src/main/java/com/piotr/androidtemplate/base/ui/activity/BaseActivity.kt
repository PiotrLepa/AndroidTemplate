package com.piotr.androidtemplate.base.ui.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piotr.androidtemplate.R
import com.piotr.androidtemplate.base.ui.livedata.ViewLifecycleOwner
import com.piotr.androidtemplate.base.ui.navigation.OnFragmentInteractionListener
import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

abstract class BaseActivity : AppCompatActivity(),
  KodeinAware, ViewLifecycleOwner {

  override val kodein by kodein()

  val viewModelFactory: ViewModelFactory by instance()

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

  protected inline fun <reified T : ViewModel> viewModel() =
    lazy { ViewModelProvider(this, viewModelFactory)[T::class.java] }

  protected fun getCurrentFragment(): Fragment? {
    return supportFragmentManager
      .findFragmentById(R.id.navHostFragment)
      ?.childFragmentManager
      ?.fragments
      ?.get(0)
  }
}