package com.natura.android.iconButton

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
@Ignore
class IconButtonTest {

    private lateinit var iconButton: IconButton
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfIconButtonPrimaryColorIconWasSet() {
        iconButton = buildIconButtonPrimary()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonDefaultColorIconWasSet() {
        iconButton = buildIconButtonDefault()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonMediumSizeWasSet() {
        iconButton = buildIconButtonMedium()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(MEDIUM)
    }

    @Test
    fun checksIfIconButtonSmallSizeWasSet() {
        iconButton = buildIconButtonSmall()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(SMALL)
    }

    @Test
    fun checksIfIconButtonIconChangesWhenSetIcon() {
        iconButton = buildIconButtonDefault()

        iconButton.setIcon(R.drawable.outlined_action_add)
        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_action_add)
    }

    @Test
    fun checksIfIconButtonPrimaryColorWasSet() {
        iconButton = buildIconButtonPrimary()

        val color = iconButton.getColor()

        Truth.assertThat(color).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfIconButtonDefaultColorWasSet() {
        iconButton = buildIconButtonDefault()

        val color = iconButton.getColor()

        Truth.assertThat(color).isEqualTo(DEFAULT)
    }

    @Test
    fun checksIfIconButtonColorWasDisabled() {
        iconButton = buildIconButtonDisabled()

        val enabled = iconButton.isEnabled

        Truth.assertThat(enabled).isEqualTo(false)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonWithoutAnIcon() {
        iconButton = IconButtonFixture
            .aEmptyIconButton()
            .withSizeMedium()
            .withColorPrimary()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonWithoutASize() {
        iconButton = IconButtonFixture
            .aEmptyIconButton()
            .withColorPrimary()
            .withIcon("@drawable/outlined_default_mockup")
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonCutWithoutAColor() {
        iconButton = IconButtonFixture
            .aEmptyIconButton()
            .withSizeSmall()
            .withIcon("@drawable/outlined_default_mockup")
            .build()
    }

    private fun buildIconButtonPrimary(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withColorPrimary()
            .build()
    }

    private fun buildIconButtonDefault(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withColorDefault()
            .build()
    }

    private fun buildIconButtonSmall(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withSizeSmall()
            .build()
    }

    private fun buildIconButtonMedium(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withSizeMedium()
            .build()
    }

    private fun buildIconButtonDisabled(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withDisabled()
            .build()
    }

    companion object {
        private const val SMALL = 0
        private const val MEDIUM = 1
        private const val DEFAULT = 0
        private const val PRIMARY = 1
    }
}
