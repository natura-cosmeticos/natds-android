package com.natura.android.avatar

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.ImagePainter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.core.content.res.getFloatOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.view.get
import com.natura.android.R
import coil.compose.rememberImagePainter
import com.natura.android.extensions.printInitials

class Avatar : AbstractComposeView {

    private var sizeResourceAttribute by mutableStateOf(0)
    private var lineHeightResourceAttribute by mutableStateOf(0F)
    private var letterSpacingResourceAttribute by mutableStateOf(0F)
    private var iconSizeResourceAttribute by mutableStateOf(0)
    private var textSizeResourceAttribute by mutableStateOf(0)
    private var imageSizeResourceAttribute by mutableStateOf(0)
    private var radiusResourceAttribute by mutableStateOf(0)
    private var backgroundColorResourceAttribute by mutableStateOf(0)
    private var fontFamilyResourceAttribute by mutableStateOf("")
    private var paddingResourceAttribute by mutableStateOf(0)
    private var textColorResourceAttribute by mutableStateOf(0)
    private var attrs: AttributeSet? = null

    constructor(context: Context) :
        super(context) {
            init()
        }

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs) {
            init(attrs)
        }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
            init(attrs)
        }

    var size: Int = RESOURCE_NOT_DEFINED
    var type: Int = RESOURCE_NOT_DEFINED
    var icon: Int = RESOURCE_NOT_DEFINED
    var image: Int = RESOURCE_NOT_DEFINED
    var label: String = LABEL_FALLBACK_DEFAULT
    var url: String = ""
    var accessibilityDescription: String = ""
    var labelFallback: String = LABEL_FALLBACK_DEFAULT
    var iconFallback: Int = RESOURCE_NOT_DEFINED

    @Composable
    fun Label(
        isVisible: Boolean,
        value: String = "",
        textSize: TextUnit,
        fontColor: Color,
        fontFamily: FontFamily,
        letterSpacing: TextUnit,
        lineHeight: TextUnit
    ) {
        if (isVisible) {
            Text(
                value.printInitials(),
                color = fontColor,
                fontSize = textSize,
                fontFamily = fontFamily,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight,
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun Image(
        isVisible: Boolean,
        contentDescription: String,
        borderRadius: Dp,
        size: Dp,
        @DrawableRes drawable: Int
    ) {
        if (isVisible) {

            val painter = if (url == "") {
                painterResource(drawable)
            } else {
                rememberImagePainter(
                    data = url
                )
            }

            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(borderRadius))
                    .size(size)
            )

            if (painter is ImagePainter) {

                when (painter.state) {
                    is ImagePainter.State.Error -> {

                        if (iconFallback != RESOURCE_NOT_DEFINED) {

                            IconDrawable(
                                true,
                                contentDescription = accessibilityDescription,
                                convertFloatToDp(
                                    resources.getDimension(
                                        iconSizeResourceAttribute
                                    )
                                ),
                                colorResource(textColorResourceAttribute),
                                iconFallback
                            )
                        } else {
                            Label(
                                true,
                                labelFallback,
                                convertFloatToSp(
                                    resources.getDimension(
                                        textSizeResourceAttribute
                                    )
                                ),
                                colorResource(textColorResourceAttribute),
                                FontFamily(
                                    Typeface.create(
                                        fontFamilyResourceAttribute,
                                        Typeface.NORMAL
                                    )
                                ),
                                convertFloatToSp(letterSpacingResourceAttribute),
                                convertFloatToSp(lineHeightResourceAttribute)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun IconDrawable(
        isVisible: Boolean,
        contentDescription: String,
        size: Dp,
        color: Color,
        @DrawableRes drawable: Int
    ) {
        if (isVisible) {
            Icon(
                modifier = Modifier.size(size),
                imageVector = ImageVector.vectorResource(id = drawable),
                contentDescription = contentDescription,
                tint = color
            )
        }
    }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .size(
                    convertFloatToDp(
                        resources.getDimension(
                            sizeResourceAttribute
                        )
                    )
                )
                .clip(shape = CircleShape)
                .background(
                    colorResource(backgroundColorResourceAttribute)
                )
                .semantics(mergeDescendants = true) {}
                .clickable {},
            Alignment.Center
        ) {
            Label(
                type == LABEL_TYPE,
                label,
                convertFloatToSp(
                    resources.getDimension(
                        textSizeResourceAttribute
                    )
                ),
                colorResource(textColorResourceAttribute),
                FontFamily(Typeface.create(fontFamilyResourceAttribute, Typeface.NORMAL)),
                convertFloatToSp(letterSpacingResourceAttribute),
                convertFloatToSp(lineHeightResourceAttribute)
            )
            Image(
                type == IMAGE_TYPE,
                contentDescription = accessibilityDescription,
                convertFloatToDp(
                    resources.getDimension(
                        radiusResourceAttribute
                    )
                ),
                convertFloatToDp(
                    resources.getDimension(
                        imageSizeResourceAttribute
                    )
                ),
                image
            )
            IconDrawable(
                type == ICON_TYPE,
                contentDescription = accessibilityDescription,
                convertFloatToDp(
                    resources.getDimension(
                        iconSizeResourceAttribute
                    )
                ),
                colorResource(textColorResourceAttribute),
                icon
            )
        }
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        if (attrs != null) {
            this.attrs = attrs

            getAttributesValues()
            getAttributesFromTheme()
        }
    }

    private fun getAttributesValues() {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Avatar,
            0, 0
        ).apply {

            try {
                size = getInt(R.styleable.Avatar_avt_size, MEDIUM_SIZE)
                type = getInt(R.styleable.Avatar_avt_type, ICON_TYPE)
                icon = getResourceId(R.styleable.Avatar_avt_icon, RESOURCE_NOT_DEFINED)
                image = getResourceId(R.styleable.Avatar_avt_image, RESOURCE_NOT_DEFINED)
                label = getString(R.styleable.Avatar_avt_label) ?: LABEL_FALLBACK_DEFAULT
                contentDescription = getString(R.styleable.Avatar_avt_content_description)
                labelFallback =
                    getString(R.styleable.Avatar_avt_fallback_label) ?: LABEL_FALLBACK_DEFAULT
                url = getString(R.styleable.Avatar_avt_image_url) ?: ""
                iconFallback =
                    getResourceId(R.styleable.Avatar_avt_fallback_icon, RESOURCE_NOT_DEFINED)
            } finally {
                recycle()
            }
        }
    }

    private fun getAttributesFromTheme() {
        handleTypeAttr()
        handleSizeAttr()
    }

    private fun handleTypeAttr() {
        when (type) {
            ICON_TYPE -> setTypeAttributes(R.attr.avatarWithIcon)
            LABEL_TYPE -> setTypeAttributes(R.attr.avatarWithLabel)
            else -> setTypeAttributes(R.attr.avatarWithImage)
        }
    }

    private fun handleSizeAttr() {
        when (size) {
            STANDARD_SIZE -> setSizeAttributes(R.attr.avatarStandard)
            SEMI_SIZE -> setSizeAttributes(R.attr.avatarSemi)
            SEMIX_SIZE -> setSizeAttributes(R.attr.avatarSemix)
            MEDIUM_SIZE -> setSizeAttributes(R.attr.avatarMedium)
            else -> setSizeAttributes(R.attr.avatarLargexxx)
        }
    }

    private fun setTypeAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.AvatarStyle, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_colorBackground)
                fontFamilyResourceAttribute =
                    this.getStringOrThrow(R.styleable.AvatarStyle_android_fontFamily)
                textColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_android_textColor)
                paddingResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_android_padding)
            }
    }

    private fun setSizeAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.AvatarStyle, styleFromTheme, 0)
            .apply {
                sizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_avt_view_size)
                iconSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_avt_icon_size)
                imageSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_avt_image_size)
                textSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_android_textSize)
                letterSpacingResourceAttribute =
                    this.getFloatOrThrow(R.styleable.AvatarStyle_android_letterSpacing)
                lineHeightResourceAttribute =
                    this.getFloatOrThrow(R.styleable.AvatarStyle_android_lineSpacingMultiplier)
                radiusResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.AvatarStyle_android_radius)
            }
    }

    @Composable
    private fun convertFloatToDp(value: Float): Dp {
        return with(LocalDensity.current) {
            value.toDp()
        }
    }

    @Composable
    fun Label(isVisible: Boolean, value: String) {
        if (isVisible) {
            Text(value, fontFamily =)
        }

    }

    @Composable
    fun Image(isVisible: Boolean) {
        if (isVisible) {

        }

    }

    @Composable
    fun Icon(isVisible: Boolean) {
        if (isVisible) {

        }

    }

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }

    private fun getAttributesValues(attrs: AttributeSet?) {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Avatar,
            0, 0
        ).apply {

            try {
                size = getInt(R.styleable.Avatar_avt_size, MEDIUM_SIZE)
                type = getInt(R.styleable.Avatar_avt_size, ICON_TYPE)
                icon = getInt(R.styleable.Avatar_avt_icon, RESOURCE_NOT_DEFINED)
                image = getInt(R.styleable.Avatar_avt_image, RESOURCE_NOT_DEFINED)
                label = getString(R.styleable.Avatar_avt_label).toString()

                labelFallback = getString(R.styleable.Avatar_avt_label).toString()
                iconFallback = getInt(R.styleable.Avatar_avt_fallback_icon, RESOURCE_NOT_DEFINED)
            } finally {
                recycle()
            }
        }
    }

    private fun getAttributesFromTheme() {
        handleTypeAttr()
        handleSizeAttr()
    }

    private fun handleTypeAttr() {
        try {
            when (type) {
                ICON_TYPE -> {
                    setAttributes(R.attr.avatar)
                }
                LABEL_TYPE -> {
                    setAttributes(R.attr.dividerInset)
                }
                else -> {
                    setAttributes(R.attr.dividerMiddle)
                }
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun handleSizeAttr() {
        try {
            when (size) {
                ICON_TYPE -> {
                    setAttributes(R.attr.avatar)
                }
                LABEL_TYPE -> {
                    setAttributes(R.attr.dividerInset)
                }
                else -> {
                    setAttributes(R.attr.dividerMiddle)
                }
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Avatar, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_colorBackground)
                widthResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_pgid_width)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_pgid_height)
            }
    }



    companion object {
        const val STANDARD_SIZE = 0
        const val SEMI_SIZE = 1
        const val SEMIX_SIZE = 2
        const val MEDIUM_SIZE = 3
        const val LARGEXX_SIZE = 4

        const val ICON_TYPE = 0
        const val LABEL_TYPE = 1
        const val IMAGE_TYPE = 2

        const val RESOURCE_NOT_DEFINED = 0
        const val LABEL_FALLBACK_DEFAULT = "NA"
    }
}
