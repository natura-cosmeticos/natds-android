package com.natura.android.logo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogoTest {

    @Test
    fun checksIfLogoModelAWasSet() {
        val logo = buildLogoWithModelA()

        val model = logo.model.ordinal

        Truth.assertThat(model).isEqualTo(MODEL_A)
    }

    @Test
    fun checksIfLogoModelBWasSet() {
        val logo = buildLogoWithModelB()

        val model = logo.model.ordinal

        Truth.assertThat(model).isEqualTo(MODEL_B)
    }

    @Test
    fun checksIfLogoWithColorPrimaryWasSet() {
        val logo = buildLogoWithColorPrimary()

        val color = logo.color.attribute

        Truth.assertThat(color).isEqualTo(R.attr.colorPrimary)
    }

    @Test
    fun checksIfLogoWithColorSecondaryWasSet() {
        val logo = buildLogoWithColorSecondary()

        val color = logo.color.attribute

        Truth.assertThat(color).isEqualTo(R.attr.colorSecondary)
    }

    @Test
    fun checksIfLogoWithColorSurfaceWasSet() {
        val logo = buildLogoWithColorSurface()

        val color = logo.color.attribute

        Truth.assertThat(color).isEqualTo(R.attr.colorSurface)
    }

    @Test
    fun checksIfLogoWithColorHighlightWasSet() {
        val logo = buildLogoWithColorHighlight()

        val color = logo.color.attribute

        Truth.assertThat(color).isEqualTo(R.attr.colorHighlight)
    }

    @Test
    fun checksIfLogoWithColorNeutralWasSet() {
        val logo = buildLogoWithColorNeutral()

        val color = logo.color.attribute

        Truth.assertThat(color).isEqualTo(0)
    }

    @Test
    fun checksIfLogoWithSizeMediumWasSet() {
        val logo = buildLogoWithMediumSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeMedium)
    }

    @Test
    fun checksIfLogoWithSizeMediumXWasSet() {
        val logo = buildLogoWithMediumXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeMediumX)
    }

    @Test
    fun checksIfLogoWithSizeLargeWasSet() {
        val logo = buildLogoWithLargeSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeLarge)
    }

    @Test
    fun checksIfLogoWithSizeLargeXWasSet() {
        val logo = buildLogoWithLargeXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeLargeX)
    }

    @Test
    fun checksIfLogoWithSizeLargeXXWasSet() {
        val logo = buildLogoWithLargeXXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeLargeXX)
    }

    @Test
    fun checksIfLogoWithSizeLargeXXXWasSet() {
        val logo = buildLogoWithLargeXXXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeLargeXXX)
    }

    @Test
    fun checksIfLogoWithSizeHugeWasSet() {
        val logo = buildLogoWithHugeSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeHuge)
    }

    @Test
    fun checksIfLogoWithSizeHugeXWasSet() {
        val logo = buildLogoWithHugeXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeHugeX)
    }

    @Test
    fun checksIfLogoWithSizeHugeXXWasSet() {
        val logo = buildLogoWithHugeXXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeHugeXX)
    }

    @Test
    fun checksIfLogoWithSizeHugeXXXWasSet() {
        val logo = buildLogoWithHugeXXXSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeHugeXXX)
    }

    @Test
    fun checksIfLogoWithSizeVeryHugeWasSet() {
        val logo = buildLogoWithVeryHugeSize()

        val color = logo.size.attribute

        Truth.assertThat(color).isEqualTo(R.attr.sizeVeryHuge)
    }

    private fun buildLogoWithMediumSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeMedium()
            .build()
    }

    private fun buildLogoWithMediumXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeMediumX()
            .build()
    }

    private fun buildLogoWithLargeSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeLarge()
            .build()
    }

    private fun buildLogoWithLargeXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeLargeX()
            .build()
    }

    private fun buildLogoWithLargeXXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeLargeXX()
            .build()
    }

    private fun buildLogoWithLargeXXXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeLargeXXX()
            .build()
    }

    private fun buildLogoWithHugeSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeHuge()
            .build()
    }

    private fun buildLogoWithHugeXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeHugeX()
            .build()
    }

    private fun buildLogoWithHugeXXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeHugeXX()
            .build()
    }

    private fun buildLogoWithHugeXXXSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeHugeXXX()
            .build()
    }

    private fun buildLogoWithVeryHugeSize(): Logo {
        return LogoFixture
            .aLogo()
            .withSizeVeryHuge()
            .build()
    }

    private fun buildLogoWithColorPrimary(): Logo {
        return LogoFixture
            .aLogo()
            .withColorPrimary()
            .build()
    }

    private fun buildLogoWithColorSecondary(): Logo {
        return LogoFixture
            .aLogo()
            .withColorSecondary()
            .build()
    }

    private fun buildLogoWithColorHighlight(): Logo {
        return LogoFixture
            .aLogo()
            .withColorHighlight()
            .build()
    }

    private fun buildLogoWithColorSurface(): Logo {
        return LogoFixture
            .aLogo()
            .withColorSurface()
            .build()
    }

    private fun buildLogoWithColorNeutral(): Logo {
        return LogoFixture
            .aLogo()
            .withColorNeutral()
            .build()
    }

    private fun buildLogoWithModelA(): Logo {
        return LogoFixture
            .aLogo()
            .withModelA()
            .build()
    }

    private fun buildLogoWithModelB(): Logo {
        return LogoFixture
            .aLogo()
            .withModelB()
            .build()
    }

    companion object {
        private const val MODEL_A = 0
        private const val MODEL_B = 1
    }
}
