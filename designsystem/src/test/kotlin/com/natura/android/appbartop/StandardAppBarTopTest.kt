package com.natura.android.appbartop

import android.content.Context
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
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

        val color = appBarTop.getColor()

        Truth.assertThat(color).isEqualTo(PRIMARY)
    }

    @Test
    fun checksIfDefaultColorWasSet() {
        appBarTop = buildStandardAppBarTopDefaultColor()

        val color = appBarTop.getColor()

        Truth.assertThat(color).isEqualTo(DEFAULT)
    }

    @Test
    fun checksIfInverseColorWasSet() {
        appBarTop = buildStandardAppBarTopInverseColor()

        val color = appBarTop.getColor()

        Truth.assertThat(color).isEqualTo(INVERSE)
    }

    @Test
    fun checksIfNoneColorWasSet() {
        appBarTop = buildStandardAppBarTopNoneColor()

        val color = appBarTop.getColor()

        Truth.assertThat(color).isEqualTo(NONE)
    }

    @Test
    fun checksIfElevationEnabledIsFalse() {
        appBarTop = buildStandardAppBarTopWithElevationDisabled()

        val elevationEnabled = appBarTop.getElevationEnabled()

        Truth.assertThat(elevationEnabled).isEqualTo(false)
    }

    @Test
    fun checksIfElevationEnabledIsTrue() {
        appBarTop = buildStandardAppBarTopWithElevationEnabled()

        val elevationEnabled = appBarTop.getElevationEnabled()

        Truth.assertThat(elevationEnabled).isEqualTo(true)
    }

    @Test
    fun checksIfScrollableIsTrue() {
        appBarTop = buildStandardAppBarTopWithScrollabletEnabled()

        val scrollable = appBarTop.getScrollable()

        Truth.assertThat(scrollable).isEqualTo(true)
    }

    @Test
    fun checksIfScrollableIsFalse() {
        appBarTop = buildStandardAppBarTopWithScrollabletDisabled()

        val scrollable = appBarTop.getScrollable()

        Truth.assertThat(scrollable).isEqualTo(false)
    }

    @Test
    fun checksIfActionLeftIsInvisible() {
        appBarTop = buildStandardAppBarTopWithActionLeftInVisible()

        val actionLeft = appBarTop.getActionLeft()

        Truth.assertThat(actionLeft).isEqualTo(false)
    }

    @Test
    fun checksIfActionRightIsInvisible() {
        appBarTop = buildStandardAppBarTopWithActionRightInVisible()

        val actionRight = appBarTop.getActionRight()

        Truth.assertThat(actionRight).isEqualTo(false)
    }

    @Test
    fun checksIfProeminentContentIsTrue() {
        appBarTop = buildStandardAppBarTopWithContentProeminentEnabled()

        val proeminentContent = appBarTop.getProeminentContent()

        Truth.assertThat(proeminentContent).isEqualTo(true)
    }

    @Test
    fun checksIfProeminentContentIsFalse() {
        appBarTop = buildStandardAppBarTopWithContentProeminentDisabled()

        val proeminentContent = appBarTop.getProeminentContent()

        Truth.assertThat(proeminentContent).isEqualTo(false)
    }

    @Test
    fun checksIfContentTypeIsText() {
        appBarTop = buildStandardAppBarTopWithTextContentType()

        val contentType = appBarTop.getContentType()

        Truth.assertThat(contentType).isEqualTo(TEXT)
    }

    @Test
    fun checksIfContentTypeIsMedia() {
        appBarTop = buildStandardAppBarTopWithMediaContentType()

        val contentType = appBarTop.getContentType()

        Truth.assertThat(contentType).isEqualTo(MEDIA)
    }

    @Test
    fun checksIfContentTypeIsSearch() {
        appBarTop = buildStandardAppBarTopWithSearchContentType()

        val contentType = appBarTop.getContentType()

        Truth.assertThat(contentType).isEqualTo(SEARCH)
    }

    @Test
    fun checksIfContentPositionIsLeft() {
        appBarTop = buildStandardAppBarTopWithLeftContentPosition()

        val contentPosition = appBarTop.getContentPosition()

        Truth.assertThat(contentPosition).isEqualTo(LEFT)
    }

    @Test
    fun checksIfContentPositionIsCenter() {
        appBarTop = buildStandardAppBarTopWithCenterContentPosition()

        val contentPosition = appBarTop.getContentPosition()

        Truth.assertThat(contentPosition).isEqualTo(CENTER)
    }

    @Test
    fun checksContentTextWasSet() {
        appBarTop = buildStandardAppBarTopWithContentText()

        val contentText = appBarTop.getContentText()

        Truth.assertThat(contentText).isEqualTo("Title Center")
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

        val elevation = appBarTop.toolbar.elevation

        Truth.assertThat(elevation).isEqualTo(0F)
    }

    @Test
    fun checkIfMediaHeightWasSet() {
        appBarTop = buildStandardAppBarTopWithMediaHeight()

        val mediaHeight = appBarTop.getMediaHeight()

        Truth.assertThat(mediaHeight).isEqualTo(10)
    }

    @Test
    fun checkIfMediaWidthWasSet() {
        appBarTop = buildStandardAppBarTopWithMediaWidth()

        val mediaWidth = appBarTop.getMediaWidth()

        Truth.assertThat(mediaWidth).isEqualTo(10)
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

    private fun buildStandardAppBarTopWithMediaContentType(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withMediaContentType()
            .build()
    }

    private fun buildStandardAppBarTopWithTextContentType(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withTextContentType()
            .build()
    }

    private fun buildStandardAppBarTopWithSearchContentType(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withSearchContentType()
            .build()
    }

    private fun buildStandardAppBarTopWithLeftContentPosition(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withLeftContentPosition()
            .build()
    }

    private fun buildStandardAppBarTopWithCenterContentPosition(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withCenterContentPosition()
            .build()
    }

    private fun buildStandardAppBarTopWithActionLeftInVisible(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withActionLeft(false)
            .build()
    }

    private fun buildStandardAppBarTopWithActionRightInVisible(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withActionRight(false)
            .build()
    }

    private fun buildStandardAppBarTopWithContentProeminentEnabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withProeminentContent(true)
            .build()
    }

    private fun buildStandardAppBarTopWithContentProeminentDisabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withProeminentContent(false)
            .build()
    }

    private fun buildStandardAppBarTopWithScrollabletDisabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withScrollable(false)
            .build()
    }

    private fun buildStandardAppBarTopWithScrollabletEnabled(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withScrollable(true)
            .build()
    }

    private fun buildStandardAppBarTopWithContentText(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withContentText("Title Center")
            .build()
    }

    private fun buildStandardAppBarTopWithMediaHeight(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withMediaHeight(10)
            .build()
    }

    private fun buildStandardAppBarTopWithMediaWidth(): StandardAppBarTop {
        return StandardAppBarTopFixture
            .aStandardAppBarTop()
            .withMediaWidth(10)
            .build()
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3

        const val TEXT = 0
        const val MEDIA = 1
        const val SEARCH = 2

        const val LEFT = 0
        const val CENTER = 1
    }
}
