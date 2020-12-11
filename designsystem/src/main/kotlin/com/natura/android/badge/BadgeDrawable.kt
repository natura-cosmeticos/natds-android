package com.natura.android.badge

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.TypedValue
import com.natura.android.R

const val DEFAULT_MAX_VALUE = "99+"

class BadgeDrawable(
    private val context: Context,
    private var count: Int,
    private var parent: Drawable
) : Drawable() {

    private var mTextPaint = Paint()
    private val mTxtRect = Rect()

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
        if (this.count > 0) {
            drawBadgeWithText(canvas)
        } else
            defineTextBounds(count.toString())
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(cf: ColorFilter?) {}

    override fun getOpacity() = PixelFormat.UNKNOWN

    fun updateBadgeDrawable(count: Int) {
        this.count = count
        invalidateSelf()
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(context, R.attr.colorOnError)
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
        mTextPaint.getTextBounds(text, 0, count.toString().length, mTxtRect)
    }

    private fun definePositionToDrawBadge(canvas: Canvas) {
        val bounds = bounds
        val badgeWith =  mTxtRect.width() + getDimenFromTheme(R.attr.spacingTiny).toInt()

        context.resources.getDrawable(R.drawable.badge_rounded_rectangle, context.theme).apply {
            setBounds(
                bounds.right - badgeWith,
                bounds.top,
                bounds.right,
                 mTxtRect.height() + getDimenFromTheme(R.attr.spacingMicro).toInt())
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
            if (this@BadgeDrawable.count > 99) DEFAULT_MAX_VALUE else count.toString(),
            x,
            y,
            mTextPaint
        )
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
}
