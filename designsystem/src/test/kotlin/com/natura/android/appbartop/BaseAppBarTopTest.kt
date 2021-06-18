package com.natura.android.appbartop

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.base_appbar_top.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BaseAppBarTopTest {

    private lateinit var appBarTop: BaseAppBarTop
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfPrimaryColorWasSet() {
        appBarTop = buildBaseAppBarTopPrimaryColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfDefaultColorWasSet() {
        appBarTop = buildBaseAppBarTopDefaultColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(DEFAULT)
    }

    @Test
    fun checksIfInverseColorWasSet() {
        appBarTop = buildBaseAppBarTopInverseColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(INVERSE)
    }

    @Test
    fun checksIfNoneColorWasSet() {
        appBarTop = buildBaseAppBarTopNoneColor()

        val color = appBarTop.barColor

        Truth.assertThat(color).isEqualTo(NONE)
    }

    @Test
    fun checksIfElevationEnabledIsFalse() {
        appBarTop = buildBaseAppBarTopWithElevationDisabled()

        val elevationEnabled = appBarTop.enabledElevation

        Truth.assertThat(elevationEnabled).isEqualTo(false)
    }

    @Test
    fun checksIfElevationEnabledIsTrue() {
        appBarTop = buildBaseAppBarTopWithElevationEnabled()

        val elevationEnabled = appBarTop.enabledElevation

        Truth.assertThat(elevationEnabled).isEqualTo(true)
    }

    @Test
    fun checksIsScrollableIsTrue() {
        appBarTop = buildBaseAppBarTopWithScrollableTrue()

        val scrollable = appBarTop.scrollable

        Truth.assertThat(scrollable).isEqualTo(true)
    }

    @Test
    fun checksIsScrollableIsFalse() {
        appBarTop = buildBaseAppBarTopWithScrollableFalse()

        val scrollable = appBarTop.scrollable

        Truth.assertThat(scrollable).isEqualTo(false)
    }

    @Test
    fun checksIfElevationIsGreaterThanZero() {
        appBarTop = buildBaseAppBarTopWithElevationEnabled()

        val elevation = appBarTop.toolbar.elevation

        Truth.assertThat(elevation).isNotEqualTo(0F)
    }

    @Test
    fun checksIfElevationIsZero() {
        appBarTop = buildBaseAppBarTopWithElevationDisabled()

        val elevation = appBarTop.toolbar.elevation

        Truth.assertThat(elevation).isEqualTo(0F)
    }

    private fun buildBaseAppBarTopDefaultColor(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withDefaultAppBarColor()
            .build()
    }

    private fun buildBaseAppBarTopPrimaryColor(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withPrimaryAppBarColor()
            .build()
    }

    private fun buildBaseAppBarTopNoneColor(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withNoneAppBarColor()
            .build()
    }

    private fun buildBaseAppBarTopInverseColor(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withInverseAppBarColor()
            .build()
    }

    private fun buildBaseAppBarTopWithElevationEnabled(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withEnabledElevation(true)
            .build()
    }

    private fun buildBaseAppBarTopWithElevationDisabled(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withEnabledElevation(false)
            .build()
    }

    private fun buildBaseAppBarTopWithScrollableTrue(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withScrollable(true)
            .build()
    }

    private fun buildBaseAppBarTopWithScrollableFalse(): BaseAppBarTop {
        return BaseAppBarTopFixture
            .aBaseAppBarTop()
            .withScrollable(false)
            .build()
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3
    }
}
