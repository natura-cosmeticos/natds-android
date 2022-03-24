package com.natura.android.tag

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.databinding.TagBinding
import com.natura.android.exceptions.LayoutInflateException
import com.natura.android.exceptions.MissingThemeException

class Tag @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int = 0
    private var iconAttribute: Drawable? = null
    private var sizeAttribute: Int = 0
    private var positionAttribute: Int = 0
    private var sizeResourceAttribute = 0
    private var radiusEnabledResourceAttribute = 0
    private var radiusDisabledesourceAttribute = 0
    private var backgroundColorResourceAttribute = 0
    private var labelTextColorResourceAttribute = 0
    private var tagAttributesArray: TypedArray

    private var binding: TagBinding

    init {
        try {
            binding = TagBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw (LayoutInflateException())
        }

        tagAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Tag)

        getTagAttributes()
        getTypeAttributesFromTheme()
        getSizeAttributeFromTheme()
        configureTagByType()
        configureTagBySize()

        tagAttributesArray.recycle()
    }

    fun setLabel(text: String?) {
        binding.tgLabel.text = text
        invalidate()
        requestLayout()
    }

    fun getLabel(): CharSequence? {
        return binding.tgLabel.text
    }

    fun getType(): Int = typeAttribute

    fun getIcon(): Drawable? = iconAttribute

    fun getSize(): Int = sizeAttribute

    fun getPosition(): Int = positionAttribute

    private fun configureTagByType() {
        typeAttribute.apply {
            setLabel(labelAttribute)
            setTextColor()
            setBackground()
        }
    }

    private fun configureTagBySize() {
        val params = binding.tgBackground.layoutParams
        params.height = resources.getDimension(sizeResourceAttribute).toInt()
        binding.tgBackground.layoutParams = params
    }

    private fun setTextColor() {
        binding.tgLabel.setTextColor(
            ContextCompat.getColor(
                context,
                labelTextColorResourceAttribute
            )
        )

        binding.tgIcon.setColorFilter(
            ContextCompat.getColor(
                context,
                labelTextColorResourceAttribute
            )
        )
    }

    private fun setBackground() {
        val background: GradientDrawable =
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.tag_background,
                null
            ) as GradientDrawable
        val backgroundWrap = DrawableCompat.wrap(background).mutate()

        val enabledBorderRadius = context.resources.getDimension(radiusEnabledResourceAttribute)
        val disabledBorderRadius = context.resources.getDimension(radiusDisabledesourceAttribute)

        when (positionAttribute) {
            CENTER -> background.cornerRadius = enabledBorderRadius
            RIGHT ->
                background.cornerRadii =
                    floatArrayOf(
                        enabledBorderRadius,
                        enabledBorderRadius,
                        disabledBorderRadius,
                        disabledBorderRadius,
                        disabledBorderRadius,
                        disabledBorderRadius,
                        enabledBorderRadius,
                        enabledBorderRadius
                    )
            LEFT ->
                background.cornerRadii =
                    floatArrayOf(
                        disabledBorderRadius,
                        disabledBorderRadius,
                        enabledBorderRadius,
                        enabledBorderRadius,
                        enabledBorderRadius,
                        enabledBorderRadius,
                        disabledBorderRadius,
                        disabledBorderRadius
                    )
        }

        DrawableCompat.setTint(
            backgroundWrap,
            ContextCompat.getColor(context, backgroundColorResourceAttribute)
        )
        binding.tgBackground.background = background

        iconAttribute?.let {
            binding.tgIcon.visibility = View.VISIBLE
            binding.tgIcon.setImageDrawable(it)
        }
    }

    private fun getTypeAttributesFromTheme() {
        when (typeAttribute) {
            PRIMARY -> setTypeAttributes(R.attr.tagPrimary)
            SECONDARY -> setTypeAttributes(R.attr.tagSecondary)
            ALERT -> setTypeAttributes(R.attr.tagAlert)
            SUCCESS -> setTypeAttributes(R.attr.tagSuccess)
            WARNING -> setTypeAttributes(R.attr.tagWarning)
            LINK -> setTypeAttributes(R.attr.tagLink)
            CUSTOM -> setCustomTypeAttributes()
            else -> setTypeAttributes(R.attr.tagPrimary)
        }
    }

    private fun getSizeAttributeFromTheme() {
        try {
            when (sizeAttribute) {
                SMALL -> setSizeAttribute(R.attr.tagSizeSmall)
                STANDARD -> setSizeAttribute(R.attr.tagSizeStandard)
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
                R.styleable.TagStyle,
                styleAttr,
                0
            )
            .apply {
                backgroundColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.TagStyle_colorBackground)
                labelTextColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.TagStyle_android_textColor)
            }
    }

    private fun setCustomTypeAttributes() {
        setCustomBackgroundColorAttribute()
        setCustomLabelColorAttribute()
    }

    private fun setCustomBackgroundColorAttribute() {
        try {
            backgroundColorResourceAttribute =
                tagAttributesArray.getResourceIdOrThrow(R.styleable.Tag_tag_background_color)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing tag required argument. You MUST set the tag background color.",
                    e
                )
                )
        }
    }

    private fun setCustomLabelColorAttribute() {
        try {
            labelTextColorResourceAttribute =
                tagAttributesArray.getResourceIdOrThrow(R.styleable.Tag_tag_label_color)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing tag required argument. You MUST set the tag label color.",
                    e
                )
                )
        }
    }

    private fun setSizeAttribute(sizeAttr: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.TagStyle,
                sizeAttr,
                0
            )
            .apply {
                sizeResourceAttribute = this.getResourceIdOrThrow(R.styleable.TagStyle_customHeight)
                radiusEnabledResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.TagStyle_radiusEnabledValue)
                radiusDisabledesourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.TagStyle_radiusDisabledValue)
            }
    }

    private fun getTagAttributes() {
        getLabelAttribute()

        typeAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_type, PRIMARY)
        sizeAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_size, SMALL)
        iconAttribute =
            tagAttributesArray.getDrawable(R.styleable.Tag_tag_icon)
        positionAttribute = tagAttributesArray.getInt(R.styleable.Tag_tag_position, CENTER)
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = tagAttributesArray.getStringOrThrow(R.styleable.Tag_textLabel)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing tag required argument. You MUST set the tag label(string).",
                )
                )
        }
    }

    companion object {
        const val PRIMARY = 0
        const val ALERT = 1
        const val SECONDARY = 2
        const val SUCCESS = 3
        const val WARNING = 4
        const val LINK = 5
        const val CUSTOM = 6

        const val SMALL = 0
        const val STANDARD = 1

        const val CENTER = 0
        const val LEFT = 1
        const val RIGHT = 2

        private const val RESOURCE_NOT_DEFINED = 0
    }
}
