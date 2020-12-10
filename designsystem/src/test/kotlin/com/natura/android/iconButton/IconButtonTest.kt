package com.natura.android.iconButton

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows
import org.robolectric.annotation.Config
@Config(sdk = [28])
@RunWith(AndroidJUnit4::class)
class IconButtonTest {

    @Test
    fun checksIfIconButtonPrimaryColorIconWasSet() {
        val iconButton = buildIconButtonPrimary()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.default_icon_outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonDefaultColorIconWasSet() {
        val iconButton = buildIconButtonDefault()

        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.default_icon_outlined_default_mockup)
    }

    @Test
    fun checksIfIconButtonIconChangesWhenSetIcon() {
        val iconButton = buildIconButtonDefault()

        iconButton.setIcon("outlined_action_add")
        val iconShadow = Shadows.shadowOf(iconButton.getIcon().drawable)

        Truth.assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.default_icon_outlined_default_mockup)
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
            .withColorPrimary()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonCutWithoutAColor() {
        IconButtonFixture
            .aEmptyIconButton()
            .withIcon("default_icon_outlined_default_mockup")
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

    private fun buildIconButtonDisabled(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withDisabled()
            .build()
    }

    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val OPACITY05_BASE255 = 61
    }
}
