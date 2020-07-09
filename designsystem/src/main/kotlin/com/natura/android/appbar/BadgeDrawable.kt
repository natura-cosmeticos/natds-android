package com.natura.android.appbar

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import com.natura.android.R

class BadgeDrawable(
    private val context: Context,
    private val placeholderText: String
) : Drawable() {

    private var mBadgePaint = Paint()
    private var mTextPaint = Paint()
    private val mTxtRect = Rect()
    private var mCountText = ""
    private var mCount = 0
    private var mWillDraw = false

    init {
        initializeBadgeElement()
    }

    override fun draw(canvas: Canvas) {
        if (mWillDraw) {
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
        mWillDraw = count > 0
        invalidateSelf()
    }

    private fun initializeBadgeElement() {
        setBadgeBackgroundStyle()
        setBadgeFontStyle()
    }

    private fun setBadgeBackgroundStyle() {
        mBadgePaint.apply {
            color = getColorFromTheme(context, R.attr.colorError)
            isAntiAlias = true
            style = Paint.Style.FILL
        }
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(context, R.attr.colorOnError)
            typeface = Typeface.DEFAULT
            textSize = 20f
            isAntiAlias = true
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
            if (mCount > 99) placeholderText else mCountText,
            rect.centerX(),
            rect.centerY() + 8f,
            mTextPaint
        )
    }
}
