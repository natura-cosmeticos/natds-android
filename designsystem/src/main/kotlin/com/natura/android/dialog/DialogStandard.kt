package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.natura.android.R
import com.natura.android.divider.Divider
import com.natura.android.iconButton.IconButton

class DialogStandard private constructor(
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
    private val dialogTheme: Int? = null,
    private val firstHeaderIconButton: String? = null,
    private val firstHeaderIconButtonAction: View.OnClickListener? = null,
    private val secondHeaderIconButton: String? = null,
    private val secondHeaderIconButtonAction: View.OnClickListener? = null,
    private val thirdHeaderIconButton: String? = null,
    private val thirdHeaderIconButtonAction: View.OnClickListener? = null,
    private val divider: Boolean = false
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
            dialogTheme = dialogTheme
        )

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
            dialogTheme = dialogTheme
        )

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
            dialogTheme = dialogTheme
        )

    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        contentView: View,
        firstHeaderIconButton: String,
        firstHeaderIconButtonAction: View.OnClickListener,
        secondHeaderIconButton: String,
        secondHeaderIconButtonAction: View.OnClickListener,
        thirdHeaderIconButton: String,
        thirdHeaderIconButtonAction: View.OnClickListener,
        divider: Boolean = false,
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
            dialogTheme = dialogTheme,
            firstHeaderIconButton = firstHeaderIconButton,
            firstHeaderIconButtonAction = firstHeaderIconButtonAction,
            secondHeaderIconButton = secondHeaderIconButton,
            secondHeaderIconButtonAction = secondHeaderIconButtonAction,
            thirdHeaderIconButton = thirdHeaderIconButton,
            thirdHeaderIconButtonAction = thirdHeaderIconButtonAction,
            divider = divider
        )

    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        contentLayout: Int,
        firstHeaderIconButton: String,
        firstHeaderIconButtonAction: View.OnClickListener,
        secondHeaderIconButton: String,
        secondHeaderIconButtonAction: View.OnClickListener,
        thirdHeaderIconButton: String,
        thirdHeaderIconButtonAction: View.OnClickListener,
        divider: Boolean = false,
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
            dialogTheme = dialogTheme,
            firstHeaderIconButton = firstHeaderIconButton,
            firstHeaderIconButtonAction = firstHeaderIconButtonAction,
            secondHeaderIconButton = secondHeaderIconButton,
            secondHeaderIconButtonAction = secondHeaderIconButtonAction,
            thirdHeaderIconButton = thirdHeaderIconButton,
            thirdHeaderIconButtonAction = thirdHeaderIconButtonAction,
            divider = divider
        )

    @JvmOverloads
    constructor(
        context: Context,
        dialogTitle: String,
        mainButtonTitle: String,
        mainButtonAction: DialogInterface.OnClickListener,
        secondaryButtonTitle: String,
        secondaryButtonAction: DialogInterface.OnClickListener,
        text: String,
        firstHeaderIconButton: String,
        firstHeaderIconButtonAction: View.OnClickListener,
        secondHeaderIconButton: String,
        secondHeaderIconButtonAction: View.OnClickListener,
        thirdHeaderIconButton: String,
        thirdHeaderIconButtonAction: View.OnClickListener,
        divider: Boolean = false,
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
            dialogTheme = dialogTheme,
            firstHeaderIconButton = firstHeaderIconButton,
            firstHeaderIconButtonAction = firstHeaderIconButtonAction,
            secondHeaderIconButton = secondHeaderIconButton,
            secondHeaderIconButtonAction = secondHeaderIconButtonAction,
            thirdHeaderIconButton = thirdHeaderIconButton,
            thirdHeaderIconButtonAction = thirdHeaderIconButtonAction,
            divider = divider
        )

    lateinit var dialog: AlertDialog

    fun create(): DialogStandard {
        dialog = AlertDialog.Builder(context, resolveThemeResource()).create().apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)

            val dialogView = layoutInflater.inflate(R.layout.dialog_standard_view, null).apply {
                val title = findViewById<TextView>(R.id.dialogAlertTitle)
                val contentContainer = findViewById<ScrollView>(R.id.scrollView)

                title.text = dialogTitle

                firstHeaderIconButton?.let {
                    val firstHeaderIconButton = findViewById<IconButton>(R.id.firstIconButton)
                    setIconButton(firstHeaderIconButton, it, firstHeaderIconButtonAction)
                }

                secondHeaderIconButton?.let {
                    val secondHeaderIconButton = findViewById<IconButton>(R.id.secondIconButton)
                    setIconButton(secondHeaderIconButton, it, secondHeaderIconButtonAction)
                }

                thirdHeaderIconButton?.let {
                    val thirdHeaderIconButton = findViewById<IconButton>(R.id.thirdIconButton)
                    setIconButton(thirdHeaderIconButton, it, thirdHeaderIconButtonAction)
                }

                text?.let {
                    val contentText =
                        layoutInflater.inflate(R.layout.dialog_standard_content, null).apply {
                            val textView = findViewById<TextView>(R.id.dialogAlertText)
                            textView.text = text
                        }
                    contentContainer?.addView(contentText)
                }
                contentView?.let { contentContainer?.addView(contentView) }

                contentLayout?.let {
                    contentContainer?.addView(layoutInflater.inflate(it, null))
                }

                if (divider) {
                    val topDivider = findViewById<Divider>(R.id.topDivider)
                    val bottomDivider = findViewById<Divider>(R.id.bottomDivider)

                    topDivider.visibility = View.VISIBLE
                    bottomDivider.visibility = View.VISIBLE
                }
            }

            setView(dialogView)

            setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle, mainButtonAction)
            setButton(DialogInterface.BUTTON_NEGATIVE, secondaryButtonTitle, secondaryButtonAction)
            setCancelable(isCancelable)
        }
        return this
    }

    fun show() {
        dialog.show()
    }

    private fun setIconButton(iconButton: IconButton, icon: String, action: View.OnClickListener?) {
        iconButton.visibility = View.VISIBLE
        iconButton.setIcon(icon)
        iconButton.setOnClickListener(action)
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
