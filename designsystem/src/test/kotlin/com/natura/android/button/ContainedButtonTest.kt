package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContainedButtonTest {

    private lateinit var button: ContainedButton
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfSizeSemiWasSet() {
        button = buildContainedButtonWithSemiSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfSizeSemixWasSet() {
        button = buildContainedButtonWithSemiXSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfSizeMediumWasSet() {
        button = buildContainedButtonWithMediumSize()

        val type = button.getSize()

        Truth.assertThat(type).isEqualTo(2)
    }

    private fun buildContainedButtonWithSemiSize(): ContainedButton {
        return ContainedButtonFixture
            .aContainedButton()
            .withSemiSize()
            .build()
    }

    private fun buildContainedButtonWithSemiXSize(): ContainedButton {
        return ContainedButtonFixture
            .aContainedButton()
            .withSemixSize()
            .build()
    }

    private fun buildContainedButtonWithMediumSize(): ContainedButton {
        return ContainedButtonFixture
            .aContainedButton()
            .withMediumSize()
            .build()
    }
}
