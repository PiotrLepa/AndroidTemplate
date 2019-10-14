package com.piotr.androidtemplate.base.ui.extensions.view

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.setCursorToEnd() {
  requireEditText().setSelection(inputText.length)
}

fun TextInputLayout.requireEditText(): EditText =
  editText ?: throw IllegalStateException("TextInputLayout $this does not have EditText.")

var TextInputLayout.inputText
  get() = requireEditText().text.toString()
  set(value) {
    requireEditText().setText(value)
  }