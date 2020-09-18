package com.natura.android.tag

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.extensions.setAppearance

class Tag @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int? = null
    private var backgroundColorResourceAttribute = 0
    private var labelTextAppearanceResourceAttribute = 0
    private var labelTextColorResourceAttribute = 0
    private var tagAttributesArray: TypedArray

    private val labelContainer by lazy { findViewById<TextView>(R.id.tagLabel) }
    private val backgroundContainer by lazy { findViewById<View>(R.id.tagBackground) }

    init {
        try {
            View.inflate(context, R.layout.ds_tag, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        tagAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Tag)

        getTagAttributes()
        getAttributesFromTheme()
        configureTagByType(typeAttribute)

        tagAttributesArray.recycle()
    }

    fun setLabel(text: String?) {
        labelContainer.text = text
        labelContainer.setAppearance(labelTextAppearanceResourceAttribute)
        invalidate()
        requestLayout()
    }

    fun getLabel(): CharSequence? {
        return labelContainer.text
    }

    fun getType(): Int? = typeAttribute

    private fun configureTagByType(type: Int?) {
        type?.apply {
            setLabel(labelAttribute)
            setTextColor()
            setBackground()
        }
    }

    private fun setTextColor() {
        labelContainer.setTextColor(ContextCompat.getColor(context, labelTextColorResourceAttribute))
    }

    private fun setBackground() {
        val background = resources.getDrawable(R.drawable.tag_background, null)
        val backgroundWrap = DrawableCompat.wrap(background).mutate()
        DrawableCompat.setTint(backgroundWrap, ContextCompat.getColor(context, backgroundColorResourceAttribute))

        backgroundContainer.background = background
    }

    private fun getAttributesFromTheme() {
        try {
            if (typeAttribute == PRIMARY) {
                setPrimaryTypeAttributes()
            } else {
                setAlertTypeAttributes()
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setPrimaryTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.Tag,
                R.attr.tagPrimary,
                0
            )
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_colorBackground)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_labelAppearance)
                labelTextColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_android_textColor)
            }
    }

    private fun setAlertTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.Tag,
                R.attr.tagAlert,
                0
            )
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_colorBackground)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_labelAppearance)
                labelTextColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_android_textColor)
            }
    }

    private fun getTagAttributes() {
        getLabelAttribute()
        getTypeAttribute()
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = tagAttributesArray.getIntOrThrow(R.styleable.Tag_tag_type)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing tag required argument. You MUST set the tag type(primary or alert).", e))
        }
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = tagAttributesArray.getStringOrThrow(R.styleable.Tag_textLabel)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing tag required argument. You MUST set the tag label(string).", e))
        }
    }

    companion object {
        const val PRIMARY = 0
        const val ALERT = 1
    }
}
