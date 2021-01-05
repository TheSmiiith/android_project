package com.example.androidproject.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.androidproject.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MMaterialAlertDialog(context: Context) : AlertDialog(context) {

    companion object {
        /* Default Success Dialog */
        fun getSuccessDialog(context: Context): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.success_title))
                .setMessage(context.getString(R.string.success_message))
                .setIcon(R.drawable.ic_success_24)
                .setCancelable(true)
                .show()
        }
        /* Success Dialog with message */
        fun getSuccessDialog(context: Context, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.success_title))
                .setMessage(message)
                .setIcon(R.drawable.ic_success_24)
                .setCancelable(true)
                .show()
        }
        /* Success Dialog with title & message */
        fun getSuccessDialog(context: Context, title: String, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_success_24)
                .setCancelable(true)
                .show()
        }

        /* Default Error Dialog */
        fun getErrorDialog(context: Context): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.error_message))
                .setIcon(R.drawable.ic_error_24)
                .setCancelable(false)
                .show()
        }
        /* Error Dialog with message */
        fun getErrorDialog(context: Context, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(message)
                .setIcon(R.drawable.ic_error_24)
                .setCancelable(false)
                .show()
        }
        /* Error Dialog with title & message */
        fun getErrorDialog(context: Context, title: String, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_error_24)
                .setCancelable(false)
                .show()
        }

        /* Default Loading Dialog */
        fun getLoadingDialog(context: Context): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.loading_title))
                .setMessage(context.getString(R.string.loading_message))
                .setIcon(R.drawable.ic_loading_24)
                .setCancelable(false)
                .show()
        }
        /* Loading Dialog with message */
        fun getLoadingDialog(context: Context, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.loading_title))
                .setMessage(message)
                .setIcon(R.drawable.ic_loading_24)
                .setCancelable(false)
                .show()
        }
        /* Loading Dialog with title & message */
        fun getLoadingDialog(context: Context, title: String, message: String): AlertDialog {
            return MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_loading_24)
                .setCancelable(false)
                .show()
        }
    }

}