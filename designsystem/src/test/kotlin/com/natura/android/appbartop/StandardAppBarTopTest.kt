package com.natura.android.appbartop

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.standard_appbar_top.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardAppBarTopTest {

    private lateinit var appBarTop: StandardAppBarTop
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfPrimaryColorWasSet() {
        appBarTop = buildStandardAppBarTopPrimaryColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfDefaultColorWasSet() {
        appBarTop = buildStandardAppBarTopDefaultColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(DEFAULT)
    }

    @Test
    fun checksIfInverseColorWasSet() {
        appBarTop = buildStandardAppBarTopInverseColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(INVERSE)
    }

    @Test
    fun checksIfNoneColorWasSet() {
        appBarTop = buildStandardAppBarTopNoneColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(NONE)
    }

    @Test
    fun checksIfElevationEnabledIsFalse() {
        appBarTop = buildStandardAppBarTopWithElevationDisabled()

        val elevationEnabled = appBarTop.enabledElevation

        Truth.assertThat(elevationEnabled).isEqualTo(false)
    }

    @Test
    fun checksIfElevationEnabledIsTrue() {
        appBarTop = buildStandardAppBarTopWithElevationEnabled()

        val elevationEnabled = appBarTop.enabledElevation

        Truth.assertThat(elevationEnabled).isEqualTo(true)
    }

    @Test
    fun checksIfElevationIsGreaterThanZero() {
        appBarTop = buildStandardAppBarTopWithElevationEnabled()

        val elevation = appBarTop.toolbar.elevation

        Truth.assertThat(elevation).isNotEqualTo(0F)
    }

    @Test
    fun checksIfElevationIsZero() {
        appBarTop = buildStandardAppBarTopWithElevationDisabled()

        val elevation = appBarTop.elevation

        Truth.assertThat(elevation).isEqualTo(0F)
    }

    private fun buildStandardAppBarTopDefaultColor(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withDefaultAppBarColor()
            .build()
    }

    private fun buildStandardAppBarTopPrimaryColor(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withPrimaryAppBarColor()
            .build()
    }

    private fun buildStandardAppBarTopNoneColor(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withNoneAppBarColor()
            .build()
    }

    private fun buildStandardAppBarTopInverseColor(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withInverseAppBarColor()
            .build()
    }

    private fun buildStandardAppBarTopWithElevationEnabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withEnabledElevation(true)
            .build()
    }

    private fun buildStandardAppBarTopWithElevationDisabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withEnabledElevation(false)
            .build()
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3
    }
}
