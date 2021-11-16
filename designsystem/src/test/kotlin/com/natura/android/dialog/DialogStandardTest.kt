package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import kotlinx.android.synthetic.main.dialog_standard_content.*
import kotlinx.android.synthetic.main.dialog_standard_view.*
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

        val alertTitle = dialog.dialog.findViewById<TextView>(R.id.dialogStandardTitle)

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

        val dialogCustomContent = dialog.dialog.dialogAlertText.text

        assertThat(dialogCustomContent).isEqualTo("Text Example")
    }

    @Test
    fun checksDialogHeaderIcons() {
        dialog = createDialogWithHeaderIcons()
        dialog.show()

        val firstIconButton = dialog.dialog.firstIconButton.getIcon()
        val secondIconButton = dialog.dialog.secondIconButton.getIcon()
        val thirdIconButton = dialog.dialog.thirdIconButton.getIcon()

        assertThat(firstIconButton).isNotNull()
        assertThat(secondIconButton).isNotNull()
        assertThat(thirdIconButton).isNotNull()
    }

    @Test
    fun checksDialogDividers() {
        dialog = createDialogDividers()
        dialog.show()

        val topDivider = dialog.dialog.topDivider
        val bottomDivider = dialog.dialog.bottomDivider

        assertThat(topDivider.visibility).isEqualTo(View.VISIBLE)
        assertThat(bottomDivider.visibility).isEqualTo(View.VISIBLE)
    }

    private fun createDialogWithCustomContentFromResourceId(): DialogStandard {
        return DialogStandard(
            context,
            "Dialog Title",
            "Main Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Secondary Button",
            DialogInterface.OnClickListener { _, _ -> },
            R.layout.dialog_standard_content
        ).create()
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
            view
        ).create()
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
            "Text Example"
        ).create()
    }

    private fun createDialogWithHeaderIcons(): DialogStandard {
        val view = ImageView(context)
        view.setImageResource(R.drawable.default_icon_outlined_default_mockup)

        return DialogStandard(
            context,
            "Title",
            "Confirm Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Close",
            DialogInterface.OnClickListener { _, _ -> },
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            false,
            0,
            "outlined-action-mic",
            null,
            "outlined-action-add",
            null,
            "outlined-action-cancel",
            null
        ).create()
    }

    private fun createDialogDividers(): DialogStandard {
        val view = ImageView(context)
        view.setImageResource(R.drawable.default_icon_outlined_default_mockup)

        return DialogStandard(
            context,
            "Title",
            "Confirm Button",
            DialogInterface.OnClickListener { _, _ -> },
            "Close",
            DialogInterface.OnClickListener { _, _ -> },
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            true,
            0,
            "outlined-action-mic",
            null,
            "outlined-action-add",
            null,
            "outlined-action-cancel",
            null
        ).create()
    }
}
