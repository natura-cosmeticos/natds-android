package com.natura.android.chip

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.natura.android.R
import com.natura.android.exceptions.LayoutInflateException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme

class Chip : ConstraintLayout {

    constructor(context: Context) :
        super(context) {
            init(context)
        }

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs) {
            init(context, attrs)
        }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
        super(context, attrs, defStyleAttr) {
            init(context, attrs)
        }

    private val labelTextView by lazy { findViewById<TextView>(R.id.chp_label) }
    private val backgroundView by lazy { findViewById<LinearLayout>(R.id.chp_background) }

    private val iconLeft by lazy { findViewById<ImageView>(R.id.chp_icon_left) }
    private val avatarLeft by lazy { findViewById<ImageView>(R.id.chp_avatar_left) }

    private val iconRight by lazy { findViewById<ImageView>(R.id.chp_icon_right) }
    private val avatarRight by lazy { findViewById<ImageView>(R.id.chp_avatar_right) }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        labelTextView.isEnabled = false
        backgroundView.isEnabled = false
        iconLeft.isEnabled = false
        avatarLeft.isEnabled = false
        iconRight.isEnabled = false
        avatarRight.isEnabled = false
    }

    private lateinit var typedArray: TypedArray

    var label: String = ""
        set(value) {
            setContentLabel(value)
        }

    var size: Int = SEMI
        set(value) {
            field = value
            configureSize(getDrawable())
        }

    var hasAction: Boolean = false
    var isComponentSelected: Boolean = false

    var color: Int = NEUTRAL

    var helperRightType: Int = NONE_TYPE
    var helperLeftType: Int = NONE_TYPE
    var helperLeft: Int = RESOURCE_NOT_DEFINED
    var helperRight: Int = RESOURCE_NOT_DEFINED

    var labelResourceColor: Int = RESOURCE_NOT_DEFINED
    var borderResourceColor: Int = RESOURCE_NOT_DEFINED
    var backgroundResourceColor: Int = RESOURCE_NOT_DEFINED

    private fun init(context: Context, attrs: AttributeSet? = null) {

        try {
            View.inflate(context, R.layout.chip, this)
        } catch (e: Exception) {
            throw LayoutInflateException()
        }

        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.Chip)
        }

        getAttributes()
        configureAction()
        configureAppearance(getDrawable())

        typedArray.recycle()
        requestLayout()
    }

    private fun getAttributes() {

        typedArray.apply {
            label = getString(R.styleable.Chip_chp_label) ?: ""
            size = getInt(R.styleable.Chip_chp_size, SEMI)
            color = getInt(R.styleable.Chip_chp_color, NEUTRAL)
            labelResourceColor = getColor(
                R.styleable.Chip_chp_custom_label_color,
                getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
            )
            borderResourceColor = getColor(
                R.styleable.Chip_chp_custom_border_color,
                getColorTokenFromTheme(context, R.attr.colorLowEmphasis)
            )
            backgroundResourceColor = getColor(
                R.styleable.Chip_chp_custom_background_color,
                getColorTokenFromTheme(context, R.attr.colorHighLightOpacityFull)
            )
            hasAction = getBoolean(R.styleable.Chip_chp_action, false)
            isComponentSelected = getBoolean(R.styleable.Chip_chp_selected, false)
            helperLeftType = getInt(R.styleable.Chip_chp_helper_left_type, NONE_TYPE)
            helperRightType = getInt(R.styleable.Chip_chp_helper_right_type, NONE_TYPE)
            helperLeft = getResourceId(R.styleable.Chip_chp_helper_left, RESOURCE_NOT_DEFINED)
            helperRight = getResourceId(R.styleable.Chip_chp_helper_right, RESOURCE_NOT_DEFINED)
        }
    }

    private fun configureSize(backgroundDrawable: GradientDrawable) {
        val heightAttr = when (size) {
            SEMI -> R.attr.sizeSemi
            SEMIX -> R.attr.sizeSemiX
            MEDIUM -> R.attr.sizeMedium
            else -> R.attr.sizeSemi
        }

        val params = backgroundView.layoutParams
        params.height = getDimenFromTheme(context, heightAttr).toInt()
        backgroundView.layoutParams = params
        backgroundView.background = backgroundDrawable
        requestLayout()
    }

    private fun configureAction() {
    }

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {

        val backgroundColorAttr = when {
            !isEnabled -> R.attr.colorLowEmphasis
            !isComponentSelected -> R.attr.colorTranparent
            else -> {
                when (color) {
                    NEUTRAL -> R.attr.colorPrimary
                    PRIMARY -> R.attr.colorPrimary
                    SECONDARY -> R.attr.colorSecondary
                    else -> R.attr.colorPrimary
                }
            }
        }

        val borderColorAttr = when {
            !isEnabled -> R.attr.colorLowEmphasis
            else -> {
                when (color) {
                    PRIMARY -> R.attr.colorPrimary
                    SECONDARY -> R.attr.colorSecondary
                    NEUTRAL -> {
                        if (isComponentSelected) {
                            R.attr.colorPrimary
                        } else {
                            R.attr.colorLowEmphasis
                        }
                    }
                    else -> R.attr.colorLowEmphasis
                }
            }
        }

        val labelColor = if (color == CUSTOM) {
            labelResourceColor
        } else {
            getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
        }

        labelTextView.setTextColor(labelColor)

        backgroundDrawable.mutate()
        backgroundDrawable.setStroke(
            BORDER_WIDTH,
            if (color == CUSTOM) {
                borderResourceColor
            } else {
                getColorTokenFromTheme(context, borderColorAttr)
            }
        )
        backgroundDrawable.setColor(
            if (color == CUSTOM && isComponentSelected) {
                backgroundResourceColor
            } else {
                getColorTokenFromTheme(context, backgroundColorAttr)
            }
        )
        backgroundView.background = backgroundDrawable

        requestLayout()
    }

    private fun getDrawable(): GradientDrawable {
        val gradientDrawable = (
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.chip_background,
                null
            ) as GradientDrawable
            )

        val borderRadiusAttr = when (size) {
            SEMI -> R.attr.sizeSmall
            SEMIX -> R.attr.chipSemiXBorderRadius
            MEDIUM -> R.attr.sizeStandard
            else -> R.attr.sizeSmall
        }

        gradientDrawable.cornerRadius = getDimenFromTheme(context, borderRadiusAttr)

        return gradientDrawable
    }

    private fun setContentLabel(text: String) {
        labelTextView.text = text
    }

    companion object {
        const val SEMI = 0
        const val SEMIX = 1
        const val MEDIUM = 2

        const val NEUTRAL = 0
        const val PRIMARY = 1
        const val SECONDARY = 2
        const val CUSTOM = 3

        const val ICON_TYPE = 0
        const val AVATAR_TYPE = 1
        const val NONE_TYPE = 2

        const val RESOURCE_NOT_DEFINED = 0

        private const val BORDER_WIDTH = 2
    }
}
