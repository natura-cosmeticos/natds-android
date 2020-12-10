package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.extensions.getAlphaAsBase255
import com.natura.android.extensions.getIconResourceIdFromName

class IconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray
    private var iconColorResourceAttribute = 0
    private var iconNameAttribute: String? = null
    private var colorAttribute: Int? = null

    private val iconButton by lazy { findViewById<ImageView>(R.id.iconButtonIcon) }
    private val iconButtonContainer by lazy { findViewById<ConstraintLayout>(R.id.iconButtonContainer) }

    init {
        try {
            View.inflate(context, R.layout.icon_button, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton)

        getIconButtonAttributes()
        getAttributesFromTheme()
        configureColor(colorAttribute)

        iconButtonAttributesArray.recycle()
    }

    override fun setEnabled(enabled: Boolean) {
        iconButton.isEnabled = enabled
        if(!enabled) {
            setDisabledColor()
        }
        super.setEnabled(enabled)
    }

    private fun setDisabledColor() {
        val typedValue = TypedValue()
        val theme = context.theme
        theme.resolveAttribute(R.attr.opacity05, typedValue, true)

        iconButton.imageAlpha = typedValue.getAlphaAsBase255()
    }

    fun setIcon(icon: String?) {
        icon?.apply {
            val iconDrawableId = context.resources.getIconResourceIdFromName(context, icon)
            iconButton.setImageResource(iconDrawableId)
        }
    }

    fun getIcon(): ImageView {
        return iconButton
    }

    fun getColor(): Int? {
        return colorAttribute
    }

    private fun getIconButtonAttributes() {
        getIconAttribute()
        getColorAttribute()
        getEnabledAttribute()
    }

    private fun getIconAttribute() {
        try {
            iconNameAttribute = iconButtonAttributesArray.getStringOrThrow(R.styleable.IconButton_iconName)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconName required argument. You MUST set the icon name.", e))
        }
    }

    private fun getColorAttribute() {
        try {
            colorAttribute = iconButtonAttributesArray.getIntOrThrow(R.styleable.IconButton_buttonColor)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconButton required argument. You MUST set the iconButton color.", e))
        }
    }

    private fun getEnabledAttribute() {
        isEnabled = iconButtonAttributesArray.getBoolean(R.styleable.IconButton_android_enabled, true)
    }

    private fun getAttributesFromTheme() {
        try {
            when (colorAttribute) {
                PRIMARY -> setColorAttribute(R.attr.iconButtonPrimary)
                DEFAULT -> setColorAttribute(R.attr.iconButtonDefault)
            }

        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setColorAttribute(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                attribute,
                0
            )
            .apply {
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.IconButton_iconColor)
            }
    }

    private fun configureColor(color: Int?) {

        setIcon(iconNameAttribute)
        iconButton.setColorFilter(ContextCompat.getColor(context, iconColorResourceAttribute), android.graphics.PorterDuff.Mode.SRC_IN)

        color?.apply {
            when (this) {
                PRIMARY -> iconButtonContainer.background = resources.getDrawable(R.drawable.iconbutton_ripple_background_primary, context.theme)
                DEFAULT -> iconButtonContainer.background = resources.getDrawable(R.drawable.iconbutton_ripple_background_default, context.theme)
            }
        }
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
    }
}
