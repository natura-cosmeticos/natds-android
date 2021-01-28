package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.natura.android.R

class DialogAlert constructor (
    private val context: Context,
    private val mainButtonTitle: String,
    private val mainButtonAction: DialogInterface.OnClickListener,
    private val secondaryButtonTitle: String,
    private val secondaryButtonAction: DialogInterface.OnClickListener,
    private val contentText: String = "",
    private val isCancelable: Boolean = true,
    private val dialogTheme: Int? = null
) {
    lateinit var dialog: AlertDialog

    fun create(): DialogAlert {

        dialog = AlertDialog.Builder(context, resolveThemeResource()).create().apply {
            setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle, mainButtonAction)
            setButton(DialogInterface.BUTTON_NEGATIVE, secondaryButtonTitle, secondaryButtonAction)
            setCancelable(isCancelable)
            val layout = layoutInflater.inflate(R.layout.ds_alert_dialog_content, null)
            val textView = layout.findViewById<TextView>(R.id.dialogAlertText)
            textView.text = contentText
            setView(layout)
        }
        return this
    }

    fun show() {
        dialog.show()
    }

    private fun resolveThemeResource(): Int {
        val dialogThemeResource = TypedValue()

        dialogTheme?.let {
            context.setTheme(dialogTheme)
        }

        context.theme.resolveAttribute(R.attr.dialogAlertTheme, dialogThemeResource, true)

        return dialogThemeResource.resourceId
    }
}
