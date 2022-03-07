package com.natura.android.counter

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterTest {

    private lateinit var counter: Counter
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfCounterLabelWasSet() {
        counter = buildCounterWithLabel()

        val label = counter.label

        Truth.assertThat(label).isEqualTo("Label")
    }

    @Test
    fun checksIfCounterAddDescriptionWasSet() {
        counter = buildCounterWithAddDescription()

        val contentDescription = counter.addDescription

        Truth.assertThat(contentDescription).isEqualTo("Add Description")
    }

    @Test
    fun checksIfCounterSubtractDescriptionWasSet() {
        counter = buildCounterWithSubtractDescription()

        val contentDescription = counter.subtractDescription

        Truth.assertThat(contentDescription).isEqualTo("Subtract Description")
    }

    @Test
    fun checksIfSemixSizeCounterWasSet() {
        counter = buildSemixCounter()

        val size = counter.size

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checksIfMediumSizeCounterWasSet() {
        counter = buildMediumCounter()

        val size = counter.size

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checksIfAllButtonDisabledOptionWasSet() {
        counter = buildAllButtonDisabledCounter()

        val disabled = counter.disabled

        Truth.assertThat(disabled).isEqualTo(3)
    }

    @Test
    fun checksIfAddButtonDisabledOptionWasSet() {
        counter = buildAddButtonDisabledCounter()

        val disabled = counter.disabled

        Truth.assertThat(disabled).isEqualTo(2)
    }

    @Test
    fun checksIfSubtractButtonDisabledOptionWasSet() {
        counter = buildSubtractButtonDisabledCounter()

        val disabled = counter.disabled

        Truth.assertThat(disabled).isEqualTo(1)
    }

    @Test
    fun checksIfNoneButtonDisabledOptionWasSet() {
        counter = buildNoneButtonDisabledCounter()

        val disabled = counter.disabled

        Truth.assertThat(disabled).isEqualTo(0)
    }

    private fun buildCounterWithLabel(): Counter {
        return CounterFixture
            .aCounter()
            .withLabel("Label")
            .build()
    }

    private fun buildSemixCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withSemixSize()
            .build()
    }

    private fun buildMediumCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withMediumSize()
            .build()
    }

    private fun buildNoneButtonDisabledCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withNoneButtonDisabled()
            .build()
    }

    private fun buildAddButtonDisabledCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withAddButtonDisabled()
            .build()
    }

    private fun buildSubtractButtonDisabledCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withSubtractButtonDisabled()
            .build()
    }

    private fun buildAllButtonDisabledCounter(): Counter {
        return CounterFixture
            .aCounter()
            .withAllButtonDisabled()
            .build()
    }

    private fun buildCounterWithAddDescription(): Counter {
        return CounterFixture
            .aCounter()
            .withAddDescription("Add Description")
            .build()
    }

    private fun buildCounterWithSubtractDescription(): Counter {
        return CounterFixture
            .aCounter()
            .withAddDescription("Add Description")
            .build()
    }
}
