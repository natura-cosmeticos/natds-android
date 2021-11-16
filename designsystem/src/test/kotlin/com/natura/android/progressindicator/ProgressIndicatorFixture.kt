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

        enum class Size(val value: Int) {
            STANDARD(0),
            SEMI(1),
            MEDIUM(2),
            LARGE(3)
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
        this.size = Size.MEDIUM.value
        return this
    }

    fun withSizeStandard(): ProgressIndicatorFixture {
        this.size = Size.STANDARD.value
        return this
    }

    fun withSizeSemi(): ProgressIndicatorFixture {
        this.size = Size.SEMI.value
        return this
    }

    fun withSizeLarge(): ProgressIndicatorFixture {
        this.size = Size.LARGE.value
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
            .addAttribute(R.attr.pgid_layer, layer.toString())
            .addAttribute(R.attr.pgid_size, size.toString())
            .build()

        return ProgressIndicator(context, attributes)
    }
}
