package com.natura.android.select

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SelectTest {

    private lateinit var select: Select
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfSelectWithStateSuccessWasSet() {
        select = buildSelectWithSuccessState()

        val state = select.state.ordinal

        Truth.assertThat(state).isEqualTo(StateFixture.SUCCESS.ordinal)
    }

    @Test
    fun checksIfSelectWithStateNoneWasSet() {
        select = buildSelectWithNoneState()

        val state = select.state.ordinal

        Truth.assertThat(state).isEqualTo(StateFixture.NONE.ordinal)
    }

    @Test
    fun checksIfSelectWithStateErrorWasSet() {
        select = buildSelectWithErrorState()

        val state = select.state.ordinal

        Truth.assertThat(state).isEqualTo(StateFixture.ERROR.ordinal)
    }

    @Test
    fun checksIfSelectWithSizeMediumWasSet() {
        select = buildSelectWithMediumSize()

        val size = select.size

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checksIfSelectWithSizeMediumXWasSet() {
        select = buildSelectWithMediumXSize()

        val size = select.size

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checksIfSelectWithRequiredFalseWasSet() {
        select = buildSelectNotRequired()

        val required = select.required

        Truth.assertThat(required).isEqualTo(false)
    }

    @Test
    fun checksIfSelectWithRequiredTrueWasSet() {
        select = buildSelectRequired()

        val required = select.required

        Truth.assertThat(required).isEqualTo(true)
    }

    @Test
    fun checksIfSelectEnabledWasSet() {
        select = buildSelectEnabled()

        val enabled = select.isEnabled

        Truth.assertThat(enabled).isEqualTo(true)
    }

    @Test
    fun checksIfSelectDisabledWasSet() {
        select = buildSelectDisabled()

        val enabled = select.isEnabled

        Truth.assertThat(enabled).isEqualTo(false)
    }

    @Test
    fun checksIfSelectReadOnlyTrueWasSet() {
        select = buildSelectWithReadOnlyTrue()

        val readOnly = select.readOnly

        Truth.assertThat(readOnly).isEqualTo(true)
    }

    @Test
    fun checksIfSelectReadOnlyFalseWasSet() {
        select = buildSelectWithReadOnlyFalse()

        val readOnly = select.readOnly

        Truth.assertThat(readOnly).isEqualTo(false)
    }

    @Test
    fun checksIfSelectLabelWasSet() {
        select = buildSelectWithLabel()

        val label = select.label

        Truth.assertThat(label).isEqualTo("Label")
    }

    @Test
    fun checksIfSelectFooterWasSet() {
        select = buildSelectWithFooter()

        val footer = select.footer

        Truth.assertThat(footer).isEqualTo("Footer")
    }

    private fun buildSelectWithSuccessState(): Select {
        return SelectFixture
            .aSelect()
            .withSuccessState()
            .build()
    }

    private fun buildSelectWithErrorState(): Select {
        return SelectFixture
            .aSelect()
            .withErrorState()
            .build()
    }

    private fun buildSelectWithNoneState(): Select {
        return SelectFixture
            .aSelect()
            .withNoneState()
            .build()
    }

    private fun buildSelectWithMediumSize(): Select {
        return SelectFixture
            .aSelect()
            .withMediumSize()
            .build()
    }

    private fun buildSelectWithMediumXSize(): Select {
        return SelectFixture
            .aSelect()
            .withMediumXSize()
            .build()
    }

    private fun buildSelectRequired(): Select {
        return SelectFixture
            .aSelect()
            .withRequiredTrue()
            .build()
    }

    private fun buildSelectNotRequired(): Select {
        return SelectFixture
            .aSelect()
            .withRequiredFalse()
            .build()
    }

    private fun buildSelectDisabled(): Select {
        return SelectFixture
            .aSelect()
            .withDisabled()
            .build()
    }

    private fun buildSelectEnabled(): Select {
        return SelectFixture
            .aSelect()
            .withEnabled()
            .build()
    }

    private fun buildSelectWithReadOnlyTrue(): Select {
        return SelectFixture
            .aSelect()
            .withReadOnlyTrue()
            .build()
    }

    private fun buildSelectWithReadOnlyFalse(): Select {
        return SelectFixture
            .aSelect()
            .withReadOnlyFalse()
            .build()
    }

    private fun buildSelectWithLabel(): Select {
        return SelectFixture
            .aSelect()
            .withLabel("Label")
            .build()
    }

    private fun buildSelectWithFooter(): Select {
        return SelectFixture
            .aSelect()
            .withFooter("Footer")
            .build()
    }

    enum class StateFixture {
        NONE, ERROR, SUCCESS
    }
}
