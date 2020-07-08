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
        initializeBadgeElement()
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

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(cf: ColorFilter?) {}

    override fun getOpacity() = PixelFormat.UNKNOWN

    private fun initializeBadgeElement() {
        setBadgeBackgroundStyle()
        setBadgeFontStyle()
    }

    private fun setBadgeFontStyle() {
        mTextPaint.apply {
            color = getColorFromTheme(context, R.attr.colorOnError)
            typeface = Typeface.DEFAULT
            textSize = 20.0f
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }
    }

    private fun setBadgeBackgroundStyle() {
        mBadgePaint.apply {
            color = getColorFromTheme(context, R.attr.colorError)
            isAntiAlias = true
            style = Paint.Style.FILL
        }
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
        if (mCountText.length >= 2) {
            canvas.drawText(placeholderText, centerX + 4f, textY + 2f, mTextPaint)
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

        val bounds = bounds
        val width = bounds.right - bounds.left.toFloat()

        //começa a imprimir a badge do meio do icone em diante

        var mRect: RectF

        if (mCountText.length >= 2) {
            mRect = RectF(width / 2, 0f, width + 16f, 30f)
            canvas.drawRoundRect(mRect, 16f, 16f, mBadgePaint)
        } else {
            mRect = RectF(width / 2, 0f, width + 12f, 30f)
            //canvas.drawRoundRect(mRect, 16f, 16f, mBadgePaint)


            canvas.drawCircle(
                    centerX,
                    centerY,
                    (radius + 5.5).toFloat(), mBadgePaint
                )


        }



//        if (mCountText.length <= 2) {
//            mBadgePaint.let {
//                canvas.drawCircle(
//                    centerX,
//                    centerY,
//                    (radius + 5.5).toFloat(),
//                    it
//                )
//            }
//        } else {
//            mBadgePaint.let {
//                canvas.drawCircle(
//                    centerX,
//                    centerY,
//                    ((radius + 6.5).toFloat()),
//                    it
//                )
//            }
//        }
    }

    fun updateBadgeDrawable(count: Int){
        mCountText = count.toString()
        mWillDraw = count > 0
        invalidateSelf()
    }
}
