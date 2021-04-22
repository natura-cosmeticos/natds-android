package com.natura.android.tag

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.extensions.setAppearance
import com.natura.android.resources.getDimenFromTheme
import kotlinx.android.synthetic.main.ds_tag.view.*

class Tag @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int = 0
    private var sizeAttribute: Int = 0
    private var positionAttribute: Int = 0
    private var sizeResourceAttribute = 0
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
        getSizeAttributeFromTheme()
        configureTagByType(typeAttribute)
        configureTagBySize()

        tagAttributesArray.recycle()
    }

    fun setLabel(text: String?) {
        labelContainer.text = text
        labelContainer.setAppearance(labelTextAppearanceResourceAttribute)
        setTextColor()
        invalidate()
        requestLayout()
    }

    fun getLabel(): CharSequence? {
        return labelContainer.text
    }

    fun getType(): Int = typeAttribute

    fun getSize(): Int = sizeAttribute

    private fun configureTagByType(type: Int) {
        type.apply {
            setLabel(labelAttribute)
            setTextColor()
            setBackground()
        }
    }

    private fun configureTagBySize() {
        var params = tagBackground.layoutParams
        params.height = resources.getDimension(sizeResourceAttribute).toInt()
        tagBackground.layoutParams = params
    }

    private fun setTextColor() {
        labelContainer.setTextColor(ContextCompat.getColor(context, labelTextColorResourceAttribute))
    }

    private fun setBackground() {
        val background: GradientDrawable = resources.getDrawable(R.drawable.tag_background, null) as GradientDrawable
        val backgroundWrap = DrawableCompat.wrap(background).mutate()

        val cornerRadius: Float = 50F
        when (positionAttribute) {
            Position.CENTER.value -> background.cornerRadius = cornerRadius
            Position.RIGHT.value -> background.cornerRadii = floatArrayOf(cornerRadius, cornerRadius, 0F, 0F, 0F, 0F, cornerRadius, cornerRadius)
            Position.LEFT.value -> background.cornerRadii = floatArrayOf(0F, 0F, cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0F, 0F)
        }

        DrawableCompat.setTint(backgroundWrap, ContextCompat.getColor(context, backgroundColorResourceAttribute))
        backgroundContainer.background = background
    }

    private fun getAttributesFromTheme() {
        try {
            when (typeAttribute) {
                PRIMARY -> setTypeAttributes(R.attr.tagPrimary)
                SECONDARY -> setTypeAttributes(R.attr.tagSecondary)
                ALERT -> setTypeAttributes(R.attr.tagAlert)
                SUCCESS -> setTypeAttributes(R.attr.tagSuccess)
                WARNING -> setTypeAttributes(R.attr.tagWarning)
                LINK -> setTypeAttributes(R.attr.tagLink)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getSizeAttributeFromTheme() {
        try {
            when (sizeAttribute) {
                Size.SMALL.value -> setSizeAttribute(R.attr.tagSizeSmall)
                Size.STANDARD.value -> setSizeAttribute(R.attr.tagSizeStandard)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setTypeAttributes(styleAttr: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.Tag,
                styleAttr,
                0
            )
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_colorBackground)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_labelAppearance)
                labelTextColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_android_textColor)
            }
    }

    private fun setSizeAttribute(sizeAttr: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.Tag,
                sizeAttr,
                0
            )
            .apply {
                sizeResourceAttribute = this.getResourceIdOrThrow(R.styleable.Tag_customHeight)
            }
    }

    private fun getTagAttributes() {
        getLabelAttribute()
        getTypeAttribute()
        getSizeAttribute()
        getPositionAttribute()
    }

    private fun getTypeAttribute() {
        typeAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_type, PRIMARY)
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = tagAttributesArray.getStringOrThrow(R.styleable.Tag_textLabel)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing tag required argument. You MUST set the tag label(string).", e))
        }
    }

    private fun getSizeAttribute() {
        sizeAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_size, Size.SMALL.value)
    }

    private fun getPositionAttribute() {
        positionAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_position, Position.CENTER.value)
    }

    companion object {
        const val PRIMARY = 0
        const val ALERT = 1
        const val SECONDARY = 2
        const val SUCCESS = 3
        const val WARNING = 4
        const val LINK = 5
    }
}

enum class Size(val value: Int) {
    SMALL(0),
    STANDARD(1)
}

enum class Position(val value: Int) {
    CENTER(0),
    LEFT(1),
    RIGHT(2)
}