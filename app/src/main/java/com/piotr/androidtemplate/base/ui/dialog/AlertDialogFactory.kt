package com.piotr.androidtemplate.base.ui.dialog

import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import com.piotr.androidtemplate.R

interface AlertDialogFactory : ContextAccessor {

  fun showDialog(
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes positiveButtonLabel: Int,
    @StringRes negativeButtonLabel: Int? = null,
    positiveCallback: (() -> Unit)? = null,
    negativeCallback: (() -> Unit)? = null
  ) {
    AlertDialog.Builder(ContextThemeWrapper(requireContext(), R.style.DialogButtonStyle))
      .setTitle(requireContext().getString(title))
      .setMessage(requireContext().getString(message))
      .setPositiveButton(positiveButtonLabel) { _, _ -> positiveCallback?.invoke() }
      .apply {
        negativeButtonLabel?.let {
          setNegativeButton(
            negativeButtonLabel
          ) { _, _ -> negativeCallback?.invoke() }
        }
      }
      .show()
  }

  fun showYesNoDialog(
    @StringRes title: Int,
    @StringRes message: Int,
    positiveCallback: () -> Unit,
    negativeCallback: (() -> Unit)? = null
  ) {
    showDialog(
      title, message, R.string.dialog_yes, R.string.dialog_no, positiveCallback, negativeCallback
    )
  }
}