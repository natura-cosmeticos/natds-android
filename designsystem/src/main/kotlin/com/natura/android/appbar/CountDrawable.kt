package com.natura.android.appbar

import android.R
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import kotlin.math.max


class CountDrawable(
    context: Context
) : Drawable() {

    private var mBadgePaint = Paint()
    private var mTextPaint = Paint()
    private val mTxtRect = Rect()

    private var mCount = ""
    private var mWillDraw = false

    init {
        mBadgePaint.color = ContextCompat.getColor(
            context.applicationContext,
            R.color.holo_red_dark
        )
        mBadgePaint.isAntiAlias = true
        mBadgePaint.style = Paint.Style.FILL
        mTextPaint.color = Color.WHITE
        mTextPaint.typeface = Typeface.DEFAULT
        mTextPaint.textSize = 20.0f
        mTextPaint.isAntiAlias = true
        mTextPaint.textAlign = Paint.Align.CENTER
    }

    override fun draw(canvas: Canvas) {

        val bounds = bounds
        val width = bounds.right - bounds.left.toFloat()
        val height = bounds.bottom - bounds.top.toFloat()

        // Position the badge in the top-right quadrant of the icon.
        val radius = max(width, height) / 2 / 2
        val centerX = width - radius - 1 + 5
        val centerY = radius - 5

        if (mCount.length <= 2) {
            mBadgePaint.let { canvas.drawCircle(centerX, centerY, (radius + 5.5).toFloat() , it) }
        } else {
            mBadgePaint.let { canvas.drawCircle(centerX, centerY, ((radius + 6.5).toFloat()), it) }
        }

        // Draw badge count text inside the circle.
        mTextPaint.getTextBounds(mCount, 0, mCount.length, mTxtRect)

        val textHeight = mTxtRect.bottom - mTxtRect.top.toFloat()
        val textY = centerY + textHeight / 2f

        if (mCount.length > 1) canvas.drawText(
            "10+",
            centerX,
            textY,
            mTextPaint
        ) else canvas.drawText(mCount, centerX, textY, mTextPaint)
    }

    fun setCount(count: String) {
        mCount = count

        // Only draw a badge if there are notifications.
        mWillDraw = count.isNotEmpty()
        invalidateSelf()
    }

    override fun setAlpha(alpha: Int) {
        // do nothing
    }

    override fun setColorFilter(cf: ColorFilter?) {
        // do nothing
    }

    override fun getOpacity(): Int {
        return PixelFormat.UNKNOWN
    }

}

private fun Canvas.drawCircle(centerX: Float, centerY: Float, fl: Float, unit: Unit, mBadgePaint: Paint?) {

}
