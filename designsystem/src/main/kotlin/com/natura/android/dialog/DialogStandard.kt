package com.natura.android.dialog

import android.content.Context
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
    private val mainButtonAction: () -> Unit,
    private val secondaryButtonTitle: String,
    private val secondaryButtonAction: () -> Unit,
    private val isCancelable: Boolean = true
) {

    lateinit var dialog: AlertDialog

    fun show(): DialogStandard {
        dialog = AlertDialog.Builder(context, R.style.Theme_DS_Dialog_Standard).setView(R.layout.dialog_standard_layout).create().apply {
            show()
            findViewById<TextView>(R.id.dialogTitle)?.text = dialogTitle
            findViewById<Button>(R.id.mainButton)?.text = mainButtonTitle
            findViewById<View>(R.id.mainButton)?.setOnClickListener {
                mainButtonAction()
                dismiss()
            }
            findViewById<Button>(R.id.secondaryButton)?.text = secondaryButtonTitle
            findViewById<View>(R.id.secondaryButton)?.setOnClickListener {
                secondaryButtonAction()
                dismiss()
            }
            setCancelable(isCancelable)

            if (contentLayout == 0 && contentView != null) {
                findViewById<LinearLayout>(R.id.dialogContent)?.addView(contentView)
            } else {
                findViewById<LinearLayout>(R.id.dialogContent)?.addView(layoutInflater.inflate(contentLayout, null))
            }
        }
        return this
    }
}
