package com.natura.android.appbar

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import com.natura.android.R
import kotlin.math.max

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

        val bounds = bounds
        val width = bounds.width()
        val height = bounds.height()

        val radius = max(width, height) / 4
        val centerX = width - radius + 4
        val centerY = radius - 4

        val textHeight = mTxtRect.bottom - mTxtRect.top.toFloat()
        val textY = centerY + textHeight / 2f

        if (mWillDraw) {
            drawBadgeWithText(canvas, centerX.toFloat(), centerY.toFloat(), radius.toFloat(), textY)
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
            textSize = 16f
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }
    }

    private fun drawBadgeWithText(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        radius: Float,
        textY: Float
    ) {
        defineTextBounds(mCountText)
        definePositionToDrawBadge(canvas, centerX, centerY, radius)
        drawBadgeText(canvas, centerX, textY)
    }

    private fun defineTextBounds(text: String) {
        mTextPaint.getTextBounds(text, 0, mCountText.length, mTxtRect)
    }

    private fun drawBadgeText(
        canvas: Canvas,
        centerX: Float,
        textY: Float
    ) {

        canvas.drawText(
            if (mCount > 99) placeholderText else mCountText,
            centerX,
            textY,
            mTextPaint
        )
    }

    private fun definePositionToDrawBadge(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        radius: Float
    ) {
        canvas.drawCircle(
            centerX,
            centerY,
            radius + 5f,
            mBadgePaint
        )
    }
}
