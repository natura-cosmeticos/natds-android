package com.natura.android.tag

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class TagFixture private constructor(
    private var type: Int? = null,
    private var label: String? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val PRIMARY = 0
        private const val ALERT = 1

        private const val defaultType = PRIMARY
        private const val defaultLabel = "tag label"
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aTag(): TagFixture {
            context.setTheme(R.style.Theme_Natura)
            return TagFixture(defaultType, defaultLabel, context)
        }

        fun aEmptyTag(): TagFixture {
            return TagFixture()
        }
    }

    fun withTypePrimary(): TagFixture {
        this.type = PRIMARY
        return this
    }

    fun withTypeAlert(): TagFixture {
        this.type = ALERT
        return this
    }

    fun withLabel(label: String): TagFixture {
        this.label = label
        return this
    }

    fun withContext(customContext: Context): TagFixture {
        this.context = customContext
        return this
    }

    fun build(): Tag {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.tag_type, type.toString())
            .addAttribute(R.attr.textLabel, label)
            .build()

        return Tag(context, attributes)
    }
}
