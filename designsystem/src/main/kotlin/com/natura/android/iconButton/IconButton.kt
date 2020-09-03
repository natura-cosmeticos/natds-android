package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class IconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray
    private var iconColorResourceAttribute = 0
    private var iconAttribute: Int? = null
    private var sizeAttribute: Int? = null
    private var colorAttribute: Int? = null

    private val iconButton by lazy { findViewById<ImageView>(R.id.iconButton) }
    private val iconButtonContainer by lazy { findViewById<ConstraintLayout>(R.id.iconButtonMainContainer) }

    override fun setEnabled(enabled: Boolean) {
        iconButton.isEnabled = enabled

        super.setEnabled(enabled)
    }

    init {
        try {
            View.inflate(context, R.layout.icon_button, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton)

        getIconButtonAttributes()
        getAttributesFromTheme()
        configureSize(sizeAttribute)
        configureColor(colorAttribute)

        iconButtonAttributesArray.recycle()
    }

    fun setIcon(icon: Int?) {
        icon?.apply {
            iconButton.setImageResource(icon)
        }
    }

    fun getIcon(): ImageView {
        return iconButton
    }

    fun getSize(): Int? {
        return sizeAttribute
    }

    fun getColor(): Int? {
        return colorAttribute
    }

    private fun getIconButtonAttributes() {
        getIconAttribute()
        getSizeAttribute()
        getColorAttribute()
        getEnabledAttribute()
    }

    private fun getIconAttribute() {
        try {
            iconAttribute = iconButtonAttributesArray.getResourceIdOrThrow(R.styleable.IconButton_buttonIcon)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconButton required argument. You MUST set the iconButton icon(drawable).", e))
        }
    }

    private fun getSizeAttribute() {
        try {
            sizeAttribute = iconButtonAttributesArray.getIntOrThrow(R.styleable.IconButton_size)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconButton required argument. You MUST set the iconButton size.", e))
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

            if (!isEnabled) {
                setColorAttribute(R.attr.iconButtonDisabled)
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

    private fun configureSize(size: Int?) {
        size?.apply {
            when (this) {
                SMALL -> setSmallSize()
                MEDIUM -> setMediumSize()
            }
        }
    }

    private fun configureColor(color: Int?) {

        setIcon(iconAttribute)
        iconButton.setColorFilter(ContextCompat.getColor(context, iconColorResourceAttribute), android.graphics.PorterDuff.Mode.SRC_IN)

        color?.apply {
            when (this) {
                PRIMARY -> iconButton.background = resources.getDrawable(R.drawable.iconbutton_ripple_background_primary, context.theme)
                DEFAULT -> iconButton.background = resources.getDrawable(R.drawable.iconbutton_ripple_background_default, context.theme)
            }
        }
    }

    private fun setSmallSize() {
        var containerParameter = iconButtonContainer.layoutParams as LayoutParams

        containerParameter.width = getDimenFromTheme(R.attr.sizeSemi)
        containerParameter.height = getDimenFromTheme(R.attr.sizeSemi)
    }

    private fun setMediumSize() {
        var containerParameter = iconButtonContainer.layoutParams as LayoutParams

        containerParameter.width = getDimenFromTheme(R.attr.sizeSemiX)
        containerParameter.height = getDimenFromTheme(R.attr.sizeSemiX)
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
