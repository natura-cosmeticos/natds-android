package com.natura.android.counter

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class CounterFixture private constructor(
    private var size: Int? = null,
    private var disabled: Int? = null,
    private var label: String? = null,
    private var addDescription: String? = null,
    private var subtractDescription: String? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val NONE_BUTTON_DISABLED = 0
        private const val SUBTRACT_BUTTON_DISABLED = 1
        private const val ADD_BUTTON_DISABLED = 2
        private const val ALL_BUTTON_DISABLED = 3

        private const val SEMIX_SIZE = 0
        private const val MEDIUM_SIZE = 1

        private const val defaultDisabled = NONE_BUTTON_DISABLED
        private const val defaultSize = MEDIUM_SIZE
        private const val defaultLabel = "Design System"
        private const val defaultAddDescription = "Add Description"
        private const val defaultSubtractDescription = "Subtract Description"

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aCounter(): CounterFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return CounterFixture(
                defaultSize, defaultDisabled, defaultLabel, defaultAddDescription, defaultSubtractDescription, context
            )
        }

        fun aEmptyCounter(): CounterFixture {
            return CounterFixture()
        }
    }

    fun withNoneButtonDisabled(): CounterFixture {
        this.disabled = NONE_BUTTON_DISABLED
        return this
    }

    fun withAddButtonDisabled(): CounterFixture {
        this.disabled = ADD_BUTTON_DISABLED
        return this
    }

    fun withSubtractButtonDisabled(): CounterFixture {
        this.disabled = SUBTRACT_BUTTON_DISABLED
        return this
    }

    fun withAllButtonDisabled(): CounterFixture {
        this.disabled = ALL_BUTTON_DISABLED
        return this
    }

    fun withSemixSize(): CounterFixture {
        this.size = SEMIX_SIZE
        return this
    }

    fun withMediumSize(): CounterFixture {
        this.size = MEDIUM_SIZE
        return this
    }

    fun withLabel(label: String): CounterFixture {
        this.label = label
        return this
    }

    fun withAddDescription(description: String): CounterFixture {
        this.addDescription = description
        return this
    }

    fun withSubtractDescription(description: String): CounterFixture {
        this.subtractDescription = description
        return this
    }

    fun build(): Counter {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.ctr_size, size.toString())
            .addAttribute(R.attr.ctr_disabled, disabled.toString())
            .addAttribute(R.attr.ctr_label, label.toString())
            .addAttribute(R.attr.ctr_add_description, addDescription.toString())
            .addAttribute(R.attr.ctr_subtract_description, subtractDescription.toString())
            .build()

        return Counter(context, attributes)
    }
}
