package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OutlinedButtonTest {

    private lateinit var button: OutlinedButton
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfSizeSemiWasSet() {
        button = buildOutlinedButtonWithSemiSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfSizeSemixWasSet() {
        button = buildOutlinedButtonWithSemiXSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfSizeMediumWasSet() {
        button = buildOutlinedButtonWithMediumSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(2)
    }

    private fun buildOutlinedButtonWithSemiSize(): OutlinedButton {
        return OutlinedButtonFixture
            .aOutlinedButton()
            .withSemiSize()
            .build()
    }

    private fun buildOutlinedButtonWithSemiXSize(): OutlinedButton {
        return OutlinedButtonFixture
            .aOutlinedButton()
            .withSemixSize()
            .build()
    }

    private fun buildOutlinedButtonWithMediumSize(): OutlinedButton {
        return OutlinedButtonFixture
            .aOutlinedButton()
            .withMediumSize()
            .build()
    }
}
