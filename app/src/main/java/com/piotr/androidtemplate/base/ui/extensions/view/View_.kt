package com.piotr.androidtemplate.base.ui.extensions.view

import android.app.Activity
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun View.getColor(@ColorRes colorRes: Int): Int = ContextCompat.getColor(context, colorRes)

fun View.getString(@StringRes stringRes: Int) = context.getString(stringRes)

fun View.getString(@StringRes stringRes: Int, vararg args: Any) =
  context.getString(stringRes, *args)

fun View.getDimen(@DimenRes dimenRes: Int) = resources.getDimension(dimenRes)

fun View.getDimenPixel(@DimenRes dimenRes: Int) = resources.getDimensionPixelSize(dimenRes)

fun View.getFont(@FontRes fontRes: Int) = ResourcesCompat.getFont(context, fontRes)!!

fun View.getInt(@IntegerRes intRes: Int) = resources.getInteger(intRes)

fun View.addRipple() = with(TypedValue()) {
  context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
  setBackgroundResource(resourceId)
}

fun View.hideSoftKeyboard() {
  val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  imm.hideSoftInputFromWindow(windowToken, 0)
}