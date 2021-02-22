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
        private const val STANDARD = 0
        private const val SEMI = 1
        private const val MEDIUM = 2
        private const val LARGE = 3

        private const val defaultSize = MEDIUM
        private const val defaultLayer = false
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aProgressIndicator(): ProgressIndicatorFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return ProgressIndicatorFixture(defaultSize, defaultLayer, context)
        }

        fun aEmptyProgressIndicator(): ProgressIndicatorFixture {
            return ProgressIndicatorFixture()
        }
    }

    fun withSizeMedium(): ProgressIndicatorFixture {
        this.size = MEDIUM
        return this
    }

    fun withSizeStandard(): ProgressIndicatorFixture {
        this.size = STANDARD
        return this
    }

    fun withSizeSemi(): ProgressIndicatorFixture {
        this.size = SEMI
        return this
    }

    fun withSizeLarge(): ProgressIndicatorFixture {
        this.size = LARGE
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
