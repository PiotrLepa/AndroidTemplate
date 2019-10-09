package com.piotr.androidtemplate.base.ui.extensions

import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

fun Fragment.getColor(@ColorRes colorRes: Int): Int =
  ContextCompat.getColor(requireContext(), colorRes)

fun Fragment.getString(@StringRes stringRes: Int) = requireContext().getString(stringRes)

fun Fragment.getString(@StringRes stringRes: Int, vararg args: Any) =
  requireContext().getString(stringRes, *args)

fun Fragment.getDimen(@DimenRes dimenRes: Int) = resources.getDimension(dimenRes)

fun Fragment.getDimenPixel(@DimenRes dimenRes: Int) = resources.getDimensionPixelSize(dimenRes)

fun Fragment.getFont(@FontRes fontRes: Int) = ResourcesCompat.getFont(requireContext(), fontRes)!!

fun Fragment.getInt(@IntegerRes intRes: Int) = resources.getInteger(intRes)

fun Fragment.loadLayoutAnimation(@AnimRes animRes: Int) =
  AnimationUtils.loadLayoutAnimation(requireContext(), animRes)