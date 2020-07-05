package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.natura.android.R


class DialogStandard @JvmOverloads constructor(
    private val context: Context,
    private val dialogTitle: String,
    private val mainButtonTitle: String,
    private val mainButtonAction: DialogInterface.OnClickListener,
    private val secondaryButtonTitle: String,
    private val secondaryButtonAction: DialogInterface.OnClickListener,
    private val contentLayout: Int = 0,
    private val contentView: View? = null,
    private val isCancelable: Boolean = true,
    private val dialogTheme: Int = 0
) {

    lateinit var dialog: AlertDialog

    fun create(): DialogStandard {
        dialog =  AlertDialog.Builder(context, resolveThemeResource()).create().apply {
            setTitle(dialogTitle)
            setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle, mainButtonAction)
            setButton(DialogInterface.BUTTON_NEGATIVE, secondaryButtonTitle, secondaryButtonAction)
            setCancelable(isCancelable)

            if(contentLayout == 0 && contentView != null) {
                setView(contentView)
            } else if (contentView == null && contentLayout != 0){
                setView(layoutInflater.inflate(contentLayout, null))
            }
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

        context.theme.resolveAttribute(R.attr.dialogStandardTheme, dialogThemeResource, true)

        return dialogThemeResource.resourceId
    }
}
