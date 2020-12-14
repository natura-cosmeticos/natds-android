package com.natura.android.badge

import android.content.Context
import android.view.View
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class BadgeFixture private constructor(
    private var number: Int = 0,
    private var visible: Int = 0,
    private var context: Context = ApplicationProvider.getApplicationContext()) {
        companion object {
            private const val number = 0
            private const val visible = View.INVISIBLE
            private var context = ApplicationProvider.getApplicationContext<Context>()

            fun aBadge(): BadgeFixture {
                context.setTheme(R.style.Theme_Natura)
                return BadgeFixture(number, visible, context)
            }
        }

    fun withNumber(number: Int): BadgeFixture {
        this.number = number
        return this
    }

    fun withVisibility(isVisible: Int): BadgeFixture {
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
