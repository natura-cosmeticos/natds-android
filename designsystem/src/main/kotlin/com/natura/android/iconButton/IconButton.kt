package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class IconButton @JvmOverloads constructor(

    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray
    private var sizeResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var iconAttribute: Int? = null
    private var sizeAttribute: Int? = null
    private var colorAttribute: Int? = null
    private var notifyAttribute: Int? = null

    private val iconButton by lazy { findViewById<ImageButton>(R.id.iconButton) }

    init {
        try {
            View.inflate(context, R.layout.icon_button, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.ds_icon_button)

        getIconButtonAttributes()
        getAttributesFromTheme()
        configureIconButton()

        iconButtonAttributesArray.recycle()
    }

    fun setIcon(icon: Int?) {
        icon?.apply {
            iconButton.setBackgroundResource(icon)
        }
    }

    fun getIcon(): Drawable {
        return iconButton.background
    }

    private fun getAttributesFromTheme() {
        try {
            if (sizeAttribute == SMALL) {
                setSizeAttributes(R.attr.iconButtonSmall)
            } else {
                setSizeAttributes(R.attr.iconButtonMedium)
            }

            if (colorAttribute == PRIMARY) {
                setColorAttributes(R.attr.iconButtonPrimary)
            } else {
                setColorAttributes(R.attr.iconButtonDefault)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setSizeAttributes(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.ds_icon_button,
                attribute,
                0
            )
            .apply {
                sizeResourceAttribute = this.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_padding)
            }
    }

    private fun setColorAttributes(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.ds_icon_button,
                attribute,
                0
            )
            .apply {
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_iconColor)
            }
    }

    private fun getIconButtonAttributes() {
        getIconAttribute()
        getSizeAttribute()
        getNotifyAttribute()
        getColorAttribute()
    }

    private fun getIconAttribute() {
        try {
            iconAttribute = iconButtonAttributesArray.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_icon)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the iconButton icon(drawable).", e))
        }
    }

    private fun getSizeAttribute() {
        try {
            sizeAttribute = iconButtonAttributesArray.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_size)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the iconButton size.", e))
        }
    }

    private fun getNotifyAttribute() {
        try {
            notifyAttribute = iconButtonAttributesArray.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_notify)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the nofify attribute", e))
        }
    }

    private fun getColorAttribute() {
        try {
            colorAttribute = iconButtonAttributesArray.getResourceIdOrThrow(R.styleable.ds_icon_button_icon_button_color)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the iconButton color.", e))
        }
    }

    private fun configureIconButton() {
        setIcon(iconAttribute)
        setMediumSize()
    }

    private fun setSmallSize() {
        var parameter = iconButton.layoutParams as LayoutParams

//        parameter.width = getDimenFromTheme(R.attr.sizeSemi)
//        parameter.height = getDimenFromTheme(R.attr.sizeSemi)

        parameter.setMargins(
            getDimenFromTheme(R.attr.spacingMicro),
            getDimenFromTheme(R.attr.spacingMicro),
            getDimenFromTheme(R.attr.spacingMicro),
            getDimenFromTheme(R.attr.spacingMicro))
    }

    private fun setMediumSize() {
        var parameter = iconButton.layoutParams as LayoutParams

//        parameter.width = getDimenFromTheme(R.attr.sizeSemiX)
//        parameter.height = getDimenFromTheme(R.attr.sizeSemiX)

        parameter.setMargins(
            getDimenFromTheme(R.attr.spacingTiny),
            getDimenFromTheme(R.attr.spacingTiny),
            getDimenFromTheme(R.attr.spacingTiny),
            getDimenFromTheme(R.attr.spacingTiny))
    }

    private fun getDimenFromTheme(attributeName: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(attributeName, typedValue, true)
        return typedValue.getDimension(context.resources.displayMetrics).toInt()
    }

    companion object {
        const val SMALL = 0
        const val MEDIUM = 1
        const val DEFAULT = 0
        const val PRIMARY = 1
    }
}
