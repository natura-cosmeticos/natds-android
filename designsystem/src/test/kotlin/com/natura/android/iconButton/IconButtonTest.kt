package com.natura.android.iconButton

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [23, 28])
class IconButtonTest {

    @Test
    fun checksIfIconButtonPrimaryColorIconWasSet() {
        val iconButton = buildIconButtonPrimary()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonDefaultColorIconWasSet() {
        val iconButton = buildIconButtonDefault()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonMediumSizeWasSet() {
       val iconButton = buildIconButtonMedium()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(MEDIUM)
    }

    @Test
    fun checksIfIconButtonSmallSizeWasSet() {
       val iconButton = buildIconButtonSmall()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(SMALL)
    }

    @Test
    fun checksIfIconButtonIconChangesWhenSetIcon() {
        val iconButton = buildIconButtonDefault()

        iconButton.setIcon("outlined_action_add")
        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_action_add)
    }

    @Test
    fun checksIfIconButtonPrimaryColorWasSet() {
        val iconButton = buildIconButtonPrimary()

        val color = iconButton.getColor()

        Truth.assertThat(color).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfIconButtonDefaultColorWasSet() {
        val iconButton = buildIconButtonDefault()

        val color = iconButton.getColor()

        Truth.assertThat(color).isEqualTo(DEFAULT)
    }

    @Test
    fun `Given disabled flag is false, when IconButton is created, isEnabled attribute is false`() {
        val iconButton = buildIconButtonDisabled()

        val enabled = iconButton.isEnabled

        Truth.assertThat(enabled).isEqualTo(false)
    }

    @Test
    fun `Given disabled flag is false, when IconButton is created, IconButton color has an alpha applied`() {
        val iconButton = buildIconButtonDisabled()

        val iconButtonAlpha = iconButton.getIcon().imageAlpha

        Truth.assertThat(iconButtonAlpha).isEqualTo(OPACITY05_BASE255)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonWithoutAnIcon() {
       IconButtonFixture
            .aEmptyIconButton()
            .withSizeMedium()
            .withColorPrimary()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonWithoutASize() {
       IconButtonFixture
            .aEmptyIconButton()
            .withColorPrimary()
            .withIcon("outlined_default_mockup")
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonCutWithoutAColor() {
        IconButtonFixture
            .aEmptyIconButton()
            .withSizeSmall()
            .withIcon("outlined_default_mockup")
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
        private const val OPACITY05_BASE255 = 61
    }
}
