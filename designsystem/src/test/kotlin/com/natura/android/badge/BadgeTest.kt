package com.natura.android.badge

import android.content.Context
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BadgeTest {

    private lateinit var badge: Badge
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with number 0, THEN the property should be 0`() {
        badge = BadgeFixture.aBadge().withNumber(0).build()

        val badgeNumber = badge.number

        Truth.assertThat(badgeNumber).isEqualTo(0)
    }

    @Test
    fun `GIVEN a badge, WHEN it's number is set to 2, THEN the property number should be 2`() {
        badge = BadgeFixture.aBadge().withNumber(0).build()
        badge.number = 2

        val badgeNumber = badge.number

        Truth.assertThat(badgeNumber).isEqualTo(2)
    }

    @Test
    fun `GIVEN a badge, WHEN fontWeight is set to true, THEN the property fontWeight should be true`() {
        badge = BadgeFixture.aBadge().withFontWeight(true).build()

        val isFontWeight = badge.getFontWeightOption()

        Truth.assertThat(isFontWeight).isEqualTo(true)
    }

    @Test
    fun `GIVEN a badge, WHEN fontWeight is set to false, THEN the property fontWeight should be false`() {
        badge = BadgeFixture.aBadge().withFontWeight(false).build()

        val isFontWeight = badge.getFontWeightOption()

        Truth.assertThat(isFontWeight).isEqualTo(false)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility false, THEN the property visibility should be false`() {
        badge = BadgeFixture.aBadge().withVisibility(false).build()

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(false)
    }

    @Test
    fun `GIVEN a badge with visibility false, WHEN isVisible property changes to true, THEN the view visibility should be VISIBLE`() {
        badge = BadgeFixture.aBadge().withVisibility(false).build()
        badge.isVisible = true

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun `GIVEN a badge with visibility false, WHEN isVisible property changes to true, THEN isVisible property should be true`() {
        badge = BadgeFixture.aBadge().withVisibility(false).build()
        badge.isVisible = true

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(true)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility false, THEN the view visibility should be INVISIBLE`() {
        badge = BadgeFixture.aBadge().withVisibility(false).build()

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.INVISIBLE)
    }

    @Test
    fun `GIVEN a badge, WHEN it's visibility is set to true, THEN the property visibility should be true`() {
        badge = BadgeFixture.aBadge().withVisibility(true).build()
        badge.isVisible = true

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(true)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility true, THEN the view visibility should be VISIBLE`() {
        badge = BadgeFixture.aBadge().withVisibility(true).build()

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.VISIBLE)
    }
}
