package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Looper.getMainLooper
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import com.natura.android.divider.Divider
import com.natura.android.iconButton.IconButton
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf

@RunWith(AndroidJUnit4::class)
class DialogStandardTest {
    private lateinit var dialogStandard: DialogStandard
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        context.setTheme(R.style.Theme_Natura_Light)

        dialogStandard = createDialogWithCustomContentFromResourceId()
    }

    @Test
    fun checksDialogTitle() {
        dialogStandard.show()

        val alertTitle = dialogStandard.dialog.findViewById<TextView>(R.id.dialogStandardTitle)

        assertThat(alertTitle?.text).isEqualTo("Dialog Title")
    }

    @Test
    fun checksMainButtonTitle() {
        dialogStandard.show()

        val mainButton = dialogStandard.dialog.getButton(DialogInterface.BUTTON_POSITIVE)

        assertThat(mainButton?.text).isEqualTo("Main Button")
    }

    @Test
    fun checksSecondaryButtonTitle() {
        dialogStandard.show()

        val mainButton = dialogStandard.dialog.getButton(DialogInterface.BUTTON_NEGATIVE)

        assertThat(mainButton?.text).isEqualTo("Secondary Button")
    }

    @Test
    fun checksDialogCustomContentSetByLayoutResource() {
        dialogStandard.show()

        val dialogCustomContent = dialogStandard.dialog.findViewById<FrameLayout>(R.id.custom)

        assertThat(dialogCustomContent?.childCount).isEqualTo(1)
    }

    @Test
    fun checksDialogCustomContentSetByView() {
        dialogStandard = createDialogWithCustomContentFromView()
        dialogStandard.show()

        val dialogCustomContent = dialogStandard.dialog.findViewById<FrameLayout>(R.id.custom)

        assertThat(dialogCustomContent?.childCount).isEqualTo(1)
    }

    @Test
    fun checksDialogCustomText() {
        dialogStandard = createDialogWithCustomText()
        dialogStandard.show()

        val dialogCustomContent = dialogStandard.dialog
            .findViewById<TextView>(R.id.dialogAlertText)?.text

        assertThat(dialogCustomContent).isEqualTo("Text Example")
    }

    @Test
    fun checksDialogHeaderIcons() {
        dialogStandard = createDialogWithHeaderIcons()
        dialogStandard.show()

        val firstIconButton = dialogStandard.dialog.findViewById<IconButton>(R.id.firstIconButton)
            ?.getIcon()
        val secondIconButton =
            dialogStandard.dialog.findViewById<IconButton>(R.id.secondIconButton)?.getIcon()
        val thirdIconButton = dialogStandard.dialog.findViewById<IconButton>(R.id.thirdIconButton)
            ?.getIcon()

        assertThat(firstIconButton).isNotNull()
        assertThat(secondIconButton).isNotNull()
        assertThat(thirdIconButton).isNotNull()
    }

    @Test
    fun checksDialogDividers() {
        dialogStandard = createDialogDividers()
        dialogStandard.show()

        val topDivider = dialogStandard.dialog.findViewById<Divider>(R.id.topDivider)
        val bottomDivider = dialogStandard.dialog.findViewById<Divider>(R.id.bottomDivider)

        assertThat(topDivider?.visibility).isEqualTo(View.VISIBLE)
        assertThat(bottomDivider?.visibility).isEqualTo(View.VISIBLE)
    }

    private fun createDialogWithCustomContentFromResourceId(): DialogStandard {
        return DialogStandard(
            context,
            "Dialog Title",
            "Main Button",
            { _, _ -> },
            "Secondary Button",
            { _, _ -> },
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
            { _, _ -> },
            "Secondary Button",
            { _, _ -> },
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
            { _, _ -> },
            "Secondary Button",
            { _, _ -> },
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
            { _, _ -> },
            "Close",
            { _, _ -> },
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
            { _, _ -> },
            "Close",
            { _, _ -> },
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

    private fun createStandardDialogWithOutlinedButton(): DialogStandard {
        return DialogStandard(
            context,
            "Title",
            "Confirm Button",
            null,
            "Close",
            null,
            "Long text that should be substitied for some dialog text.",
            true,
            null,
            false,
            3
        ).create()
    }
}
