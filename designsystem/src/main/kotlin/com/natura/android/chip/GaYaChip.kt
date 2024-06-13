package com.natura.android.chip

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.natura.android.R
import com.natura.android.exceptions.LayoutInflateException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme

class GaYaChip : ConstraintLayout {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private val mainContainer by lazy { findViewById<ConstraintLayout>(R.id.chip_main_container) }
    private val labelTextView by lazy { findViewById<TextView>(R.id.chp_label) }
    private val backgroundView by lazy { findViewById<LinearLayout>(R.id.chp_background) }

    private val iconLeft by lazy { findViewById<ImageView>(R.id.chp_icon_left) }
    private val avatarLeft by lazy { findViewById<ImageView>(R.id.chp_avatar_left) }
    private val containerAvatarLeft by lazy { findViewById<CardView>(R.id.chp_avatar_container_left) }

    private val iconRight by lazy { findViewById<ImageView>(R.id.chp_icon_right) }
    private val avatarRight by lazy { findViewById<ImageView>(R.id.chp_avatar_right) }
    private val containerAvatarRight by lazy { findViewById<CardView>(R.id.chp_avatar_container_right) }

    private lateinit var typedArray: TypedArray

    var label: String = ""
        set(value) {
            field = value
            setContentLabel(value)
        }

    var size: Int = SEMI
        set(value) {
            field = value
            configureSize(getDrawable())
        }

    private var hasAction: Boolean = false
    private var isComponentSelected: Boolean = false
    private var isComponentEnabled: Boolean = true

    private var color: Int = NEUTRAL

    private var helperRightType: Int = NONE_TYPE
    private var helperLeftType: Int = NONE_TYPE
    private var helperLeft: Int = RESOURCE_NOT_DEFINED
    private var helperRight: Int = RESOURCE_NOT_DEFINED

    private var labelResourceColor: Int = RESOURCE_NOT_DEFINED
    private var borderResourceColor: Int = RESOURCE_NOT_DEFINED
    private var backgroundResourceColor: Int = RESOURCE_NOT_DEFINED

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
        configureEnabled()
        configureAction()
        configureHelpers()
        configureAppearance(getDrawable())

        typedArray.recycle()
        requestLayout()
    }

    override fun setEnabled(enabled: Boolean) {
        labelTextView.isEnabled = enabled
        backgroundView.isEnabled = enabled
        iconLeft.isEnabled = enabled
        avatarLeft.isEnabled = enabled
        iconRight.isEnabled = enabled
        avatarRight.isEnabled = enabled

        mainContainer.isClickable = enabled
        super.setEnabled(enabled)
    }

    fun setSize(size: Int) {
        this.size = size
        configureSize(getDrawable())
    }

    fun setColor(color: Int) {
        this.color = color
        configureAppearance(getDrawable())
    }

    fun setHasAction(hasAction: Boolean) {
        this.hasAction = hasAction
        configureAction()
    }

    fun setIsComponentSelected(isComponentSelected: Boolean) {
        this.isComponentSelected = isComponentSelected
        configureAppearance(getDrawable())
    }

    fun setLabel(label: String) {
        this.label = label
        setContentLabel(label)
    }

    fun setHelperLeftType(helperLeftType: Int) {
        this.helperLeftType = helperLeftType
        configureHelpers()
    }

    fun setHelperRightType(helperRightType: Int) {
        this.helperRightType = helperRightType
        configureHelpers()
    }

    fun setHelperLeft(helperLeft: Int) {
        this.helperLeft = helperLeft
        configureHelpers()
    }

    fun setHelperRight(helperRight: Int) {
        this.helperRight = helperRight
        configureHelpers()
    }

    fun setCustomLabelColor(color: Int) {
        this.labelResourceColor = color
        configureAppearance(getDrawable())
    }

    fun setCustomBorderColor(color: Int) {
        this.borderResourceColor = color
        configureAppearance(getDrawable())
    }

    fun setCustomBackgroundColor(color: Int) {
        this.backgroundResourceColor = color
        configureAppearance(getDrawable())
    }

    private fun getAttributes() {
        typedArray.apply {
            label = getString(R.styleable.Chip_chp_label) ?: ""
            size = getInt(R.styleable.Chip_chp_size, SEMI)
            color = getInt(R.styleable.Chip_chp_color, NEUTRAL)
            labelResourceColor = getColor(R.styleable.Chip_chp_custom_label_color, getColorTokenFromTheme(context, R.attr.colorHighEmphasis))
            borderResourceColor = getColor(R.styleable.Chip_chp_custom_border_color, getColorTokenFromTheme(context, R.attr.colorLowEmphasis))
            backgroundResourceColor = getColor(R.styleable.Chip_chp_custom_background_color, getColorTokenFromTheme(context, R.attr.colorHighLightOpacityFull))
            hasAction = getBoolean(R.styleable.Chip_chp_action, false)
            isComponentSelected = getBoolean(R.styleable.Chip_chp_selected, false)
            helperLeftType = getInt(R.styleable.Chip_chp_helper_left_type, NONE_TYPE)
            helperRightType = getInt(R.styleable.Chip_chp_helper_right_type, NONE_TYPE)
            helperLeft = getResourceId(R.styleable.Chip_chp_helper_left, RESOURCE_NOT_DEFINED)
            helperRight = getResourceId(R.styleable.Chip_chp_helper_right, RESOURCE_NOT_DEFINED)
            isComponentEnabled = getBoolean(R.styleable.Chip_android_enabled, true)
        }
    }

    private fun configureEnabled() {
        isEnabled = isComponentEnabled
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
        mainContainer.isClickable = hasAction
        mainContainer.isFocusable = hasAction
    }

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {
        val backgroundColorAttr = when {
            !isEnabled -> R.attr.colorTranparent
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

        val labelColor = when {
            !isEnabled -> getColorTokenFromTheme(context, R.attr.colorLowEmphasis)
            !isComponentSelected -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
            else -> {
                when (color) {
                    NEUTRAL -> getColorTokenFromTheme(context, R.attr.colorOnPrimary)
                    PRIMARY -> getColorTokenFromTheme(context, R.attr.colorOnPrimary)
                    SECONDARY -> getColorTokenFromTheme(context, R.attr.colorOnSecondary)
                    CUSTOM -> labelResourceColor
                    else -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
                }
            }
        }

        labelTextView.setTextColor(labelColor)

        backgroundDrawable.mutate()
        backgroundDrawable.setStroke(BORDER_WIDTH, if (color == CUSTOM) borderResourceColor else getColorTokenFromTheme(context, borderColorAttr))
        backgroundDrawable.setColor(if (color == CUSTOM && isComponentSelected) backgroundResourceColor else getColorTokenFromTheme(context, backgroundColorAttr))
        backgroundView.background = backgroundDrawable

        requestLayout()
    }

    private fun configureHelpers() {
        when {
            helperLeftType == AVATAR_TYPE && helperLeft != RESOURCE_NOT_DEFINED -> setHelperVisibility(helperLeft, containerAvatarLeft, avatarLeft)
            helperRightType == AVATAR_TYPE && helperRight != RESOURCE_NOT_DEFINED -> setHelperVisibility(helperRight, containerAvatarRight, avatarRight)
            helperLeftType == ICON_TYPE && helperLeft != RESOURCE_NOT_DEFINED -> setHelperVisibility(helperLeft, null, iconLeft)
            helperRightType == ICON_TYPE && helperRight != RESOURCE_NOT_DEFINED -> setHelperVisibility(helperRight, null, iconRight)
        }
    }

    private fun setHelperVisibility(helper: Int, view: CardView?, imageView: ImageView) {
        imageView.setImageResource(helper)
        view?.let {
            it.visibility = View.VISIBLE
            return
        }

        imageView.visibility = View.VISIBLE
    }

    private fun getDrawable(): GradientDrawable {
        val backgroundDrawable = ResourcesCompat.getDrawable(context.resources, R.drawable.chip_background, null) as GradientDrawable
        val borderRadiusAttr = when (size) {
            SEMI -> R.attr.sizeSmall
            SEMIX -> R.attr.chipSemiXBorderRadius
            MEDIUM -> R.attr.sizeStandard
            else -> R.attr.sizeSmall
        }

        backgroundDrawable.cornerRadius = getDimenFromTheme(context, borderRadiusAttr)
        return backgroundDrawable
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

        const val NONE_TYPE = 0
        const val ICON_TYPE = 1
        const val AVATAR_TYPE = 2

        const val RESOURCE_NOT_DEFINED = 0

        private const val BORDER_WIDTH = 2
    }
}
