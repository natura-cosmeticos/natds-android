package com.natura.android.card

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardTest {

    private lateinit var card: Card
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfEnabledRadiusIsTrue() {
        card = buildCardWithRadiusEnabled()

        val radiusEnabled = card.getEnabledRadius()

        assertThat(radiusEnabled).isTrue()
    }

    @Test
    fun checksIfEnabledRadiusIsFalse() {
        card = buildCardWithRadiusDisabled()

        val radiusEnabled = card.getEnabledRadius()

        assertThat(radiusEnabled).isFalse()
    }

    @Test
    fun checksIfEnabledElevationIsTrue() {
        card = buildCardWithElevationEnabled()

        val elevationEnabled = card.getEnabledElevation()

        assertThat(elevationEnabled).isTrue()
    }

    @Test
    fun checksIfEnabledElevationIsFalse() {
        card = buildCardWithElevationDisabled()

        val elevationEnabled = card.getEnabledElevation()

        assertThat(elevationEnabled).isFalse()
    }

    private fun buildCardWithRadiusEnabled(): Card {
        return CardFixture
            .aCard()
            .withEnabledRadius(true)
            .build()
    }

    private fun buildCardWithRadiusDisabled(): Card {
        return CardFixture
            .aCard()
            .withEnabledRadius(false)
            .build()
    }

    private fun buildCardWithElevationEnabled(): Card {
        return CardFixture
            .aCard()
            .withEnabledElevation(true)
            .build()
    }

    private fun buildCardWithElevationDisabled(): Card {
        return CardFixture
            .aCard()
            .withEnabledElevation(false)
            .build()
    }
}
