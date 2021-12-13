package com.natura.android.avatar

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class Avatar : AbstractComposeView {
    constructor(context: Context)
        : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?)
        : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
        : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    var size by mutableStateOf(MEDIUM_SIZE)
    var type by mutableStateOf(ICON_TYPE)
    var icon by mutableStateOf(RESOURCE_NOT_DEFINED)
    var image by mutableStateOf(RESOURCE_NOT_DEFINED)
    var label by mutableStateOf("")

    var labelFallback by mutableStateOf("")
    var iconFallback by mutableStateOf(RESOURCE_NOT_DEFINED)

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        if (attrs != null) {
            getAttributesValues(attrs)
            getAttributesFromTheme()
        }
    }

    @Composable
    fun Avatar(
        @DrawableRes avatarResId: Int,
        contentDescription: String = "",
        size: Dp = 50.dp
    ) {
        Image(
            painter = painterResource(avatarResId),
            contentDescription = contentDescription,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(50))
                .size(size)
        )
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

        val typeMap = HashMap<String, Int>()

    }
}