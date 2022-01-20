package com.natura.android.badge

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat

import com.natura.android.R

const val NINE_MAX_VALUE = 9
const val NINETY_NINE_MAX_VALUE = 99

const val NINE_MAX_VALUE_LABEL = "9+"
const val NINETY_NINE_MAX_VALUE_LABEL = "99+"

class BadgeDrawable(
    private val context: Context,
    private var count: Int,
    private var parent: Drawable,
    private var variant: Int?,
    private var color: Int?,
    private var limit: Int?,
    private var isFontWeight: Boolean?
) : Drawable() {

    private var mTextPaint = Paint()
    private val mTxtRect = Rect()
    private var circlePaint = Paint()

    init {
        setBadgeFontStyle()
        setBadge()
    }

    private fun setBadge() {
        val icon = parent as LayerDrawable
        icon.mutate()
        icon.setDrawableByLayerId(R.id.badge_placeholder, this)
    }

    override fun draw(canvas: Canvas) {
        when (variant) {
            STANDARD -> createStandardCircle(canvas)
            DOT -> createDotCircle(canvas)
        }
    }

    private fun createStandardCircle(canvas: Canvas) {
        if (this.count > 0) {
            drawBadgeWithText(canvas)
        } else {
            defineTextBounds(count.toString())
        }
    }

    private fun createDotCircle(canvas: Canvas) {
        initializePaint()

        val bounds = bounds
        val badgeWith = getDimenFromTheme(R.attr.badgeDotHeight).toInt()

        ResourcesCompat.getDrawable(context.resources, R.drawable.badge_dot, context.theme).apply {
            setTint(getColorFromTheme(getBackgroundColorByAttr()))
            setBounds(
                bounds.right - badgeWith,
                bounds.top,
                bounds.right,
                getDimenFromTheme(R.attr.badgeDotHeight).toInt()
            )
            draw(canvas)
        }
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(cf: ColorFilter?) {}

    override fun getOpacity() = PixelFormat.UNKNOWN

    fun updateBadgeDrawable(count: Int) {
        this.count = count
        invalidateSelf()
    }

    private fun initializePaint() {
        circlePaint.color = getColorFromTheme(getBackgroundColorByAttr())
        circlePaint.isAntiAlias = true
        circlePaint.style = Paint.Style.FILL
        circlePaint.strokeWidth = 0f
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(getFontColorByAttr())
            typeface = getFontFromTheme()
            textSize = getDimenFromTheme(R.attr.badgeLabelFontSize)
            textAlign = Paint.Align.CENTER
            letterSpacing = getDimenFromTheme(R.attr.badgeLabelLetterSpacing)
            style = Paint.Style.FILL
        }
    }

    private fun drawBadgeWithText(canvas: Canvas) {
        defineTextBounds(count.toString())
        definePositionToDrawBadge(canvas)
    }

    private fun defineTextBounds(text: String) {

        if (count <= getMaxValue() || limit == UNLIMITED) {
            mTextPaint.getTextBounds(text, 0, count.toString().length, mTxtRect)
            return
        }

        mTextPaint.getTextBounds(text, 0, getMaxValueLabel().length, mTxtRect)
    }

    private fun definePositionToDrawBadge(canvas: Canvas) {
        val bounds = bounds
        val badgeWidth = mTxtRect.width() + getDimenFromTheme(R.attr.spacingTiny).toInt()

        ResourcesCompat.getDrawable(context.resources, R.drawable.badge_standard, context.theme)
            ?.apply {
                setTint(getColorFromTheme(getBackgroundColorByAttr()))
                setBounds(
                    bounds.right - badgeWidth,
                    bounds.top,
                    bounds.right,
                    getDimenFromTheme(R.attr.badgeStandardHeight).toInt()
                )
                draw(canvas)

                drawText(
                    canvas,
                    this.bounds.exactCenterX(),
                    this.bounds.centerY() + getDimenFromTheme(R.attr.sizeMicro)
                )
            }
    }

    private fun drawText(canvas: Canvas, x: Float, y: Float) {
        canvas.drawText(
            if (this@BadgeDrawable.count > getMaxValue() && limit != UNLIMITED) getMaxValueLabel() else count.toString(),
            x,
            y,
            mTextPaint
        )
    }

    private fun getMaxValueLabel(): String {
        return when (limit) {
            NINE -> NINE_MAX_VALUE_LABEL
            else -> NINETY_NINE_MAX_VALUE_LABEL
        }
    }

    private fun getMaxValue(): Int {
        return when (limit) {
            NINE -> NINE_MAX_VALUE
            else -> NINETY_NINE_MAX_VALUE
        }
    }

    private fun getBackgroundColorByAttr(): Int {
        return when (color) {
            PRIMARY -> R.attr.badgeColorPrimaryBackground
            SECONDARY -> R.attr.badgeColorSecondaryBackground
            SUCCESS -> R.attr.badgeColorSuccessBackground
            else -> R.attr.badgeColorAlertBackground
        }
    }

    private fun getFontColorByAttr(): Int {
        return when (color) {
            PRIMARY -> R.attr.badgeColorPrimaryLabel
            SECONDARY -> R.attr.badgeColorSecondaryLabel
            SUCCESS -> R.attr.badgeColorSuccessLabel
            else -> R.attr.badgeColorAlertLabel
        }
    }

    private fun getColorFromTheme(attrColorId: Int): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attrColorId, value, true)
        return value.data
    }

    private fun getFontFromTheme(): Typeface? {

        val attrFont = when (isFontWeight) {
            true -> R.attr.badgeLabelPrimaryFontWeight
            else -> R.attr.badgeLabelPrimaryFontFamily
        }

        val value = TypedValue()
        context.theme.resolveAttribute(attrFont, value, true)

        if (value.string.isEmpty()) {
            context.theme.resolveAttribute(R.attr.badgeLabelFallbackFontFamily, value, true)
            return Typeface.create(value.string.toString(), Typeface.NORMAL)
        }
        return Typeface.create(value.string.toString(), Typeface.NORMAL)
    }

    private fun getDimenFromTheme(attributeName: Int): Float {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(attributeName, typedValue, true)
        return typedValue.getDimension(context.resources.displayMetrics)
    }

    companion object {
        const val STANDARD = 0
        const val DOT = 1
        const val PULSE = 2

        const val ALERT = 0
        const val PRIMARY = 1
        const val SECONDARY = 2
        const val SUCCESS = 3

        const val NINE = 0
        const val NINETY_NINE = 1
        const val UNLIMITED = 2
    }
}
