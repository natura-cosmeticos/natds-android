package com.natura.android.shortcut

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class Shortcut @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int? = null
    private var backgroundColorResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var iconAttribute: Int? = null
    private var shortcutAttributesArray: TypedArray

    private val labelContainer by lazy { findViewById<TextView>(R.id.shortCutLabel) }
    private val backgroundContainer by lazy { findViewById<LinearLayout>(R.id.shortcutBackground) }
    private val iconContainer by lazy { findViewById<ImageView>(R.id.shortCutIcon) }

    init {
        try {
            View.inflate(context, R.layout.shortcut, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        shortcutAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Shortcut)

        getShortcutAttributes()
        getAttributesFromTheme()
        configureShortCutByType(typeAttribute)

        shortcutAttributesArray.recycle()
    }

    fun setLabel(text: String?) {
        labelContainer.text = text
    }

    fun getLabel(): CharSequence? {
        return labelContainer.text
    }

    fun getType(): Int? = typeAttribute

    fun setIcon(icon: Int?) {
        icon?.apply {
            iconContainer.setImageResource(icon)
            iconContainer.setColorFilter(iconColorResourceAttribute, android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    fun getIcon(): ImageView {
        return iconContainer
    }

    private fun getAttributesFromTheme() {
        try {
            if (typeAttribute == CONTAINED) {
                setContainedTypeAttributes()
            } else {
                setOutlinedTypeAttributes()
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setContainedTypeAttributes() {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        backgroundColorResourceAttribute = typedValue.data

        val typedValue2 = TypedValue()
        context.theme.resolveAttribute(R.attr.colorOnPrimary, typedValue2, true)
        iconColorResourceAttribute = typedValue2.data
    }

    private fun setOutlinedTypeAttributes() {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorSurface, typedValue, true)
        backgroundColorResourceAttribute = typedValue.data

        val typedValue2 = TypedValue()
        context.theme.resolveAttribute(R.attr.colorPrimary, typedValue2, true)
        iconColorResourceAttribute = typedValue2.data
    }

    private fun getShortcutAttributes() {
        getLabelAttribute()
        getIconAttribute()
        getTypeAttribute()
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = shortcutAttributesArray.getIntOrThrow(R.styleable.Shortcut_type)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut type(contained or outlined).", e))
        }
    }

    private fun getIconAttribute() {
        try {
            iconAttribute = shortcutAttributesArray.getResourceIdOrThrow(R.styleable.Shortcut_icon)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut icon(drawable).", e))
        }
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_textLabel)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut label(string).", e))
        }
    }

    private fun configureShortCutByType(type: Int?) {
        type?.apply {
            setLabel(labelAttribute)
            setIcon(iconAttribute)

            when (this) {
                CONTAINED -> setBackgroundContained()
                OUTLINED -> setBackgroundOutlined()
            }
        }
    }

    private fun setBackgroundContained() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null)
        val backgroundWrap = DrawableCompat.wrap(background).mutate()
        DrawableCompat.setTint(backgroundWrap, backgroundColorResourceAttribute)

        backgroundContainer.background = background
    }

    private fun setBackgroundOutlined() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null) as GradientDrawable
        background.setColor(backgroundColorResourceAttribute)
        background.setStroke(1, iconColorResourceAttribute)

        backgroundContainer.background = background
        backgroundContainer.elevation = 0F
    }

    companion object {
        const val OUTLINED = 0
        const val CONTAINED = 1
    }
}
