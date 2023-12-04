package com.natura.android.avatar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.natura.android.R
import com.natura.android.extensions.getInitials
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getFontFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaAvatar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, avatarSize: AvatarSize = AvatarSize.STANDARD_SIZE,
    avatarType: AvatarType = AvatarType.ICON
) : FrameLayout(context, attrs, defStyleAttr) {

    enum class AvatarType {
        ICON, LABEL, IMAGE
    }

    enum class AvatarSize {
        STANDARD_SIZE, SEMI_SIZE, SEMIX_SIZE, MEDIUM_SIZE, LARGEXX_SIZE
    }

    private val backgroundTintList: ColorStateList? = ContextCompat.getColorStateList(context, R.color.button_contained_background_primary_v23)

    private val labelTintList: ColorStateList? = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)

    private val contentContainer: FrameLayout = FrameLayout(context)

    private val imageView: ImageView = ImageView(context)
    private val textView: TextView = TextView(context)
    private val iconView: ImageView = ImageView(context)

    private var avatarIconName: String? = null

    init {
        addView(contentContainer)

        setSize(avatarSize)
        setType(avatarType)
    }

    fun setImage(drawable: Drawable) {
        imageView.setImageDrawable(drawable)
        setType(AvatarType.IMAGE)
    }

    fun setText(text: String) {
        textView.text = text.getInitials()
        setType(AvatarType.LABEL)
    }

    fun setType(type: AvatarType) {
        contentContainer.removeAllViews()

        when (type) {
            AvatarType.IMAGE -> {
                contentContainer.addView(imageView)
            }
            AvatarType.LABEL -> {
                contentContainer.addView(textView)
                textView.text = textView.text.toString().getInitials()
                textView.setTextColor(labelTintList)
                contentContainer.backgroundTintList = backgroundTintList
            }
            AvatarType.ICON -> {
                contentContainer.addView(iconView)
                iconView.imageTintList = labelTintList
                contentContainer.backgroundTintList = backgroundTintList

                val color = getColorTokenFromTheme(context, R.attr.colorOnPrimary)
                iconView.setColorFilter(color, PorterDuff.Mode.SRC_IN)
            }
        }
    }

    private fun updateIcon(iconName: String, imageView: ImageView?) {
        val iconDrawableId = getIconResourceIdFromName(context, iconName)
        imageView?.setBackgroundResource(iconDrawableId)

        contentContainer.backgroundTintList = backgroundTintList

        val color = getColorTokenFromTheme(context, R.attr.colorOnPrimary)
        iconView.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    fun icon(iconName: String?) {
        avatarIconName = iconName
        avatarIconName?.let {
            updateIcon(it, iconView)
        }
    }

    fun setSize(size : AvatarSize) {

        val paddingPx = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
        iconView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx)
        textView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx)

        val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
        textView.setTextColor(textColorStateList)
        textView.typeface = getFontFromTheme(context, R.attr.avatarPrimaryFontWeight, R.attr.avatarPrimaryFontWeight)

        when (size) {
            AvatarSize.STANDARD_SIZE -> {

                val sizeView = getDimenFromTheme(context, R.attr.sizeStandard).toInt()
                val sizeIcon = getDimenFromTheme(context, R.attr.sizeSmall).toInt()

                contentContainer.layoutParams = LayoutParams(sizeView, sizeView)

                val contentLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }

                imageView.layoutParams = contentLayoutParams
                iconView.layoutParams = LayoutParams(sizeIcon, sizeIcon).apply {
                    gravity = Gravity.CENTER
                }
                textView.gravity = Gravity.CENTER

                val shapeDrawable = ShapeDrawable(OvalShape()).apply {
                    paint.color = backgroundTintList?.defaultColor ?: Color.Transparent.value.toInt()
                    intrinsicHeight = sizeView
                    intrinsicWidth = sizeView
                }

                contentContainer.background = shapeDrawable
                contentContainer.clipToOutline = true

                    with(textView) {
                        textView.textSize = getDimenFromTheme(context, R.attr.avatarStandardFontSize) / context.resources.displayMetrics.scaledDensity
                        letterSpacing = getDimenFromTheme(context, R.attr.avatarStandardLetterSpacing)
                        val textColor = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                        setTextColor(textColor)
                    }


                requestLayout()
            }
            AvatarSize.SEMI_SIZE -> {
                val sizeView = getDimenFromTheme(context, R.attr.sizeSemi).toInt()
                val sizeIcon = getDimenFromTheme(context, R.attr.sizeStandard).toInt()

                contentContainer.layoutParams = LayoutParams(sizeView, sizeView)

                val contentLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }

                imageView.layoutParams = contentLayoutParams
                iconView.layoutParams = LayoutParams(sizeIcon, sizeIcon).apply {
                    gravity = Gravity.CENTER
                }
                textView.gravity = Gravity.CENTER

                val shapeDrawable = ShapeDrawable(OvalShape()).apply {
                    paint.color = backgroundTintList?.defaultColor ?: Color.Transparent.value.toInt()
                    intrinsicHeight = sizeView
                    intrinsicWidth = sizeView
                }

                contentContainer.background = shapeDrawable
                contentContainer.clipToOutline = true

                with(textView) {
                    textView.textSize = getDimenFromTheme(context, R.attr.avatarSemiFontSize) / context.resources.displayMetrics.scaledDensity
                    val textColor = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                    setTextColor(textColor)
                }

                requestLayout()
            }
            AvatarSize.SEMIX_SIZE -> {
                val sizeView = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()
                val sizeIcon = getDimenFromTheme(context, R.attr.sizeSemi).toInt()

                contentContainer.layoutParams = LayoutParams(sizeView, sizeView)

                val contentLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }

                imageView.layoutParams = contentLayoutParams
                iconView.layoutParams = LayoutParams(sizeIcon, sizeIcon).apply {
                    gravity = Gravity.CENTER
                }
                textView.gravity = Gravity.CENTER

                val shapeDrawable = ShapeDrawable(OvalShape()).apply {
                    paint.color = backgroundTintList?.defaultColor ?: Color.Transparent.value.toInt()
                    intrinsicHeight = sizeView
                    intrinsicWidth = sizeView
                }

                contentContainer.background = shapeDrawable
                contentContainer.clipToOutline = true

                    with(textView) {
                        textView.textSize = getDimenFromTheme(context, R.attr.avatarSemiXFontSize) / context.resources.displayMetrics.scaledDensity
                        letterSpacing = getDimenFromTheme(context, R.attr.avatarSemiXLetterSpacing)
                        val textColor = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                        setTextColor(textColor)
                    }


                requestLayout()
            }
            AvatarSize.MEDIUM_SIZE -> {
                val sizeView = getDimenFromTheme(context, R.attr.sizeMedium).toInt()
                val sizeIcon = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()

                contentContainer.layoutParams = LayoutParams(sizeView, sizeView)

                val contentLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

                imageView.layoutParams = contentLayoutParams
                iconView.layoutParams = LayoutParams(sizeIcon, sizeIcon).apply {
                    gravity = Gravity.CENTER
                }
                textView.gravity = Gravity.CENTER

                val shapeDrawable = ShapeDrawable(OvalShape()).apply {
                    paint.color = backgroundTintList?.defaultColor ?: Color.Transparent.value.toInt()
                    intrinsicHeight = sizeView
                    intrinsicWidth = sizeView
                }

                contentContainer.background = shapeDrawable
                contentContainer.clipToOutline = true

                with(textView) {
                    textView.textSize = getDimenFromTheme(context, R.attr.avatarMediumFontSize) / context.resources.displayMetrics.scaledDensity
                    letterSpacing = getDimenFromTheme(context, R.attr.avatarMediumLetterSpacing)
                    val textColor = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                    setTextColor(textColor)
                }

                requestLayout()
            }
            AvatarSize.LARGEXX_SIZE -> {
                val sizeView = getDimenFromTheme(context, R.attr.sizeLargeXXX).toInt()
                val sizeIcon = getDimenFromTheme(context, R.attr.sizeLargeXX).toInt()

                contentContainer.layoutParams = LayoutParams(sizeView, sizeView)

                val contentLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }

                imageView.layoutParams = contentLayoutParams
                iconView.layoutParams = LayoutParams(sizeIcon, sizeIcon).apply {
                    gravity = Gravity.CENTER
                }
                textView.gravity = Gravity.CENTER

                val shapeDrawable = ShapeDrawable(OvalShape()).apply {
                    paint.color = backgroundTintList?.defaultColor ?: Color.Transparent.value.toInt()
                    intrinsicHeight = sizeView
                    intrinsicWidth = sizeView
                }

                contentContainer.background = shapeDrawable
                contentContainer.clipToOutline = true

                with(textView) {
                    textView.textSize = getDimenFromTheme(context, R.attr.avatarLargeXXXFontSize) / context.resources.displayMetrics.scaledDensity
                    letterSpacing = getDimenFromTheme(context, R.attr.avatarLargeXXXLetterSpacing)
                    val textColor = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                    setTextColor(textColor)
                }

                requestLayout()
            }
        }
    }
}
