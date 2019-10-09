package com.piotr.androidtemplate.base.ui.extensions

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piotr.androidtemplate.base.ui.viewmodel.ViewModelFactory

inline fun <reified T : ViewModel> Fragment.viewModel(viewModelFactory: ViewModelFactory) =
  ViewModelProvider(this, viewModelFactory)[T::class.java]

inline fun <reified T : ViewModel> Fragment.parentViewModel(viewModelFactory: ViewModelFactory) =
  ViewModelProvider(requireParentFragment(), viewModelFactory)[T::class.java]

inline fun <reified T : ViewModel> Fragment.activityViewModel(viewModelFactory: ViewModelFactory) =
  ViewModelProvider(requireActivity(), viewModelFactory)[T::class.java]

fun Fragment.getColor(@ColorRes colorRes: Int): Int =
  ContextCompat.getColor(requireContext(), colorRes)

fun Fragment.getString(@StringRes stringRes: Int) = requireContext().getString(stringRes)

fun Fragment.getString(@StringRes stringRes: Int, vararg args: Any) =
  requireContext().getString(stringRes, *args)

fun Fragment.getDimen(@DimenRes dimenRes: Int) = resources.getDimension(dimenRes)

fun Fragment.getDimenPixel(@DimenRes dimenRes: Int) = resources.getDimensionPixelSize(dimenRes)

fun Fragment.getFont(@FontRes fontRes: Int) = ResourcesCompat.getFont(requireContext(), fontRes)!!

fun Fragment.getInt(@IntegerRes intRes: Int) = resources.getInteger(intRes)