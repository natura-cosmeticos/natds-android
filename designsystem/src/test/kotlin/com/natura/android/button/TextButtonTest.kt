package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextButtonTest {

    private lateinit var button: TextButton
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfSizeSemiWasSet() {
        button = buildTextButtonWithSemiSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfSizeSemixWasSet() {
        button = buildTextButtonWithSemiXSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfSizeMediumWasSet() {
        button = buildTextButtonWithMediumSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(2)
    }

    private fun buildTextButtonWithSemiSize(): TextButton {
        return TextButtonFixture
            .aTextButton()
            .withSemiSize()
            .build()
    }

    private fun buildTextButtonWithSemiXSize(): TextButton {
        return TextButtonFixture
            .aTextButton()
            .withSemixSize()
            .build()
    }

    private fun buildTextButtonWithMediumSize(): TextButton {
        return TextButtonFixture
            .aTextButton()
            .withMediumSize()
            .build()
    }
}
