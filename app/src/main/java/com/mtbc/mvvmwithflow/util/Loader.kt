package com.mtbc.mvvmwithflow.util

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.mtbc.mvvmwithflow.R

class Loader(context: Context) {
    private val dialog: Dialog = Dialog(context).apply {
        setContentView(LayoutInflater.from(context).inflate(R.layout.dialog_loader, null))
        setCancelable(false)
    }

    fun show() {
        if (!dialog.isShowing) dialog.show()
    }

    fun dismiss() {
        if (dialog.isShowing) dialog.dismiss()
    }
}