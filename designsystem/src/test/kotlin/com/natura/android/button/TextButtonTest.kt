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

        val size = button.getSize()
        val height = button.minHeight

        Truth.assertThat(size).isEqualTo(SEMI_SIZE)
        Truth.assertThat(height).isEqualTo(SEMI_HEIGHT)
    }

    @Test
    fun checksIfSizeSemixWasSet() {
        button = buildTextButtonWithSemiXSize()

        val size = button.getSize()
        val height = button.minHeight

        Truth.assertThat(size).isEqualTo(SEMIX_SIZE)
        Truth.assertThat(height).isEqualTo(SEMIX_HEIGHT)
    }

    @Test
    fun checksIfSizeMediumWasSet() {
        button = buildTextButtonWithMediumSize()

        val size = button.getSize()
        val height = button.minHeight

        Truth.assertThat(size).isEqualTo(MEDIUM_SIZE)
        Truth.assertThat(height).isEqualTo(MEDIUM_HEIGHT)
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

    companion object {
        private const val SEMI_HEIGHT = 32
        private const val SEMIX_HEIGHT = 40
        private const val MEDIUM_HEIGHT = 48

        private const val SEMI_SIZE = 0
        private const val SEMIX_SIZE = 1
        private const val MEDIUM_SIZE = 2
    }
}
