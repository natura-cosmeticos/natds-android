package com.natura.android.badge

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class BadgeFixture private constructor(
    private var number: Int = 0,
    private var visible: Boolean = true,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
        companion object {
            private const val number = 0
            private const val visible = true
            private var context = ApplicationProvider.getApplicationContext<Context>()

            fun aBadge(): BadgeFixture {
                return BadgeFixture(number, visible, context)
            }
        }

    fun withNumber(number: Int): BadgeFixture {
        this.number = number
        return this
    }

    fun withVisibility(isVisible: Boolean): BadgeFixture {
        this.visible = isVisible
        return this
    }

    fun build(): Badge {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.badgeNumber, number.toString())
            .addAttribute(R.attr.badgeVisibility, visible.toString())
            .build()

        return Badge(context, attributes)
    }
}
