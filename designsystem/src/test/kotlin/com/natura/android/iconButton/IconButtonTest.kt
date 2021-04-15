package com.natura.android.iconButton

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import kotlinx.android.synthetic.main.icon_button.view.*
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
    fun checksIfIconButtonLightColorWasSet() {
        val iconButton = buildIconButtonLight()

        val color = iconButton.getColor()

        Truth.assertThat(color).isEqualTo(LIGHT)
    }

    @Test
    fun checksIfIconButtonInheritStyleWasSet() {
        val iconButton = buildIconButtonStyleInherit()

        val style = iconButton.getStyle()

        Truth.assertThat(style).isEqualTo(INHERIT)
    }

    @Test
    fun checksIfIconButtonFloatingStyleWasSet() {
        val iconButton = buildIconButtonStyleFloating()

        val style = iconButton.getStyle()

        Truth.assertThat(style).isEqualTo(FLOATING)
    }

    @Test
    fun checksIfIconButtonOverlayStyleWasSet() {
        val iconButton = buildIconButtonStyleOverlay()

        val style = iconButton.getStyle()

        Truth.assertThat(style).isEqualTo(OVERLAY)
    }

    @Test
    fun checksIfIconButtonSizeSemiWasSet() {
        val iconButton = buildIconButtonSizeSemi()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(SEMI)
    }

    @Test
    fun checksIfIconButtonSizeSemiXWasSet() {
        val iconButton = buildIconButtonSizeSemiX()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(SEMIX)
    }

    @Test
    fun checksIfIconButtonSizeMediumWasSet() {
        val iconButton = buildIconButtonSizeMedium()

        val size = iconButton.getSize()

        Truth.assertThat(size).isEqualTo(MEDIUM)
    }

    @Test
    fun checksIfWidthAndHeightWereSetWhenSizeIsSemi() {
        val iconButton = buildIconButtonSizeSemi()

        val sizeContainer = iconButton.iconButtonContainer.layoutParams.width
        val sizeIcon = iconButton.iconButtonContainer.iconButtonIcon.layoutParams.width

        Truth.assertThat(sizeIcon).isEqualTo(24)
        Truth.assertThat(sizeContainer).isEqualTo(32)
    }

    @Test
    fun checksIfWidthAndHeightWereSetWhenSizeIsSemiX() {
        val iconButton = buildIconButtonSizeSemiX()

        val sizeContainer = iconButton.iconButtonContainer.layoutParams.width
        val sizeIcon = iconButton.iconButtonContainer.iconButtonIcon.layoutParams.width

        Truth.assertThat(sizeIcon).isEqualTo(32)
        Truth.assertThat(sizeContainer).isEqualTo(40)
    }

    @Test
    fun checksIfWidthAndHeightWereSetWhenSizeIsMedium() {
        val iconButton = buildIconButtonSizeMedium()

        val sizeContainer = iconButton.iconButtonContainer.layoutParams.width
        val sizeIcon = iconButton.iconButtonContainer.iconButtonIcon.layoutParams.width

        Truth.assertThat(sizeIcon).isEqualTo(40)
        Truth.assertThat(sizeContainer).isEqualTo(48)
    }

    @Test
    fun `Given disabled flag is false, when IconButton is created, isEnabled attribute is false`() {
        val iconButton = buildIconButtonDisabled()

        val enabled = iconButton.isEnabled

        Truth.assertThat(enabled).isEqualTo(false)
    }

    @Test
    fun `Given notify attribute is bigger than 0, when IconButton is created, then badge should be visible`() {
        val iconButton = buildIconButtonWithNotification()

        val badge = iconButton.getBadge()

        Truth.assertThat(badge.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun `Given notify attribute is 0, when IconButton is created, then badge should NOT be visible`() {
        val iconButton = buildIconButtonPrimary()

        val badge = iconButton.getBadge()

        Truth.assertThat(badge.visibility).isEqualTo(View.INVISIBLE)
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

    private fun buildIconButtonWithNotification(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withNotification(4)
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

    private fun buildIconButtonLight(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withColorLight()
            .build()
    }

    private fun buildIconButtonDisabled(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withDisabled()
            .build()
    }

    private fun buildIconButtonSizeSemi(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withSizeSemi()
            .build()
    }

    private fun buildIconButtonSizeSemiX(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withSizeSemiX()
            .build()
    }

    private fun buildIconButtonSizeMedium(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withSizeMedium()
            .build()
    }

    private fun buildIconButtonStyleInherit(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withStyleInherit()
            .build()
    }

    private fun buildIconButtonStyleFloating(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withStyleFloating()
            .build()
    }

    private fun buildIconButtonStyleOverlay(): IconButton {
        return IconButtonFixture
            .aIconButton()
            .withStyleOverlay()
            .build()
    }

    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val LIGHT = 2
        private const val OPACITY05_BASE255 = 61

        private const val SEMI = 0
        private const val SEMIX = 1
        private const val MEDIUM = 2

        private const val INHERIT = 0
        private const val FLOATING = 1
        private const val OVERLAY = 2
    }
}
