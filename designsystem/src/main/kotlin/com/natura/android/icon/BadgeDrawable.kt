package com.natura.android.icon

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.TypedValue
import com.natura.android.R

const val DEFAULT_MAX_VALUE = "99+"

class BadgeDrawable(
    private val context: Context,
    private val count: Int,
    private val parent: Drawable
) : Drawable() {

    private var mBadgePaint = Paint()
    private var mTextPaint = Paint()
    private val mTxtRect = Rect()
    private var mCountText = ""
    private var mCount = count

    init {
        initializeBadgeTheme()
        setBadge()
    }

    private fun setBadge(){
        val icon = parent as LayerDrawable

        this.updateBadgeDrawable(count)
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_badge_placeholder, this)
    }

    override fun draw(canvas: Canvas) {
        if (mCount > 0) {
            drawBadgeWithText(canvas)
        } else
            defineTextBounds(mCountText)
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(cf: ColorFilter?) {}

    override fun getOpacity() = PixelFormat.UNKNOWN

    internal fun updateBadgeDrawable(count: Int) {
        mCountText = count.toString()
        mCount = count
        invalidateSelf()
    }

    private fun initializeBadgeTheme() {
        setBadgeBackgroundStyle()
        setBadgeFontStyle()
    }

    private fun setBadgeBackgroundStyle() {
        mBadgePaint.apply {
            color = getColorFromTheme(context, R.attr.colorError)
            style = Paint.Style.FILL
        }
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(context, R.attr.colorOnError)
            typeface = Typeface.DEFAULT
            textSize = 20f
            textAlign = Paint.Align.CENTER
        }
    }

    private fun drawBadgeWithText(
        canvas: Canvas
    ) {
        defineTextBounds(mCountText)
        definePositionToDrawBadge(canvas)
    }

    private fun defineTextBounds(text: String) {
        mTextPaint.getTextBounds(text, 0, mCountText.length, mTxtRect)
    }

    private fun definePositionToDrawBadge(
        canvas: Canvas
    ) {
        val bounds = bounds
        val width = bounds.right - bounds.left.toFloat()
        val height = bounds.bottom - bounds.top.toFloat()

        val rect = RectF(width / 2, 0f, if (mCount > 9) (width * 1.2f) else width, height / 2)

        canvas.drawRoundRect(rect, 16f, 16f, mBadgePaint)

        canvas.drawText(
            if (mCount > 99) DEFAULT_MAX_VALUE else mCountText,
            rect.centerX(),
            rect.centerY() + 8f,
            mTextPaint
        )
    }

    private fun getColorFromTheme(context: Context, attrColorId: Int): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attrColorId, value, true)
        return value.data
    }

}
