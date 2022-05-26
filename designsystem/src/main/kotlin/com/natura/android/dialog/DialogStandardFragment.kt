package com.natura.android.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.natura.android.R
import com.natura.android.divider.Divider
import java.lang.ClassCastException

class DialogStandardFragment : DialogFragment() {

    private lateinit var dialogContext: Context
    private var dialogTitle: String = ""
    private var mainButtonTitle: String = ""
    private var dialogText: String = ""
    private var secondaryButtonTitle: String = ""
    private var contentLayout: Int = 0
    private var divider: Boolean = false
    private var styleButtons: Int = DialogStandard.DEFAULT
    private var canCancelable: Boolean = true
    private var dialogTheme: Int = 0

    var callback: DialogStandardFragmentCallback? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        dialogTitle = arguments?.getString(ARG_TITLE) ?: ""
        dialogText = arguments?.getString(ARG_TEXT) ?: ""
        mainButtonTitle = arguments?.getString(ARG_POSITIVE_BUTTON_TITLE) ?: ""
        secondaryButtonTitle = arguments?.getString(ARG_NEGATIVE_BUTTON_TITLE) ?: ""
        contentLayout = arguments?.getInt(ARG_LAYOUT) ?: 0
        dialogTheme = arguments?.getInt(ARG_THEME) ?: 0
        styleButtons = arguments?.getInt(ARG_STYLE_BUTTONS) ?: DEFAULT
        divider = arguments?.getBoolean(ARG_DIVIDER) ?: false
        canCancelable = arguments?.getBoolean(ARG_CANCELABLE) ?: true

        return MaterialAlertDialogBuilder(dialogContext, resolveThemeResource()).create().apply {

            val dialogView = layoutInflater.inflate(R.layout.dialog_standard_view, null).apply {
                val title = findViewById<TextView>(R.id.dialogStandardTitle)
                val contentContainer = findViewById<LinearLayout>(R.id.contentContainer)

                title.typeface = getFontFromTheme(
                    R.attr.dialogTitlePrimaryFontWeight,
                    R.attr.dialogTitleFallbackFontWeight
                )
                title.text = dialogTitle

                if (dialogText.isNotEmpty()) {
                    val contentText =
                        layoutInflater.inflate(R.layout.dialog_standard_content, null).apply {
                            val textView = findViewById<TextView>(R.id.dialogAlertText)
                            textView.typeface = getFontFromTheme(
                                R.attr.dialogBodyPrimaryFontWeight,
                                R.attr.dialogBodyFallbackFontWeight
                            )
                            textView.text = dialogText
                        }
                    contentContainer?.addView(contentText)
                }

                if (contentLayout != 0) {
                    contentContainer?.addView(layoutInflater.inflate(contentLayout, null))
                }

                if (divider) {
                    val topDivider = findViewById<Divider>(R.id.topDivider)
                    val bottomDivider = findViewById<Divider>(R.id.bottomDivider)

                    topDivider.visibility = View.VISIBLE
                    bottomDivider.visibility = View.VISIBLE
                }
            }

            setView(dialogView)

            if (mainButtonTitle.isNotEmpty()) {
                setButton(DialogInterface.BUTTON_POSITIVE, mainButtonTitle) { _, _ ->
                    callback?.onMainButtonClick()
                }
            }

            if (secondaryButtonTitle.isNotEmpty()) {
                setButton(
                    DialogInterface.BUTTON_NEGATIVE,
                    secondaryButtonTitle
                ) { _, _ ->
                    callback?.onSecondaryButtonClick()
                }
            }
            setCancelable(canCancelable)
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dialogContext = context

        try {
            callback = context as DialogStandardFragmentCallback?
        } catch (e: ClassCastException) {
            throw ClassCastException("Calling fragment must implement DialogStandardFragmentCallback interface")
        }
    }

    private fun resolveThemeResource(): Int {
        val dialogThemeResource = TypedValue()

        if (dialogTheme != 0) {
            dialogContext.setTheme(dialogTheme)
        }

        val dialogStyle = when (styleButtons) {
            DEFAULT -> { R.attr.dialogStandardTheme }
            CONTAINED -> { R.attr.dialogWithContainedButtons }
            TEXT -> { R.attr.dialogWithTextButtons }
            else -> { R.attr.dialogWithOutlinedButtons }
        }

        dialogContext.theme.resolveAttribute(dialogStyle, dialogThemeResource, true)

        return dialogThemeResource.resourceId
    }

    private fun getFontFromTheme(fontPrimary: Int, fontFallback: Int): Typeface {
        val output = TypedValue()
        dialogContext.theme.resolveAttribute(fontPrimary, output, true)

        if (output.type == TypedValue.TYPE_NULL) {
            dialogContext.theme.resolveAttribute(fontFallback, output, true)
        }

        return Typeface.create(output.string.toString(), Typeface.NORMAL)
    }

    companion object {
        private const val ARG_TITLE = "argTitle"
        private const val ARG_TEXT = "argText"
        private const val ARG_POSITIVE_BUTTON_TITLE = "argMainButtonTitle"
        private const val ARG_NEGATIVE_BUTTON_TITLE = "argSecondaryButtonTitle"
        private const val ARG_LAYOUT = "argLayout"
        private const val ARG_DIVIDER = "argDivider"
        private const val ARG_STYLE_BUTTONS = "argStyleButtons"
        private const val ARG_CANCELABLE = "argCancelable"
        private const val ARG_THEME = "argTheme"

        const val DEFAULT = 0
        const val CONTAINED = 1
        const val TEXT = 2
        const val OUTLINED = 3

        fun newInstance(
            title: String = "",
            text: String = "",
            mainButtonTitle: String = "",
            secondaryButtonTitle: String = "",
            layout: Int = 0,
            divider: Boolean = false,
            styleButtons: Int = 0,
            cancelable: Boolean = true,
            theme: Int = 0
        ) = DialogStandardFragment().apply {
            arguments = Bundle().apply {

                putString(ARG_TITLE, title)
                putString(ARG_TEXT, text)
                putString(ARG_POSITIVE_BUTTON_TITLE, mainButtonTitle)
                putString(ARG_NEGATIVE_BUTTON_TITLE, secondaryButtonTitle)
                putInt(ARG_LAYOUT, layout)
                putInt(ARG_STYLE_BUTTONS, styleButtons)
                putInt(ARG_THEME, theme)
                putBoolean(ARG_DIVIDER, divider)
                putBoolean(ARG_CANCELABLE, cancelable)
            }
        }
    }
}

interface DialogStandardFragmentCallback {
    fun onMainButtonClick()
    fun onSecondaryButtonClick()
}
