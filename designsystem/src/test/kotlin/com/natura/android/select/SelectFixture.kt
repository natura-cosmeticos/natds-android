package com.natura.android.select

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class SelectFixture private constructor(
    private var size: Int? = null,
    private var state: Int? = null,
    private var enabled: Boolean? = true,
    private var required: Boolean? = true,
    private var label: String? = null,
    private var footer: String? = null,
    private var readOnly: Boolean? = null,
    private val context: Context = ApplicationProvider.getApplicationContext(),
) {

    companion object {

        private const val MEDIUM_SIZE = 0
        private const val MEDIUMX_SIZE = 1

        private const val NONE_STATE = 0
        private const val SUCCESS_STATE = 1
        private const val ERROR_STATE = 2

        private const val enabled = true
        private const val required = false
        private const val readOnly = false

        private const val defaultSize = MEDIUMX_SIZE
        private const val defaultState = NONE_STATE
        private const val defaultLabel = "Design System"
        private const val defaultFooter = "Footer"

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aSelect(): SelectFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return SelectFixture(
                defaultSize, defaultState, enabled, required, defaultLabel, defaultFooter, readOnly, context
            )
        }

        fun aEmptySelect(): SelectFixture {
            return SelectFixture()
        }
    }

    fun withDisabled(): SelectFixture {
        this.enabled = false
        return this
    }

    fun withEnabled(): SelectFixture {
        this.enabled = true
        return this
    }

    fun withMediumXSize(): SelectFixture {
        this.size = MEDIUMX_SIZE
        return this
    }

    fun withMediumSize(): SelectFixture {
        this.size = MEDIUM_SIZE
        return this
    }

    fun withErrorState(): SelectFixture {
        this.state = ERROR_STATE
        return this
    }

    fun withNoneState(): SelectFixture {
        this.state = NONE_STATE
        return this
    }

    fun withSuccessState(): SelectFixture {
        this.state = SUCCESS_STATE
        return this
    }

    fun withRequiredTrue(): SelectFixture {
        this.required = true
        return this
    }

    fun withRequiredFalse(): SelectFixture {
        this.required = false
        return this
    }

    fun withReadOnlyFalse(): SelectFixture {
        this.readOnly = false
        return this
    }

    fun withReadOnlyTrue(): SelectFixture {
        this.readOnly = true
        return this
    }

    fun withLabel(label: String): SelectFixture {
        this.label = label
        return this
    }

    fun withFooter(footer: String): SelectFixture {
        this.footer = footer
        return this
    }

    fun build(): Select {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(android.R.attr.enabled, enabled.toString())
            .addAttribute(R.attr.slc_footer, footer.toString())
            .addAttribute(R.attr.slc_label, label.toString())
            .addAttribute(R.attr.slc_readonly, readOnly.toString())
            .addAttribute(R.attr.slc_required, required.toString())
            .addAttribute(R.attr.slc_size, size.toString())
            .addAttribute(R.attr.slc_state, state.toString())
            .build()

        return Select(context, attributes)
    }
}
