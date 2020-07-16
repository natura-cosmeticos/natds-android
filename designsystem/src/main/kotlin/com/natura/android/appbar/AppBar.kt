package com.natura.android.appbar

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.natura.android.R
import com.natura.android.ext.setVisibilityFromBoolean
import com.natura.android.icon.BadgeDrawable

class AppBar(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {

    private lateinit var badgeDrawable: BadgeDrawable
    private var showLogo: Boolean
    private val logo: ImageView

    init {
        logo = createLogo(context, attrs)

        val typedValue = context.obtainStyledAttributes(attrs, R.styleable.AppBar)
        showLogo = typedValue.getBoolean(R.styleable.AppBar_showLogo, false)
        setLogoVisibility()

        addView(logo)
    }

    private fun setLogoVisibility() {
        logo.setVisibilityFromBoolean(showLogo)

        if (showLogo) {
            title = ""
        }
    }

    fun showLogo() {
        showLogo = true
        setLogoVisibility()
    }

    fun hideLogo() {
        showLogo = false
        setLogoVisibility()
    }

    fun addMenuIconBadge(menuIcon: Drawable, initBadgeValue: Int) {
        badgeDrawable = BadgeDrawable(context, initBadgeValue, menuIcon)
    }

    fun updateBadgeValue(value: Int) {
        if (this::badgeDrawable.isInitialized) {
            badgeDrawable.updateBadgeDrawable(value)
        }
    }

    private fun createLogo(context: Context, attrs: AttributeSet): ImageView {
        val imageView = ImageView(context)
        imageView.setImageResource(getLogoResId(context, attrs))
        val logoWidth = getLogoWidthFromTheme(context)
        imageView.layoutParams =
            LayoutParams(logoWidth, ViewGroup.LayoutParams.WRAP_CONTENT, getLogoAlign(context))
        imageView.visibility = View.GONE
        return imageView
    }

    private fun getLogoAlign(context: Context): Int {
        return if (getWindowWidthInPx(context) < MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO) {
            Gravity.START
        } else {
            Gravity.CENTER
        }
    }

    private fun getLogoWidthFromTheme(context: Context): Int {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(R.attr.sizeHugeX, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        }

        return ViewGroup.LayoutParams.WRAP_CONTENT
    }

    private fun getLogoResId(context: Context, attrs: AttributeSet): Int {
        val typedValue = context.theme
            .obtainStyledAttributes(attrs, intArrayOf(R.attr.logoHorizontal), 0, 0)
        return typedValue.getResourceId(0, 0)
    }

    private fun getWindowWidthInPx(context: Context): Int {
        return try {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val metrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(metrics)

            metrics.widthPixels
        } catch (ex: Exception) {
            MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO
        }
    }

    companion object{
        private const val MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO = 361
    }
}
