package com.natura.android.badge

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
class BadgeTest {
    @Test
    fun `GIVEN a badge, WHEN it is created with number 0, THEN the property should be 0`() {
        val badge = BadgeFixture.aBadge().withNumber(0).build()

        val badgeNumber = badge.number

        Truth.assertThat(badgeNumber).isEqualTo(0)
    }

    @Test
    fun `GIVEN a badge, WHEN it's number is set to 2, THEN the property number should be 2`() {
        val badge = BadgeFixture.aBadge().withNumber(0).build()
        badge.number = 2

        val badgeNumber = badge.number

        Truth.assertThat(badgeNumber).isEqualTo(2)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility false, THEN the property visibility should be false`() {
        val badge = BadgeFixture.aBadge().withVisibility(false).build()

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(false)
    }

    @Test
    fun `GIVEN a badge with visibility false, WHEN isVisible property changes to true, THEN the view visibility should be VISIBLE`() {
        val badge = BadgeFixture.aBadge().withVisibility(false).build()
        badge.isVisible = true

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun `GIVEN a badge with visibility false, WHEN isVisible property changes to true, THEN isVisible property should be true`() {
        val badge = BadgeFixture.aBadge().withVisibility(false).build()
        badge.isVisible = true

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(true)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility false, THEN the view visibility should be INVISIBLE`() {
        val badge = BadgeFixture.aBadge().withVisibility(false).build()

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.INVISIBLE)
    }

    @Test
    fun `GIVEN a badge, WHEN it's visibility is set to true, THEN the property visibility should be true`() {
        val badge = BadgeFixture.aBadge().withVisibility(true).build()
        badge.isVisible = true

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(true)
    }

    @Test
    fun `GIVEN a badge, WHEN it is created with visibility true, THEN the view visibility should be VISIBLE`() {
        val badge = BadgeFixture.aBadge().withVisibility(true).build()

        val badgeVisibility = badge.visibility

        Truth.assertThat(badgeVisibility).isEqualTo(View.VISIBLE)
    }
}
