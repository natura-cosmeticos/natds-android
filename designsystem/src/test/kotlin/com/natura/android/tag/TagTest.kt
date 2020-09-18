package com.natura.android.tag

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
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
    fun checksIfTagPrimaryLabelWasSet() {
        tag = buildTagPrimaryWithRequiredAttributes()

        val label = tag.getLabel()

        assertThat(label).isEqualTo("tag label")
    }

    @Test
    fun checksIfTagLabelChangeWhenSetLabel() {
        tag = buildTagPrimaryWithRequiredAttributes()

        tag.setLabel("New label")

        assertThat(tag.getLabel()).isEqualTo("New label")
    }

    @Test
    fun checksIfTagAlertTypeWasSet() {
        tag = buildTagAlert()

        val type = tag.getType()

        assertThat(type).isEqualTo(1)
    }

    @Test
    fun checksIfTagContainedTypeWasSet() {
        tag = buildTagPrimaryWithRequiredAttributes()

        val type = tag.getType()

        assertThat(type).isEqualTo(0)
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

    private fun buildTagAlert(): Tag {
        return TagFixture
            .aTag()
            .withTypeAlert()
            .build()
    }

    private fun buildTagPrimaryWithRequiredAttributes(): Tag {
        return TagFixture
            .aTag()
            .withTypePrimary()
            .build()
    }
}
