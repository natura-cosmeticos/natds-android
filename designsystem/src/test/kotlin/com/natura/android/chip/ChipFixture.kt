package com.natura.android.chip

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class ChipFixture private constructor(
    private var label: String = "",
    private var size: Int? = null,
    private var hasAction: Boolean = false,
    private var isComponentSelected: Boolean = false,
    private var isComponentEnabled: Boolean = true,
    private var color: Int? = null,
    private var helperRightType: Int? = null,
    private var helperLeftType: Int? = null,
    private var helperRight: Int? = null,
    private var helperLeft: Int? = null,

    private var labelResourceColor: Int? = null,
    private var borderResourceColor: Int? = null,
    private var backgroundResourceColor: Int? = null,
    private val context: Context = ApplicationProvider.getApplicationContext(),
) {

    companion object {

        private const val SEMI_SIZE = 0
        private const val SEMIX_SIZE = 1
        private const val MEDIUM_SIZE = 2

        private const val NEUTRAL_COLOR = 0
        private const val PRIMARY_COLOR = 1
        private const val SECONDARY_COLOR = 2
        private const val CUSTOM_COLOR = 3

        private const val NONE_TYPE = 0
        private const val ICON_TYPE = 1
        private const val AVATAR_TYPE = 2

        private const val defaultSize = SEMI_SIZE
        private const val defaultHelperLeftType = NONE_TYPE
        private const val defaultHelperRightType = NONE_TYPE
        private const val defaultHelperRight = 0
        private const val defaultHelperLeft = 0
        private const val defaultLabelColorResource = 0
        private const val defaultBackgroundColorResource = 0
        private const val defaultBorderColorResource = 0
        private const val defaultColor = NEUTRAL_COLOR
        private const val defaultLabel = "Design System"
        private const val defaultHasAction = false
        private const val defaultComponentSelected = false
        private const val defaultComponentEnabled = false

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aChip(): ChipFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return ChipFixture(
                defaultLabel,
                defaultSize,
                defaultHasAction,
                defaultComponentSelected,
                defaultComponentEnabled,
                defaultColor,
                defaultHelperRightType,
                defaultHelperLeftType,
                defaultHelperRight,
                defaultHelperLeft,
                defaultLabelColorResource,
                defaultBorderColorResource,
                defaultBackgroundColorResource,
                context
            )
        }

        fun aEmptyChip(): ChipFixture {
            return ChipFixture()
        }
    }

    fun withComponentDisabled(): ChipFixture {
        this.isComponentEnabled = false
        return this
    }

    fun withComponentEnabled(): ChipFixture {
        this.isComponentEnabled = true
        return this
    }

    fun withHasActionTrue(): ChipFixture {
        this.hasAction = true
        return this
    }

    fun withHasActionFalse(): ChipFixture {
        this.hasAction = false
        return this
    }

    fun withIsComponentSelectedTrue(): ChipFixture {
        this.isComponentSelected = true
        return this
    }

    fun withIsComponentSelectedFalse(): ChipFixture {
        this.isComponentSelected = false
        return this
    }

    fun withColorNeutral(): ChipFixture {
        this.color = NEUTRAL_COLOR
        return this
    }

    fun withColorPrimary(): ChipFixture {
        this.color = PRIMARY_COLOR
        return this
    }

    fun withColorSecondary(): ChipFixture {
        this.color = SECONDARY_COLOR
        return this
    }

    fun withColorCustom(): ChipFixture {
        this.color = CUSTOM_COLOR
        return this
    }

    fun withHelperLeftTypeAvatar(): ChipFixture {
        this.helperLeftType = AVATAR_TYPE
        return this
    }

    fun withHelperLeftTypeIcon(): ChipFixture {
        this.helperLeftType = ICON_TYPE
        return this
    }

    fun withHelperRightTypeAvatar(): ChipFixture {
        this.helperRightType = AVATAR_TYPE
        return this
    }

    fun withHelperRightTypeIcon(): ChipFixture {
        this.helperRightType = ICON_TYPE
        return this
    }

    fun withHelperRight(): ChipFixture {
        this.helperRight = 321
        return this
    }

    fun withHelperLeft(): ChipFixture {
        this.helperLeft = 123
        return this
    }

    fun withCustomBorderColor(): ChipFixture {
        this.color = CUSTOM_COLOR
        this.borderResourceColor = 789
        return this
    }

    fun withCustomBackgroundColor(): ChipFixture {
        this.color = CUSTOM_COLOR
        this.backgroundResourceColor = 123
        return this
    }

    fun withCustomLabelColor(): ChipFixture {
        this.color = CUSTOM_COLOR
        this.labelResourceColor = 456
        return this
    }

    fun withSemiSize(): ChipFixture {
        this.size = SEMI_SIZE
        return this
    }

    fun withSemiXSize(): ChipFixture {
        this.size = SEMIX_SIZE
        return this
    }

    fun withMediumSize(): ChipFixture {
        this.size = MEDIUM_SIZE
        return this
    }

    fun withLabel(label: String): ChipFixture {
        this.label = label
        return this
    }

    fun build(): Chip {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(android.R.attr.enabled, isComponentEnabled.toString())
            .addAttribute(R.attr.chp_action, hasAction.toString())
            .addAttribute(R.attr.chp_label, label.toString())
            .addAttribute(R.attr.chp_color, color.toString())
            .addAttribute(R.attr.chp_custom_background_color, backgroundResourceColor.toString())
            .addAttribute(R.attr.chp_custom_label_color, labelResourceColor.toString())
            .addAttribute(R.attr.chp_custom_border_color, borderResourceColor.toString())
            .addAttribute(R.attr.chp_helper_left_type, helperLeftType.toString())
            .addAttribute(R.attr.chp_helper_right_type, helperRightType.toString())
            .addAttribute(R.attr.chp_helper_left, helperLeft.toString())
            .addAttribute(R.attr.chp_helper_right, helperRight.toString())
            .addAttribute(R.attr.chp_selected, isComponentSelected.toString())
            .addAttribute(R.attr.chp_size, size.toString())
            .build()

        return Chip(context, attributes)
    }
}
