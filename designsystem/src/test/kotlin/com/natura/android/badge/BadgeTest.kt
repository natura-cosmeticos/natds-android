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
    fun `GIVEN a badge, WHEN it is created with visibility INVISIBLE, THEN the property visibility should be INVISIBLE`() {
        val badge = BadgeFixture.aBadge().withVisibility(View.INVISIBLE).build()

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(false)
    }

    @Test
    fun `GIVEN a badge, WHEN it's visibility is set to VISIBLE, THEN the property visibility should be VISIBLE`() {
        val badge = BadgeFixture.aBadge().withVisibility(View.INVISIBLE).build()
        badge.isVisible = true

        val badgeVisibility = badge.isVisible

        Truth.assertThat(badgeVisibility).isEqualTo(true)
    }
}
