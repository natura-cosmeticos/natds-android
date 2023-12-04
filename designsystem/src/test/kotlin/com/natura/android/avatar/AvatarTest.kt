package com.natura.android.avatar

import android.content.Context
import androidx.core.view.size
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AvatarTest {

    private lateinit var avatar: GaYaAvatar
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
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

    private fun buildStandardAvatar(): GaYaAvatar {
        return AvatarFixture
            .aAvatar()
            .withStandardSize()
            .build()
    }

    private fun buildSemiAvatar(): GaYaAvatar {
        return AvatarFixture
            .aAvatar()
            .withSemiSize()
            .build()
    }

    private fun buildSemixAvatar(): GaYaAvatar {
        return AvatarFixture
            .aAvatar()
            .withSemixSize()
            .build()
    }

    private fun buildMediumAvatar(): GaYaAvatar {
        return AvatarFixture
            .aAvatar()
            .withMediumSize()
            .build()
    }

    private fun buildLargexxxAvatar(): GaYaAvatar {
        return AvatarFixture
            .aAvatar()
            .withLargexxxSize()
            .build()
    }
}
