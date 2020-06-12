package com.natura.android.appbar

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import com.natura.android.R
import kotlin.math.sqrt

class AppBar(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {
    var color: Int

    init {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.AppBar, 0, 0)
            .apply {
                try {
                    color = this.getInt(R.styleable.AppBar_appBarType, 0)
                } finally {
                    recycle()
                }
            }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setStatusBarStyle()

        this.setBackgroundColor(getThemeColor(getMainColorFromAttrs()))
        this.setTitleTextColor(getThemeColor(getMainOnColorFromAttrs()))

        if(isOnColorTooLight(getThemeColor(getMainOnColorFromAttrs()))) {
            setStatusBarIconsLighter()
        } else {
            setStatusBarIconsDarker()
        }

    }

    private fun isOnColorTooLight(color: Int): Boolean {
        val rgb = intArrayOf(Color.red(color), Color.green(color), Color.blue(color))
        val brightness = sqrt(rgb[0] * rgb[0] * .241 + (rgb[1] * rgb[1] * .691) + rgb[2] * rgb[2] * .068).toInt()
        return brightness >= 200
    }

    private fun setStatusBarStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            val context = context as Activity
            val window = context.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = getThemeColor(getMainColorFromAttrs())

        }
    }

    private fun getMainColorFromAttrs(): Int {
        return when(color) {
            1 -> R.attr.colorPrimary
            2 -> R.attr.colorSecondary
            3 -> android.R.color.transparent
            else -> R.attr.colorSurface
        }
    }

    private fun getMainOnColorFromAttrs(): Int {
        return when(color) {
            1 -> R.attr.colorOnPrimary
            2 -> R.attr.colorOnSecondary
            3 -> R.attr.colorOnSurface
            else -> R.attr.colorOnSurface
        }
    }

    private fun getThemeColor(colorAttr: Int): Int {
        val outValue = TypedValue()
        context.theme.resolveAttribute(colorAttr, outValue, true)
        return outValue.data
    }


    private fun setStatusBarIconsDarker() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val context = context as Activity
            val window = context.window
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun setStatusBarIconsLighter() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val context = context as Activity
            val window = context.window
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}
