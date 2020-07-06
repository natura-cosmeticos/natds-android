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
    private var mWillDraw = false

    init {

        mBadgePaint.apply {
            color = getColorFromTheme(context, R.attr.colorError)
            isAntiAlias = true
            style = Paint.Style.FILL
        }

        mTextPaint.apply {
            color = getColorFromTheme(context, R.attr.colorOnError)
            typeface = Typeface.DEFAULT
            textSize = 20.0f
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }
    }

    override fun draw(canvas: Canvas) {

        val bounds = bounds
        val width = bounds.right - bounds.left.toFloat()
        val height = bounds.bottom - bounds.top.toFloat()

        val radius = max(width, height) / 4
        val centerX = width - radius + 4
        val centerY = radius - 4

        val textHeight = mTxtRect.bottom - mTxtRect.top.toFloat()
        val textY = centerY + textHeight / 2f

        if (mWillDraw) {
            drawBadgeWithText(canvas, centerX, centerY, radius, textY)
        } else
            defineInitialBounds()
    }

    private fun drawBadgeWithText(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        radius: Float,
        textY: Float
    ) {
        definePlaceToDrawBadge(canvas, centerX, centerY, radius)

        mTextPaint.getTextBounds(mCountText, 0, mCountText.length, mTxtRect)

        drawBadgeText(canvas, centerX, textY)
    }

    private fun defineInitialBounds() {
        mTextPaint.getTextBounds("0", 0, mCountText.length, mTxtRect)
    }

    private fun drawBadgeText(
        canvas: Canvas,
        centerX: Float,
        textY: Float
    ) {
        if (mCountText.length > 2) {
            canvas.drawText(placeholderText, centerX, textY, mTextPaint)
        } else {
            canvas.drawText(mCountText, centerX, textY, mTextPaint)
        }
    }

    private fun definePlaceToDrawBadge(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        radius: Float
    ) {
        if (mCountText.length <= 2) {
            mBadgePaint.let {
                canvas.drawCircle(
                    centerX,
                    centerY,
                    (radius + 5.5).toFloat(),
                    it
                )
            }
        } else {
            mBadgePaint.let {
                canvas.drawCircle(
                    centerX,
                    centerY,
                    ((radius + 6.5).toFloat()),
                    it
                )
            }
        }
    }

    fun updateBadgeDrawable(count: Int){
        mCountText = count.toString()
        mWillDraw = count > 0
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
