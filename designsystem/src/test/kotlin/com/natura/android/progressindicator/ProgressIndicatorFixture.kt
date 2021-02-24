package com.natura.android.progressindicator

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class ProgressIndicatorFixture private constructor(
    private var size: Int? = null,
    private var layer: Boolean? = null,

    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {

        enum class Size {
            STANDARD, SEMI, MEDIUM, LARGE
        }

        private val defaultSize = Size.MEDIUM.ordinal
        private const val defaultLayer = false
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aProgressIndicator(): ProgressIndicatorFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return ProgressIndicatorFixture(defaultSize, defaultLayer, context)
        }
    }

    fun withSizeMedium(): ProgressIndicatorFixture {
        this.size = Size.MEDIUM.ordinal
        return this
    }

    fun withSizeStandard(): ProgressIndicatorFixture {
        this.size = Size.STANDARD.ordinal
        return this
    }

    fun withSizeSemi(): ProgressIndicatorFixture {
        this.size = Size.SEMI.ordinal
        return this
    }

    fun withSizeLarge(): ProgressIndicatorFixture {
        this.size = Size.LARGE.ordinal
        return this
    }

    fun withLayerTrue(): ProgressIndicatorFixture {
        this.layer = true
        return this
    }

    fun withLayerFalse(): ProgressIndicatorFixture {
        this.layer = false
        return this
    }

    fun build(): ProgressIndicator {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.layer, layer.toString())
            .addAttribute(R.attr.size, size.toString())
            .build()

        return ProgressIndicator(context, attributes)
    }
}
