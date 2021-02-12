package com.natura.android.divider

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Ignore
@RunWith(AndroidJUnit4::class)
class DividerTest {

    private lateinit var divider: Divider
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfDividerFullbleedTypeWasSet() {
        divider = buildDividerFullbleed()

        val type = divider.getType()

        Truth.assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfDividerInsetTypeWasSet() {
        divider = buildDividerInset()

        val type = divider.getType()

        Truth.assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfDividerMiddleTypeWasSet() {
        divider = buildDividerMiddle()

        val type = divider.getType()

        Truth.assertThat(type).isEqualTo(2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingDividerWithoutType() {
        divider = DividerFixture
            .aEmptyDivider()
            .withTypeMiddle()
            .build()
    }

    private fun buildDividerInset(): Divider {
        return DividerFixture
            .aDivider()
            .withTypeInset()
            .build()
    }

    private fun buildDividerFullbleed(): Divider {
        return DividerFixture
            .aDivider()
            .withTypeFullbleed()
            .build()
    }

    private fun buildDividerMiddle(): Divider {
        return DividerFixture
            .aDivider()
            .withTypeMiddle()
            .build()
    }
}
