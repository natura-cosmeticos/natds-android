package com.natura.android.progressindicator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProgressIndicatorTest {

    private lateinit var progressIndicator: ProgressIndicator
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfProgressIndicatorSizeMediumWasSet() {
        progressIndicator = buildProgressIndicatorWithSizeMedium()

        val size = progressIndicator.getSize()

        Truth.assertThat(size).isEqualTo(2)
    }

    @Test
    fun checksIfProgressIndicatorSizeLargeWasSet() {
        progressIndicator = buildProgressIndicatorWithSizeLarge()

        val size = progressIndicator.getSize()

        Truth.assertThat(size).isEqualTo(3)
    }

    @Test
    fun checksIfProgressIndicatorSizeSemiWasSet() {
        progressIndicator = buildProgressIndicatorWithSizeSemi()

        val size = progressIndicator.getSize()

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checksIfProgressIndicatorSizeStandardWasSet() {
        progressIndicator = buildProgressIndicatorWithSizeStandard()

        val size = progressIndicator.getSize()

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checksIfProgressIndicatorLayerWasSet() {
        progressIndicator = buildProgressIndicatorWithLayer()

        val size = progressIndicator.getLayer()

        Truth.assertThat(size).isEqualTo(true)
    }

    @Test
    fun checksIfProgressIndicatorLayerWasNotSet() {
        progressIndicator = buildProgressIndicatorWithoutLayer()

        val size = progressIndicator.getLayer()

        Truth.assertThat(size).isEqualTo(false)
    }

    private fun buildProgressIndicatorWithLayer(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withLayerTrue()
            .build()
    }

    private fun buildProgressIndicatorWithoutLayer(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withLayerFalse()
            .build()
    }

    private fun buildProgressIndicatorWithSizeMedium(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withSizeMedium()
            .build()
    }

    private fun buildProgressIndicatorWithSizeLarge(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withSizeLarge()
            .build()
    }

    private fun buildProgressIndicatorWithSizeStandard(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withSizeStandard()
            .build()
    }

    private fun buildProgressIndicatorWithSizeSemi(): ProgressIndicator {
        return ProgressIndicatorFixture
            .aProgressIndicator()
            .withSizeSemi()
            .build()
    }
}
