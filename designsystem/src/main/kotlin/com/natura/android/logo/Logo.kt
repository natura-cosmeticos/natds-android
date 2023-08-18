package com.natura.android.logo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getDrawableFromTheme

class Logo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var typedArray: TypedArray
    private val imageView: ImageView by lazy { findViewById(R.id.logoImageView) }

    enum class Model {
        A, B
    }

    enum class Language {
        None, Es, Pt
    }

    enum class Color(@AttrRes val attribute: Int) {
        NEUTRAL(0),
        PRIMARY(R.attr.colorPrimary),
        SECONDARY(R.attr.colorSecondary),
        HIGHLIGHT(R.attr.colorHighlight),
        SURFACE(R.attr.colorSurface)
    }

    enum class Size(@AttrRes val attribute: Int) {
        MEDIUM(R.attr.sizeMedium),
        MEDIUMX(R.attr.sizeMediumX),
        LARGE(R.attr.sizeLarge),
        LARGEX(R.attr.sizeLargeX),
        LARGEXX(R.attr.sizeLargeXX),
        LARGEXXX(R.attr.sizeLargeXXX),
        HUGE(R.attr.sizeHuge),
        HUGEX(R.attr.sizeHugeX),
        HUGEXX(R.attr.sizeHugeXX),
        HUGEXXX(R.attr.sizeHugeXXX),
        VERYHUGE(R.attr.sizeVeryHuge)
    }

    var model: Model = Model.A
    var language:Language = Language.None
    var color: Color = Color.NEUTRAL
    var size: Size = Size.VERYHUGE

    init {
        try {
            View.inflate(context, R.layout.logo, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Logo)

        getAttributes()
        setSize()
        setDrawableResource()

        if (color != Color.NEUTRAL) {
            setColor()
        }

        typedArray.recycle()
        requestLayout()
    }

    private fun getAttributes() {
        color = intToColor(typedArray.getInt(R.styleable.Logo_customColor, 0))
        size = intToSize(typedArray.getInt(R.styleable.Logo_customSize, 0))
        model = intToModel(typedArray.getInt(R.styleable.Logo_model, 0))
        language = intToLanguage(typedArray.getInt(R.styleable.Logo_language, 0))
    }

    private fun getLanguageSuffix(language: Language): String {
        return when (language) {
            Language.None -> ""
            else -> language.name
        }
    }

    private fun setDrawableResource() {

        val languageSuffix = getLanguageSuffix(language)

        val drawableAttr = if (color == Color.NEUTRAL) {
            when (model) {
                Model.A -> getDrawableAttr("assetBrandNeutralA${languageSuffix}File")
                Model.B -> getDrawableAttr("assetBrandNeutralB${languageSuffix}File")
            }
        } else {
            when (model) {
                Model.A -> getDrawableAttr("assetBrandCustomA${languageSuffix}File")
                Model.B -> getDrawableAttr("assetBrandCustomB${languageSuffix}File")
            }
        }

        this.imageView.setImageDrawable(getDrawableFromTheme(context, drawableAttr))
    }

    private fun getDrawableAttr(attributeName: String): Int {
        val resourceId = context.resources.getIdentifier(attributeName, "attr", context.packageName)
        if (resourceId == 0) {
            throw IllegalArgumentException("Attribute not found: $attributeName")
        }
        return resourceId
    }

    private fun setColor() {
        this.imageView.setColorFilter(getColorTokenFromTheme(context, color.attribute))
    }

    private fun setSize() {
        this.imageView.adjustViewBounds = true

        val layoutParams = imageView.layoutParams
        layoutParams.width = getDimenFromTheme(context, size.attribute).toInt()
        imageView.layoutParams = layoutParams
        requestLayout()
    }

    private fun intToColor(color: Int) = when (color) {
        0 -> Color.NEUTRAL
        1 -> Color.PRIMARY
        2 -> Color.SECONDARY
        3 -> Color.HIGHLIGHT
        else -> Color.SURFACE
    }

    fun getImageView(): Drawable? {
        return imageView.drawable
    }

    private fun intToModel(model: Int) = when (model) {
        0 -> Model.A
        else -> Model.B
    }

    private fun intToLanguage(language: Int) = when (language) {
        0 -> Language.None
        1 -> Language.Es
        else -> Language.Pt
    }

    private fun intToSize(size: Int) = when (size) {
        0 -> Size.MEDIUM
        1 -> Size.MEDIUMX
        2 -> Size.LARGE
        3 -> Size.LARGEX
        4 -> Size.LARGEXX
        5 -> Size.LARGEXXX
        6 -> Size.HUGE
        7 -> Size.HUGEX
        8 -> Size.HUGEXX
        9 -> Size.HUGEXXX
        else -> Size.VERYHUGE
    }
}
