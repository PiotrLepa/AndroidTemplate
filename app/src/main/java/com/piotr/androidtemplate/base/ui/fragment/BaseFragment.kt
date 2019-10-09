package com.piotr.androidtemplate.base.ui.fragment

import androidx.fragment.app.Fragment
import com.piotr.androidtemplate.base.ui.livedata.ViewLifecycleOwner
import com.piotr.androidtemplate.base.ui.navigation.OnFragmentInteractionListener
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

abstract class BaseFragment : Fragment(), OnFragmentInteractionListener,
    ViewLifecycleOwner, KodeinAware {

  override val kodein by kodein()

  override fun backPressed() = true
}