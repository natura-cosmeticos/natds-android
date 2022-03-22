package com.natura.android.tag

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TagTest {

    private lateinit var tag: Tag
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfTagAlertLabelWasSet() {
        tag = buildTagAlert()

        val label = tag.getLabel()

        assertThat(label).isEqualTo("tag label")
    }

    @Test
    fun checksIfTagLabelChangeWhenSetLabel() {
        tag = buildTagPrimary()

        tag.setLabel("New label")

        assertThat(tag.getLabel()).isEqualTo("New label")
    }

    @Test
    fun checksIfTagPrimaryWasSet() {
        tag = buildTagPrimary()

        val type = tag.getType()

        assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfTagAlertTypeWasSet() {
        tag = buildTagAlert()

        val type = tag.getType()

        assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfTagSecondaryTypeWasSet() {
        tag = buildTagSecondary()

        val type = tag.getType()

        assertThat(type).isEqualTo(2)
    }

    @Test
    fun checksIfTagSuccessTypeWasSet() {
        tag = buildTagSuccess()

        val type = tag.getType()

        assertThat(type).isEqualTo(3)
    }

    @Test
    fun checksIfTagWarningTypeWasSet() {
        tag = buildTagWarning()

        val type = tag.getType()

        assertThat(type).isEqualTo(4)
    }

    @Test
    fun checksIfTagLinkTypeWasSet() {
        tag = buildTagLink()

        val type = tag.getType()

        assertThat(type).isEqualTo(5)
    }

    @Test
    fun checksIfTagSizeSmallWasSet() {
        tag = buildTagSmall()

        val size = tag.getSize()

        assertThat(size).isEqualTo(0)
    }

    @Test
    fun checksIfTagSizeStandardWasSet() {
        tag = buildTagStandard()

        val size = tag.getSize()

        assertThat(size).isEqualTo(1)
    }

    @Test
    fun checksIfTagPositionCenterWasSet() {
        tag = buildTagCenter()

        val position = tag.getPosition()

        assertThat(position).isEqualTo(0)
    }

    @Test
    fun checksIfTagPositionLeftWasSet() {
        tag = buildTagLeft()

        val position = tag.getPosition()

        assertThat(position).isEqualTo(1)
    }

    @Test
    fun checksIfTagPositionRightWasSet() {
        tag = buildTagRight()

        val position = tag.getPosition()

        assertThat(position).isEqualTo(2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingPrimaryTagWithoutALabel() {
        tag = TagFixture
            .aEmptyTag()
            .withTypePrimary()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingAlertTagWithoutALabel() {
        tag = TagFixture
            .aEmptyTag()
            .withTypeAlert()
            .build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowsExceptionWhenBuildingTagWithCustomTypeWithoutColors() {
        tag = TagFixture
            .aEmptyTag()
            .withTypeCustom()
            .build()
    }

    private fun buildTagAlert(): Tag {
        return TagFixture
            .aTag()
            .withTypeAlert()
            .build()
    }

    private fun buildTagPrimary(): Tag {
        return TagFixture
            .aTag()
            .withTypePrimary()
            .build()
    }

    private fun buildTagSecondary(): Tag {
        return TagFixture
            .aTag()
            .withTypeSecondary()
            .build()
    }

    private fun buildTagSuccess(): Tag {
        return TagFixture
            .aTag()
            .withTypeSuccess()
            .build()
    }

    private fun buildTagWarning(): Tag {
        return TagFixture
            .aTag()
            .withTypeWarning()
            .build()
    }

    private fun buildTagLink(): Tag {
        return TagFixture
            .aTag()
            .withTypeLink()
            .build()
    }

    private fun buildTagCustom(): Tag {
        return TagFixture
            .aTag()
            .withTypeCustom()
            .build()
    }

    private fun buildTagSmall(): Tag {
        return TagFixture
            .aTag()
            .withSizeSmall()
            .build()
    }

    private fun buildTagStandard(): Tag {
        return TagFixture
            .aTag()
            .withSizeStandard()
            .build()
    }

    private fun buildTagCenter(): Tag {
        return TagFixture
            .aTag()
            .withPositionCenter()
            .build()
    }

    private fun buildTagLeft(): Tag {
        return TagFixture
            .aTag()
            .withPositionLeft()
            .build()
    }

    private fun buildTagRight(): Tag {
        return TagFixture
            .aTag()
            .withPositionRight()
            .build()
    }

    private fun buildTagWithIcon(): Tag {
        return TagFixture
            .aTag()
            .withIcon(R.drawable.default_icon_outlined_default_mockup)
            .build()
    }

    private fun buildTagWithCustomBackgroundColor(): Tag {
        return TagFixture
            .aTag()
            .withCustomBackgroundColor(R.color.colorBrdNatGray)
            .build()
    }

    private fun buildTagWithCustomLabelColor(): Tag {
        return TagFixture
            .aTag()
            .withCustomBackgroundColor(R.color.colorBrdNatOrange)
            .build()
    }
}
