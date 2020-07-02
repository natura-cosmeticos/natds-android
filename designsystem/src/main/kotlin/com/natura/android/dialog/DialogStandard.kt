package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.natura.android.R

class DialogStandard @JvmOverloads constructor(
    private val context: Context,
    private val dialogTitle: String,
    private val contentLayout: Int = 0,
    private val contentView: View? = null,
    private val mainButtonTitle: String,
    private val mainButtonAction: DialogInterface.OnClickListener,
    private val secondaryButtonTitle: String,
    private val secondaryButtonAction: DialogInterface.OnClickListener,
    private val isCancelable: Boolean = true
) {

    lateinit var dialog: AlertDialog


    fun create(): DialogStandard {
        dialog =  AlertDialog.Builder(context, R.style.Theme_DS_Dialog_Standard).create().apply {

            setTitle(dialogTitle)
            setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle, mainButtonAction)
            setButton(DialogInterface.BUTTON_NEGATIVE, secondaryButtonTitle, secondaryButtonAction)
            setCancelable(isCancelable)

            if(contentLayout == 0 && contentView != null) {
                setView(contentView)
            } else {
                setView(layoutInflater.inflate(contentLayout, null))
            }
        }
        return this
    }

    fun show() {
        dialog.show()
    }
}
