package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.DialogTitle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import kotlinx.android.synthetic.main.dialog_standard_content.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DialogAlertTest {
    private lateinit var dialog: DialogAlert
    private lateinit var context: Context
    private val message = "Alert Message"
    private val mainButtonTitle = "Main Button"
    private val secondaryButtonTitle = "Secondary Button"

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        context.setTheme(R.style.Theme_Natura_Light)

        dialog = createDialog()
    }

    @Test
    fun checksMainButtonTitle() {
        dialog.show()

        val mainButton = dialog.dialog.getButton(DialogInterface.BUTTON_POSITIVE)

        assertThat(mainButton?.text).isEqualTo(mainButtonTitle)
    }

    @Test
    fun checksSecondaryButtonTitle() {
        dialog.show()

        val mainButton = dialog.dialog.getButton(DialogInterface.BUTTON_NEGATIVE)

        assertThat(mainButton?.text).isEqualTo(secondaryButtonTitle)
    }

    @Test
    fun checksText() {
        dialog.show()

        val textView = dialog.dialog.findViewById<TextView>(R.id.dialogAlertText)

        assertThat(textView?.text).isEqualTo(message)
    }


    private fun createDialog(): DialogAlert {
        return DialogAlert(
            context,
            mainButtonTitle,
            { _, _ -> },
            secondaryButtonTitle,
            { _, _ -> },
            message).create()
    }
}
