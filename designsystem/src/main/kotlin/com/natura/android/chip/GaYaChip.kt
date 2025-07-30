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
        init(context, null)
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

    private var label: String = ""
    private var size: Int = SEMI
    private var isSelected: Boolean = false
    private var isComponentEnabled: Boolean = true
    private var color: Int = PRIMARY
    private var helperRightType: Int = NONE_TYPE
    private var helperLeftType: Int = NONE_TYPE
    private var helperLeft: Int = RESOURCE_NOT_DEFINED
    private var helperRight: Int = RESOURCE_NOT_DEFINED
    private var hasAction: Boolean = false

    private fun init(context: Context, attrs: AttributeSet?) {
        try {
            View.inflate(context, R.layout.gayachip, this)
        } catch (e: Exception) {
            throw LayoutInflateException()
        }

        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.GaYaChip)
            getAttributes()
            typedArray.recycle()
        }

        configureEnabled()

        mainContainer.isClickable = true
        mainContainer.isFocusable = true

        configureHelpers()
        configureAppearance(getDrawable())
        configureAction()

        mainContainer.setOnClickListener {
            if (!hasAction) {
                isSelected = !isSelected
                configureAppearance(getDrawable())
            }
        }

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
        configureAppearance(getDrawable())
    }

    fun setColor(color: Int) {
        this.color = color
        configureAppearance(getDrawable())
    }

    fun setLabel(label: String) {
        this.label = label
        setContentLabel(label)
        configureAppearance(getDrawable())
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

    fun setHasAction(hasAction: Boolean) {
        this.hasAction = hasAction
        configureAction()
    }

    private fun getAttributes() {
        typedArray.apply {
            setLabel(getString(R.styleable.GaYaChip_gchp_label) ?: "")
            setSize(getInt(R.styleable.GaYaChip_gchp_size, SEMI))
            setColor(getInt(R.styleable.GaYaChip_gchp_color, PRIMARY))
            setSelected(getBoolean(R.styleable.GaYaChip_gchp_selected, false))
            setHelperLeftType(getInt(R.styleable.GaYaChip_gchp_helper_left_type, NONE_TYPE))
            setHelperRightType(getInt(R.styleable.GaYaChip_gchp_helper_right_type, NONE_TYPE))
            setHelperLeft(getResourceId(R.styleable.GaYaChip_gchp_helper_left, RESOURCE_NOT_DEFINED))
            setHelperRight(getResourceId(R.styleable.GaYaChip_gchp_helper_right, RESOURCE_NOT_DEFINED))
            setHasAction(getBoolean(R.styleable.GaYaChip_gchp_has_action, false))
            isComponentEnabled = getBoolean(R.styleable.GaYaChip_android_enabled, true)
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

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {
        val backgroundColorAttr: Int
        val borderColorAttr: Int
        val labelColor: Int
        val iconColor: Int

        if (!isEnabled) {
            backgroundColorAttr = R.attr.colorSurfaceDisabled
            borderColorAttr = R.attr.colorSurfaceDisabled
            labelColor = getColorTokenFromTheme(context, R.attr.colorOnSurfaceDisabled)
        } else if (!isSelected) {
            backgroundColorAttr = R.attr.colorTranparent
            borderColorAttr = when (color) {
                PRIMARY -> R.attr.colorPrimary
                ONPRIMARY -> R.attr.colorOnPrimary
                SECONDARY -> R.attr.colorSecondary
                ONSECONDARY -> R.attr.colorOnSecondary
                NEUTRAL -> R.attr.colorSurfaceDark
                else -> R.attr.colorSurfaceFixedLight
            }
            labelColor = when (color) {
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis)
                ONPRIMARY -> getColorTokenFromTheme(context, R.attr.colorOnPrimary)
                SECONDARY -> getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis)
                ONSECONDARY -> getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis)
                NEUTRAL -> getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis)
                else -> getColorTokenFromTheme(context, R.attr.colorContentHighlightFixedLight)
            }
        } else {
            backgroundColorAttr = when (color) {
                PRIMARY -> R.attr.colorPrimary
                ONPRIMARY -> R.attr.colorPrimaryDarkest
                SECONDARY -> R.attr.colorSecondary
                ONSECONDARY -> R.attr.colorSecondaryDarkest
                NEUTRAL -> R.attr.colorSurfaceDark
                else -> R.attr.colorSurfaceFixedLight
            }
            borderColorAttr = R.attr.colorTranparent
            labelColor = when (color) {
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorOnPrimary)
                ONPRIMARY -> getColorTokenFromTheme(context, R.attr.colorOnPrimaryDarkest)
                SECONDARY -> getColorTokenFromTheme(context, R.attr.colorOnSecondary)
                ONSECONDARY -> getColorTokenFromTheme(context, R.attr.colorOnSecondaryDarkest)
                NEUTRAL -> getColorTokenFromTheme(context, R.attr.colorOnSurfaceDark)
                else -> getColorTokenFromTheme(context, R.attr.colorOnSurfaceFixedLight)
            }
        }
        iconColor = labelColor

        labelTextView.setTextColor(labelColor)
        iconLeft.setColorFilter(iconColor)
        iconRight.setColorFilter(iconColor)

        backgroundDrawable.mutate()
        backgroundDrawable.setStroke(BORDER_WIDTH, getColorTokenFromTheme(context, borderColorAttr))
        backgroundDrawable.setColor(getColorTokenFromTheme(context, backgroundColorAttr))
        backgroundView.background = backgroundDrawable

        requestLayout()
    }

    private fun configureHelpers() {
        containerAvatarLeft.visibility = View.GONE
        avatarLeft.visibility = View.GONE
        iconLeft.visibility = View.GONE
        containerAvatarRight.visibility = View.GONE
        avatarRight.visibility = View.GONE
        iconRight.visibility = View.GONE

        if (helperLeftType == AVATAR_TYPE && helperRightType == AVATAR_TYPE) {
            throw IllegalArgumentException("⚠️ ⚠️ GaYaIssue: Cannot have avatars on both sides")
        }

        if (helperLeftType == AVATAR_TYPE && helperLeft != RESOURCE_NOT_DEFINED) {
            setHelperVisibility(helperLeft, containerAvatarLeft, avatarLeft)
        } else if (helperLeftType == ICON_TYPE && helperLeft != RESOURCE_NOT_DEFINED) {
            setHelperVisibility(helperLeft, null, iconLeft)
        }

        if (helperRightType == AVATAR_TYPE && helperRight != RESOURCE_NOT_DEFINED) {
            setHelperVisibility(helperRight, containerAvatarRight, avatarRight)
        } else if (helperRightType == ICON_TYPE && helperRight != RESOURCE_NOT_DEFINED) {
            setHelperVisibility(helperRight, null, iconRight)
        }
    }

    private fun configureAction() {
        mainContainer.isClickable = hasAction
        mainContainer.isFocusable = hasAction
    }

    private fun setHelperVisibility(helper: Int, view: CardView?, imageView: ImageView) {
        imageView.setImageResource(helper)
        view?.visibility = View.VISIBLE
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

        const val PRIMARY = 0
        const val ONPRIMARY = 1
        const val SECONDARY = 2
        const val ONSECONDARY = 3
        const val NEUTRAL = 4
        const val INVERSE = 5

        const val NONE_TYPE = 0
        const val ICON_TYPE = 1
        const val AVATAR_TYPE = 2

        const val RESOURCE_NOT_DEFINED = 0

        private const val BORDER_WIDTH = 2
    }
}
