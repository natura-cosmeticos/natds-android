package com.natura.android.shortcut

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf


@RunWith(AndroidJUnit4::class)
class ShortcutTest {

    private lateinit var shortcut: Shortcut
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfShortcutOutlinedIconWasSet() {
        shortcut = buildShortcutOutlined()

        val iconShadow = shadowOf(shortcut.getIcon().drawable)

        assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfShortcutContainedIconWasSet() {
        shortcut = buildShortcutContainedWithRequiredAttributes()

        val iconShadow = shadowOf(shortcut.getIcon().drawable)

        assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfShortcutOutlinedLabelWasSet() {
        shortcut = buildShortcutOutlined()

        val label = shortcut.getLabel()

        assertThat(label).isEqualTo("shortcut label")
    }

    @Test
    fun checksIfShortcutContainedLabelWasSet() {
        shortcut = buildShortcutContainedWithRequiredAttributes()

        val label = shortcut.getLabel()

        assertThat(label).isEqualTo("shortcut label")
    }

    @Test
    fun checksIfShortcutOutlinedTypeWasSet() {
        shortcut = buildShortcutOutlined()

        val type = shortcut.getType()

        assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfShortcutContainedTypeWasSet() {
        shortcut = buildShortcutContainedWithRequiredAttributes()

        val type = shortcut.getType()

        assertThat(type).isEqualTo(1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingContainedShortCutWithoutAnIcon() {
        shortcut = ShortcutFixture
            .aEmptyShortcut()
            .withLabel("Label")
            .withTypeContained()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingOutlinedShortCutWithoutAnIcon() {
        shortcut = ShortcutFixture
            .aEmptyShortcut()
            .withLabel("Label")
            .withTypeOutlined()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingContainedShortCutWithoutALabel() {
        shortcut = ShortcutFixture
            .aEmptyShortcut()
            .withTypeContained()
            .withIcon("@drawable/outlined_default_mockup")
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingOutlinedShortCutWithoutALabel() {
        shortcut = ShortcutFixture
            .aEmptyShortcut()
            .withTypeOutlined()
            .withIcon("@drawable/outlined_default_mockup")
            .build()
    }

    private fun buildShortcutOutlined(): Shortcut =
        ShortcutFixture
            .aShortcut()
            .withTypeOutlined()
            .build()

    private fun buildShortcutContainedWithRequiredAttributes(): Shortcut =
         ShortcutFixture
            .aShortcut()
            .withTypeContained()
            .build()
}
