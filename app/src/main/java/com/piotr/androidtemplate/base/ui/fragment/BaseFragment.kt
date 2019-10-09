package com.piotr.androidtemplate.base.ui.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piotr.androidtemplate.base.ui.livedata.ViewLifecycleOwner
import com.piotr.androidtemplate.base.ui.navigation.OnFragmentInteractionListener
import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

abstract class BaseFragment : Fragment(), OnFragmentInteractionListener,
    ViewLifecycleOwner, KodeinAware {

  override val kodein by kodein()

  val viewModelFactory: ViewModelFactory by instance()

  override fun backPressed() = true

  protected inline fun <reified T : ViewModel> viewModel() =
    lazy { ViewModelProvider(this, viewModelFactory)[T::class.java] }

  protected inline fun <reified T : ViewModel> parentViewModel() =
    lazy { ViewModelProvider(requireParentFragment(), viewModelFactory)[T::class.java] }

  protected inline fun <reified T : ViewModel> activityViewModel() =
    lazy { ViewModelProvider(requireActivity(), viewModelFactory)[T::class.java] }
}