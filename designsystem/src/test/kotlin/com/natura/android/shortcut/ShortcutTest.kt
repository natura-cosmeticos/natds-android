package com.natura.android.shortcut

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows.shadowOf


@RunWith(AndroidJUnit4::class)
class ShortcutTest {

    private lateinit var shortcut: Shortcut
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        shortcut = buildShortCutOutlinedWithRequiredAttributes()
    }

    @Test
    fun checksIfShortcutOutlinedIconWasSet() {
        val iconShadow = shadowOf(shortcut.getIcon().drawable)

        assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfShortcutContainedIconWasSet() {
        shortcut = buildShortCutContainedWithRequiredAttributes()

        val iconShadow = shadowOf(shortcut.getIcon().drawable)

        assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.outlined_default_mockup)
    }

    @Test
    fun checksIfShortcutOutlinedLabelWasSet() {
        val label = shortcut.getLabel()

        assertThat(label).isEqualTo("shortcut label")
    }

    @Test
    fun checksIfShortcutContainedLabelWasSet() {
        shortcut = buildShortCutContainedWithRequiredAttributes()

        val label = shortcut.getLabel()

        assertThat(label).isEqualTo("shortcut label")
    }

    @Test
    fun checksIfShortcutOutlinedTypeWasSet() {
        val type = shortcut.getType()

        assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfShortcutContainedTypeWasSet() {
        shortcut = buildShortCutContainedWithRequiredAttributes()

        val type = shortcut.getType()

        assertThat(type).isEqualTo(1)
    }

    private fun buildShortCutOutlinedWithRequiredAttributes(): Shortcut {
       val attributeSet =  Robolectric.buildAttributeSet()
           .addAttribute(R.attr.type, "0")
           .addAttribute(R.attr.icon, "@drawable/outlined_default_mockup")
           .addAttribute(R.attr.textLabel, "shortcut label")
           .build()

        context.setTheme(R.style.Theme_Natura)
        return Shortcut(context, attributeSet)
    }

    private fun buildShortCutContainedWithRequiredAttributes(): Shortcut {
        val attributeSet =  Robolectric.buildAttributeSet()
            .addAttribute(R.attr.type, "1")
            .addAttribute(R.attr.icon, "@drawable/outlined_default_mockup")
            .addAttribute(R.attr.textLabel, "shortcut label")
            .build()

        context.setTheme(R.style.Theme_Natura)
        return Shortcut(context, attributeSet)
    }
}