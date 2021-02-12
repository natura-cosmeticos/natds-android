package com.natura.android.divider

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class DividerFixture private constructor(
    private var dividerType: Int? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val FULLBLEED = 0
        private const val INSET = 1
        private const val MIDDLE = 2

        private const val defaultType = FULLBLEED
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aDivider(): DividerFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return DividerFixture(defaultType, context)
        }

        fun aEmptyDivider(): DividerFixture {
            return DividerFixture()
        }
    }

    fun withTypeFullbleed(): DividerFixture {
        this.dividerType = FULLBLEED
        return this
    }

    fun withTypeInset(): DividerFixture {
        this.dividerType = INSET
        return this
    }

    fun withTypeMiddle(): DividerFixture {
        this.dividerType = MIDDLE
        return this
    }

    fun build(): Divider {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.dividerType, dividerType.toString())
            .build()

        return Divider(context, attributes)
    }
}
