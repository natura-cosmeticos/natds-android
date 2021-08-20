package com.natura.android.badge

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.TypedValue
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
    private var limit: Int?
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
            STANDARD -> createStandardVariant(canvas)
            PULSE -> createPulseVariant(canvas)
            DOT -> createDotVariant(canvas)
        }
    }

    private fun createStandardVariant(canvas: Canvas) {
        if (this.count > 0) {
            drawBadgeWithText(canvas)
        } else {
            defineTextBounds(count.toString())
        }
    }

    private fun createDotVariant(canvas: Canvas) {
        initializePaint()

        canvas.drawCircle(
            bounds.right - (getDimenFromTheme(R.attr.sizeTiny) / 2),
            getDimenFromTheme(R.attr.sizeTiny) / 2,
            getDimenFromTheme(R.attr.sizeTiny) / 2,
            circlePaint
        )
    }

    private fun createPulseVariant(canvas: Canvas) {
        initializePaint()

        canvas.drawCircle(
            bounds.right - (getDimenFromTheme(R.attr.sizeTiny) / 2),
            getDimenFromTheme(R.attr.sizeTiny) / 2,
            getDimenFromTheme(R.attr.sizeTiny) / 2,
            circlePaint
        )
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(cf: ColorFilter?) {}

    override fun getOpacity() = PixelFormat.UNKNOWN

    fun updateBadgeDrawable(count: Int) {
        this.count = count
        invalidateSelf()
    }

    private fun initializePaint() {
        circlePaint.color = getColorFromTheme(context, getBackgroundColorByAttr())
        circlePaint.isAntiAlias = true
        circlePaint.style = Paint.Style.FILL
        circlePaint.strokeWidth = 0f
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(context, getFontColorByAttr())
            typeface = Typeface.DEFAULT
            textSize = context.resources.getDimension(R.dimen.badge_text_size)
            textAlign = Paint.Align.CENTER
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
        val badgeWith = mTxtRect.width() + getDimenFromTheme(R.attr.spacingTiny).toInt()

        context.resources.getDrawable(R.drawable.badge_rounded_rectangle, context.theme).apply {
            setTint(getColorFromTheme(context, getBackgroundColorByAttr()))
            setBounds(
                bounds.right - badgeWith,
                bounds.top,
                bounds.right,
                mTxtRect.height() + getDimenFromTheme(R.attr.spacingTiny).toInt()
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
            PRIMARY -> R.attr.colorPrimary
            SECONDARY -> R.attr.colorSecondary
            SUCCESS -> R.attr.colorSuccess
            else -> R.attr.colorAlert
        }
    }

    private fun getFontColorByAttr(): Int {
        return when (color) {
            PRIMARY -> R.attr.colorOnPrimary
            SECONDARY -> R.attr.colorOnSecondary
            SUCCESS -> R.attr.colorOnSuccess
            else -> R.attr.colorOnAlert
        }
    }

    private fun getColorFromTheme(context: Context, attrColorId: Int): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attrColorId, value, true)
        return value.data
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
