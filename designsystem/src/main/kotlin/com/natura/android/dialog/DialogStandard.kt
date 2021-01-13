package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.natura.android.R
import kotlinx.android.synthetic.main.dialog_standard_content.view.txtViewId

class DialogStandard private constructor (
    private val context: Context,
    private val dialogTitle: String,
    private val mainButtonTitle: String,
    private val text: String? = null,
    private val mainButtonAction: DialogInterface.OnClickListener,
    private val secondaryButtonTitle: String,
    private val secondaryButtonAction: DialogInterface.OnClickListener,
    private val contentLayout: Int? = null,
    private val contentView: View? = null,
    private val isCancelable: Boolean = true,
    private val dialogTheme: Int? = null
) {
    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        contentView: View,
        isCancelable: Boolean = true,
        dialogTheme: Int? = null
    ) :
        this(
            context = context,
            dialogTitle = dialogTitle,
            mainButtonTitle = mainButtonTitle,
            mainButtonAction = mainButtonAction,
            secondaryButtonTitle = secondaryButtonTitle,
            secondaryButtonAction = secondaryButtonAction,
            text = null,
            contentLayout = null,
            contentView = contentView,
            isCancelable = isCancelable,
            dialogTheme = dialogTheme)

    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        contentLayout: Int,
        isCancelable: Boolean = true,
        dialogTheme: Int? = null
    ) :
        this(
            context = context,
            dialogTitle = dialogTitle,
            mainButtonTitle = mainButtonTitle,
            mainButtonAction = mainButtonAction,
            secondaryButtonTitle = secondaryButtonTitle,
            secondaryButtonAction = secondaryButtonAction,
            text = null,
            contentLayout = contentLayout,
            contentView = null,
            isCancelable = isCancelable,
            dialogTheme = dialogTheme)

    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        text: String,
        isCancelable: Boolean = true,
        dialogTheme: Int? = null
    ) :
        this(
            context = context,
            dialogTitle = dialogTitle,
            mainButtonTitle = mainButtonTitle,
            mainButtonAction = mainButtonAction,
            secondaryButtonTitle = secondaryButtonTitle,
            secondaryButtonAction = secondaryButtonAction,
            text = text,
            contentLayout = null,
            contentView = null,
            isCancelable = isCancelable,
            dialogTheme = dialogTheme)

    lateinit var dialog: AlertDialog

    fun create(): DialogStandard {
        dialog = AlertDialog.Builder(context, resolveThemeResource()).create().apply {
            setTitle(dialogTitle)
            setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle, mainButtonAction)
            setButton(DialogInterface.BUTTON_NEGATIVE, secondaryButtonTitle, secondaryButtonAction)
            setCancelable(isCancelable)

            text?.let {
                layoutInflater.inflate(R.layout.dialog_standard_content, null).apply {
                    setView(this)
                    this.txtViewId.text = text
                }
            }
            contentView?.let { setView(contentView) }
            contentLayout?.let { setView(layoutInflater.inflate(it, null)) }
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
