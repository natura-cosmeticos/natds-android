package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.widget.FrameLayout
import android.widget.ImageView
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
class DialogStandardTest {
    private lateinit var dialog: DialogStandard
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        context.setTheme(R.style.Theme_Natura_Light)

        dialog = createDialogWithCustomContentFromResourceId()
    }

    @Test
    fun checksDialogTitle() {
        dialog.show()

        val alertTitle = dialog.dialog.findViewById<DialogTitle>(R.id.alertTitle)

        assertThat(alertTitle?.text).isEqualTo("Dialog Title")
    }

    @Test
    fun checksMainButtonTitle() {
        dialog.show()

        val mainButton = dialog.dialog.getButton(DialogInterface.BUTTON_POSITIVE)

        assertThat(mainButton?.text).isEqualTo("Main Button")
    }

    @Test
    fun checksSecondaryButtonTitle() {
        dialog.show()

        val mainButton = dialog.dialog.getButton(DialogInterface.BUTTON_NEGATIVE)

        assertThat(mainButton?.text).isEqualTo("Secondary Button")
    }

    @Test
    fun checksDialogCustomContentSetByLayoutResource() {
        dialog.show()

        val dialogCustomContent = dialog.dialog.findViewById<FrameLayout>(R.id.custom)

        assertThat(dialogCustomContent?.childCount).isEqualTo(1)
    }

    @Test
    fun checksDialogCustomContentSetByView() {
        dialog = createDialogWithCustomContentFromView()
        dialog.show()

        val dialogCustomContent = dialog.dialog.findViewById<FrameLayout>(R.id.custom)

        assertThat(dialogCustomContent?.childCount).isEqualTo(1)
    }

    @Test
    fun checksDialogCustomText() {
        dialog = createDialogWithCustomText()
        dialog.show()

        val dialogCustomContent = dialog.dialog.txtViewId.text

        assertThat(dialogCustomContent).isEqualTo("Text Example")
    }

    private fun createDialogWithCustomContentFromResourceId(): DialogStandard {
        return DialogStandard(
            context,
            "Dialog Title",
            "Main Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Secondary Button",
            DialogInterface.OnClickListener { _, _ -> },
            R.layout.dialog_standard_content).create()
    }

    private fun createDialogWithCustomContentFromView(): DialogStandard {
        val view = ImageView(context)
        view.setImageResource(R.drawable.default_icon_outlined_default_mockup)

        return DialogStandard(
            context,
            "Dialog Title",
            "Main Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Secondary Button",
            DialogInterface.OnClickListener { _, _ -> },
            view).create()
    }

    private fun createDialogWithCustomText(): DialogStandard {
        val view = ImageView(context)
        view.setImageResource(R.drawable.default_icon_outlined_default_mockup)

        return DialogStandard(
            context,
            "Dialog Title",
            "Main Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Secondary Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Text Example").create()
    }
}
