package com.natura.android.appbartop

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class StandardAppBarTopFixture private constructor(
    private var appBarColor: Int = DEFAULT,
    private var enabledElevation: Boolean = true,
    private var actionRight: Boolean = false,
    private var actionLeft: Boolean = false,
    private var proeminentContent: Boolean = false,
    private var scrollable: Boolean = false,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val NONE = 2
        private const val INVERSE = 3

        private const val defaultAppBarColor = DEFAULT
        private const val defaultEnabledElevation = true
        private const val defaultActionRight = false
        private const val defaultActionLeft = true
        private const val defaultScrollable = true
        private const val defaultProeminentContent = true
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aStandardAppBarTop(): StandardAppBarTopFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return StandardAppBarTopFixture(
                defaultAppBarColor,
                defaultEnabledElevation,
                defaultActionRight,
                defaultActionLeft,
                defaultScrollable,
                defaultProeminentContent,
                context
            )
        }
    }

    fun withDefaultAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = DEFAULT
        return this
    }

    fun withPrimaryAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = PRIMARY
        return this
    }

    fun withNoneAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = NONE
        return this
    }

    fun withInverseAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = INVERSE
        return this
    }

    fun withEnabledElevation(enabledElevation: Boolean): StandardAppBarTopFixture {
        this.enabledElevation = enabledElevation
        return this
    }

    fun withActionRight(actionRight: Boolean): StandardAppBarTopFixture {
        this.actionRight = actionRight
        return this
    }

    fun withActionLeft(actionLeft: Boolean): StandardAppBarTopFixture {
        this.actionLeft = actionLeft
        return this
    }

    fun withProeminentContent(proeminentContent: Boolean): StandardAppBarTopFixture {
        this.proeminentContent = proeminentContent
        return this
    }

    fun withScrollable(scrollable: Boolean): StandardAppBarTopFixture {
        this.scrollable = scrollable
        return this
    }

    fun build(): StandardAppBarTop {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.enabledElevation, enabledElevation.toString())
            .addAttribute(R.attr.appBarColor, appBarColor.toString())
            .build()

        return StandardAppBarTop(context, attributes)
    }
}
