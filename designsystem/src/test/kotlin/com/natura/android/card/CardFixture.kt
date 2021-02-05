package com.natura.android.card

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class CardFixture private constructor(
    private var enableRadius: Boolean = false,
    private var enabledElevation: Boolean = false,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val defaultEnabledRadius = true
        private const val defaultEnabledElevation = true
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aCard(): CardFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return CardFixture(defaultEnabledRadius, defaultEnabledElevation)
        }

        fun aEmptyCard(): CardFixture {
            return CardFixture()
        }
    }

    fun withEnabledRadius(enabledRadius: Boolean): CardFixture {
        this.enableRadius = enabledRadius
        return this
    }

    fun withEnabledElevation(enabledElevation: Boolean): CardFixture {
        this.enabledElevation = enabledElevation
        return this
    }

    fun build(): Card {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.enabledElevation, enabledElevation.toString())
            .addAttribute(R.attr.enabledRadius, enableRadius.toString())
            .build()

        return Card(context, attributes)
    }
}
