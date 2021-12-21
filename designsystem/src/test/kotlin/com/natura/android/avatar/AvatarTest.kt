package com.natura.android.avatar

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AvatarTest {

    private lateinit var avatar: Avatar
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfAvatarLabelWasSet() {
        avatar = buildAvatarWithLabel()

        val label = avatar.label

        Truth.assertThat(label).isEqualTo("Label")
    }

    @Test
    fun checksIfAvatarUrlWasSet() {
        avatar = buildAvatarWithUrlImage()

        val url = avatar.url

        Truth.assertThat(url).isEqualTo("Url")
    }

    @Test
    fun checksIfAvatarFallbackLabelWasSet() {
        avatar = buildAvatarWithLabelFallback()

        val labelFallback = avatar.labelFallback

        Truth.assertThat(labelFallback).isEqualTo("DS")
    }

    @Test
    fun checksIfAvatarContentDescriptionWasSet() {
        avatar = buildAvatarWithContentDescription()

        val contentDescription = avatar.accessibilityDescription

        Truth.assertThat(contentDescription).isEqualTo("Content Description")
    }

    @Test
    fun checksIfAvatarWithIconTypeWasSet() {
        avatar = buildAvatarWithIcon()

        val type = avatar.type

        Truth.assertThat(type).isEqualTo(0)
    }

    @Test
    fun checksIfAvatarWithLabelTypeWasSet() {
        avatar = buildAvatarWithLabel()

        val type = avatar.type
        val label = avatar.label

        Truth.assertThat(type).isEqualTo(1)
        Truth.assertThat(label).isEqualTo("Label")
    }

    @Test
    fun checksIfAvatarWithImageTypeWasSet() {
        avatar = buildAvatarWithLocalImage()

        val type = avatar.type

        Truth.assertThat(type).isEqualTo(2)
    }

    @Test
    fun checksIfStandardSizeAvatarWasSet() {
        avatar = buildStandardAvatar()

        val size = avatar.size

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checksIfSemiSizeAvatarWasSet() {
        avatar = buildSemiAvatar()

        val size = avatar.size

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checksIfSemixSizeAvatarWasSet() {
        avatar = buildSemixAvatar()

        val size = avatar.size

        Truth.assertThat(size).isEqualTo(2)
    }

    @Test
    fun checksIfMediumSizeAvatarWasSet() {
        avatar = buildMediumAvatar()

        val size = avatar.size

        Truth.assertThat(size).isEqualTo(3)
    }

    @Test
    fun checksIfLargexxxSizeAvatarWasSet() {
        avatar = buildLargexxxAvatar()

        val size = avatar.size

        Truth.assertThat(size).isEqualTo(4)
    }

    private fun buildAvatarWithIcon(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withIconType()
            .withIcon(1)
            .build()
    }

    private fun buildAvatarWithLabel(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withLabelType()
            .withLabel("Label")
            .build()
    }

    private fun buildAvatarWithLocalImage(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withImage(123)
            .build()
    }

    private fun buildAvatarWithUrlImage(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withImageType()
            .withUrl("Url")
            .build()
    }

    private fun buildStandardAvatar(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withStandardSize()
            .build()
    }

    private fun buildSemiAvatar(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withSemiSize()
            .build()
    }

    private fun buildSemixAvatar(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withSemixSize()
            .build()
    }

    private fun buildMediumAvatar(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withMediumSize()
            .build()
    }

    private fun buildLargexxxAvatar(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withLargexxxSize()
            .build()
    }

    private fun buildAvatarWithContentDescription(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withContentDescription("Content Description")
            .build()
    }

    private fun buildAvatarWithFallbackIcon(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withImageType()
            .withFallbackIcon(2)
            .build()
    }

    private fun buildAvatarWithLabelFallback(): Avatar {
        return AvatarFixture
            .aAvatar()
            .withImageType()
            .withFallbackLabel("DS")
            .build()
    }
}
