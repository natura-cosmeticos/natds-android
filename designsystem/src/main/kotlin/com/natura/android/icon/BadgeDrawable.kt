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
            textSize = context.resources.getDimension(R.dimen.ds_text_footer_size)
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
        val badgeCorner =  context.resources.getDimension(R.dimen.ds_default_badge_corner_radius)

        val badgeWith = when{
            count > 99 -> context.resources.getDimension(R.dimen.big_badge_width)
            count > 9 -> context.resources.getDimension(R.dimen.badge_width)
            else -> context.resources.getDimension(R.dimen.small_badge_width)
        }

        val rect = RectF(bounds.exactCenterX(), bounds.top.toFloat(), badgeWith, bounds.exactCenterY())

        canvas.drawRoundRect(rect, badgeCorner, badgeCorner, mBadgePaint)

        canvas.drawText(
            if (mCount > 99) DEFAULT_MAX_VALUE else mCountText,
            rect.centerX(),
            rect.centerY() + context.resources.getDimension(R.dimen.ds_button_primary_radius),
            mTextPaint
        )
    }

    private fun getColorFromTheme(context: Context, attrColorId: Int): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attrColorId, value, true)
        return value.data
    }

}
