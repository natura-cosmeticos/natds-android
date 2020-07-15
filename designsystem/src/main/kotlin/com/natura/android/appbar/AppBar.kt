package com.natura.android.appbar

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.natura.android.R
import com.natura.android.icon.BadgeDrawable

class AppBar(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {
    private lateinit var badgeDrawable: BadgeDrawable
    private val logo: ImageView

    init {
        logo = createLogo(context, attrs)
        addView(logo)
        title = ""
    }

    fun showLogo() {
        logo.visibility = View.VISIBLE
        title = ""
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
            LayoutParams(logoWidth, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER)
        imageView.visibility = View.GONE
        return imageView
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
}
