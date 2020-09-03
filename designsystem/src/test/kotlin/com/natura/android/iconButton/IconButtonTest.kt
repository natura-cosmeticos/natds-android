package com.natura.android.iconButton

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
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

        val type = iconButton.getColor()

        Truth.assertThat(type).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfIconButtonDefaultColorWasSet() {
        iconButton = buildIconButtonPrimary()

        val type = iconButton.getColor()

        Truth.assertThat(type).isEqualTo(DEFAULT)
    }

    @Test
    fun checksIfIconButtonColorWasDisabled() {
        iconButton = buildIconButtonDisabled()

        val type = iconButton.isEnabled

        Truth.assertThat(type).isEqualTo(false)
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
            .withIcon("@drawable/outlined_default_mockup")
            .withColorPrimary()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingIconButtonCutWithoutAColor() {
        iconButton = IconButtonFixture
            .aEmptyIconButton()
            .withIcon("@drawable/outlined_default_mockup")
            .withSizeSmall()
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
            .withSizeMedium()
            .build()
    }

    companion object {
        private const val SMALL = 0
        private const val MEDIUM = 1
        private const val DEFAULT = 0
        private const val PRIMARY = 1
    }
}
