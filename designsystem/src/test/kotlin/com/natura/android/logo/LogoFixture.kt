package com.natura.android.logo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class LogoFixture private constructor(
    private var logoColor: Int = 0,
    private var logoSize: Int = 0,
    private var logoModel: Int = 0,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val NEUTRAL = 0
        private const val PRIMARY = 1
        private const val SECONDARY = 2
        private const val HIGHLIGHT = 3
        private const val SURFACE = 4

        private const val MEDIUM = 0
        private const val MEDIUMX = 1
        private const val LARGE = 2
        private const val LARGEX = 3
        private const val LARGEXX = 4
        private const val LARGEXXX = 5
        private const val HUGE = 6
        private const val HUGEX = 7
        private const val HUGEXX = 8
        private const val HUGEXXX = 9
        private const val VERYHUGE = 10

        private const val MODEL_A = 0
        private const val MODEL_B = 1

        private const val logoColor = NEUTRAL
        private const val logoSize = VERYHUGE
        private const val logoModel = MODEL_A

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aLogo(): LogoFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return LogoFixture(logoColor, logoSize, logoModel, context)
        }

        fun aEmptyLogo(): LogoFixture {
            return LogoFixture()
        }
    }

    fun withColorNeutral(): LogoFixture {
        this.logoColor = NEUTRAL
        return this
    }

    fun withColorPrimary(): LogoFixture {
        this.logoColor = PRIMARY
        return this
    }

    fun withColorSecondary(): LogoFixture {
        this.logoColor = SECONDARY
        return this
    }

    fun withColorHighlight(): LogoFixture {
        this.logoColor = HIGHLIGHT
        return this
    }

    fun withColorSurface(): LogoFixture {
        this.logoColor = SURFACE
        return this
    }

    fun withSizeMedium(): LogoFixture {
        this.logoSize = MEDIUM
        return this
    }

    fun withSizeMediumX(): LogoFixture {
        this.logoSize = MEDIUMX
        return this
    }

    fun withSizeLarge(): LogoFixture {
        this.logoSize = LARGE
        return this
    }

    fun withSizeLargeX(): LogoFixture {
        this.logoSize = LARGEX
        return this
    }

    fun withSizeLargeXX(): LogoFixture {
        this.logoSize = LARGEXX
        return this
    }

    fun withSizeLargeXXX(): LogoFixture {
        this.logoSize = LARGEXXX
        return this
    }

    fun withSizeHuge(): LogoFixture {
        this.logoSize = HUGE
        return this
    }

    fun withSizeHugeX(): LogoFixture {
        this.logoSize = HUGEX
        return this
    }

    fun withSizeHugeXX(): LogoFixture {
        this.logoSize = HUGEXX
        return this
    }

    fun withSizeHugeXXX(): LogoFixture {
        this.logoSize = HUGEXXX
        return this
    }

    fun withSizeVeryHuge(): LogoFixture {
        this.logoSize = VERYHUGE
        return this
    }

    fun withModelA(): LogoFixture {
        this.logoModel = MODEL_A
        return this
    }

    fun withModelB(): LogoFixture {
        this.logoModel = MODEL_B
        return this
    }

    fun build(): Logo {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.customColor, logoColor.toString())
            .addAttribute(R.attr.customSize, logoSize.toString())
            .addAttribute(R.attr.model, logoModel.toString())
            .build()

        return Logo(context, attributes)
    }
}
