package com.natura.android.tag

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaTag @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var tagAttributesArray: TypedArray

    var label: String? = ""
        set(value) {
            field = value
            labelContainer.text = value
        }

    var color: Int = GaYaTagColor.Primary.value
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    var icon: String? = null
        set(value) {
            field = value
            configureIcon()
        }

    var size: Int = GaYaTagSize.Small.value
        set(value) {
            field = value
            configureSize()
        }

    var position: Int = GaYaTagPosition.Center.value
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    private lateinit var labelContainer: TextView
    private lateinit var iconContainer: ImageView
    private lateinit var backgroundContainer: View

    init {
        tagAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.GaYaTag)

        try {
            View.inflate(context, R.layout.gayatag, this)
        } catch (e: Exception) {
            throw MissingThemeException()
        }

        tagAttributesArray =
            context.obtainStyledAttributes(attrs, R.styleable.GaYaTag)

        configureViews()
        getAttributes()

        tagAttributesArray.recycle()
    }

    private fun configureViews() {
        labelContainer = findViewById(R.id.tag_label)
        iconContainer = findViewById(R.id.tag_icon)
        backgroundContainer = findViewById(R.id.tag_background)

        configureAppearance(getDrawable())
    }

    private fun getDrawable(): GradientDrawable {
        val backgroundDrawable = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.tag_background,
            null
        )
        return backgroundDrawable?.mutate() as GradientDrawable
    }

    private fun getAttributes() {
        tagAttributesArray.apply {
            label = getString(R.styleable.GaYaTag_gtag_label) ?: ""
            color = getInt(R.styleable.GaYaTag_gtag_color, GaYaTagColor.Primary.value)
            size = getInt(R.styleable.GaYaTag_gtag_size, GaYaTagSize.Small.value)
            position = getInt(R.styleable.GaYaTag_gtag_position, GaYaTagPosition.Center.value)
            icon = getString(R.styleable.GaYaTag_gtag_icon) ?: ""
        }

        configureAppearance(getDrawable())
    }

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {

        configureIcon()
        configureSize()

        val backgroundColor = when (color) {
            GaYaTagColor.Primary.value -> R.color.gaya_background_primary_v23
            GaYaTagColor.PrimaryLightest.value -> R.color.gaya_background_primary_lightest_v23
            GaYaTagColor.PrimaryDarkest.value -> R.color.gaya_background_primary_darkest_v23

            GaYaTagColor.Secondary.value -> R.color.gaya_background_secondary_v23
            GaYaTagColor.SecondaryLightest.value -> R.color.gaya_background_secondary_lightest_v23
            GaYaTagColor.SecondaryDarkest.value -> R.color.gaya_background_secondary_darkest_v23

            GaYaTagColor.Success.value -> R.color.gaya_background_success_v23
            GaYaTagColor.SuccessLightest.value -> R.color.gaya_background_success_lightest_v23
            GaYaTagColor.SuccessDarkest.value -> R.color.gaya_background_success_darkest_v23

            GaYaTagColor.Alert.value -> R.color.gaya_background_alert_v23
            GaYaTagColor.AlertLightest.value -> R.color.gaya_background_alert_lightest_v23
            GaYaTagColor.AlertDarkest.value -> R.color.gaya_background_alert_darkest_v23

            GaYaTagColor.Warning.value -> R.color.gaya_background_warning_v23
            GaYaTagColor.WarningLightest.value -> R.color.gaya_background_warning_lightest_v23
            GaYaTagColor.WarningDarkest.value -> R.color.gaya_background_warning_darkest_v23

            GaYaTagColor.Info.value -> R.color.gaya_background_info_v23
            GaYaTagColor.InfoLightest.value -> R.color.gaya_background_info_lightest_v23
            GaYaTagColor.InfoDarkest.value -> R.color.gaya_background_info_darkest_v23

            else -> R.color.gaya_background_primary_v23
        }

        backgroundDrawable.color = ContextCompat.getColorStateList(
            context,
            backgroundColor
        )

        val radiusEnabled: Float
        val radiusDisabled: Float

        if (size == GaYaTagSize.Small.value) {
            radiusEnabled = getDimenFromTheme(context, R.attr.tagSmallBorderRadiusEnable)
            radiusDisabled = getDimenFromTheme(context, R.attr.tagSmallBorderRadiusDisable)
        } else {
            radiusEnabled = getDimenFromTheme(context, R.attr.tagStandardBorderRadiusEnable)
            radiusDisabled = getDimenFromTheme(context, R.attr.tagStandardBorderRadiusDisable)
        }

        when (position) {
            GaYaTagPosition.Center.value -> backgroundDrawable.cornerRadius = radiusEnabled
            GaYaTagPosition.Right.value ->
                backgroundDrawable.cornerRadii =
                    floatArrayOf(
                        radiusEnabled,
                        radiusEnabled,
                        radiusDisabled,
                        radiusDisabled,
                        radiusDisabled,
                        radiusDisabled,
                        radiusEnabled,
                        radiusEnabled
                    )

            GaYaTagPosition.Left.value ->
                backgroundDrawable.cornerRadii =
                    floatArrayOf(
                        radiusDisabled,
                        radiusDisabled,
                        radiusEnabled,
                        radiusEnabled,
                        radiusEnabled,
                        radiusEnabled,
                        radiusDisabled,
                        radiusDisabled
                    )
        }

        backgroundContainer.background = backgroundDrawable

        val onContentColor = when (color) {
            GaYaTagColor.Primary.value -> R.attr.colorOnPrimary
            GaYaTagColor.PrimaryLightest.value -> R.attr.colorOnPrimaryLightest
            GaYaTagColor.PrimaryDarkest.value -> R.attr.colorOnPrimaryDarkest

            GaYaTagColor.Secondary.value -> R.attr.colorOnSecondary
            GaYaTagColor.SecondaryLightest.value -> R.attr.colorOnSecondaryLightest
            GaYaTagColor.SecondaryDarkest.value -> R.attr.colorOnSecondaryDarkest

            GaYaTagColor.Success.value -> R.attr.colorOnSuccess
            GaYaTagColor.SuccessLightest.value -> R.attr.colorOnSuccessLightest
            GaYaTagColor.SuccessDarkest.value -> R.attr.colorOnSuccessDarkest

            GaYaTagColor.Alert.value -> R.attr.colorOnAlert
            GaYaTagColor.AlertLightest.value -> R.attr.colorOnAlertLightest
            GaYaTagColor.AlertDarkest.value -> R.attr.colorOnAlertDarkest

            GaYaTagColor.Warning.value -> R.attr.colorOnWarning
            GaYaTagColor.WarningLightest.value -> R.attr.colorOnWarningLightest
            GaYaTagColor.WarningDarkest.value -> R.attr.colorOnWarningDarkest

            GaYaTagColor.Info.value -> R.attr.colorOnInfo
            GaYaTagColor.InfoLightest.value -> R.attr.colorOnInfoLightest
            GaYaTagColor.InfoDarkest.value -> R.attr.colorOnInfoDarkest

            else -> R.color.gaya_background_primary_v23
        }

        labelContainer.setTextColor(
            getColorTokenFromTheme(
                context,
                onContentColor
            )
        )

        iconContainer.setColorFilter(
            getColorTokenFromTheme(context, onContentColor),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }

    private fun configureIcon() {
        if (icon.isNullOrEmpty()) {
            iconContainer.visibility = View.GONE
        } else {
            val iconDrawableId = getIconResourceIdFromName(context, icon.toString())
            iconContainer.visibility = View.VISIBLE
            iconContainer.setImageResource(iconDrawableId)
        }
    }

    private fun configureSize() {
        val params = backgroundContainer.layoutParams
        params.height = if (size == GaYaTagSize.Small.value) {
            getDimenFromTheme(context, R.attr.sizeSmall).toInt()
        } else {
            getDimenFromTheme(context, R.attr.sizeStandard).toInt()
        }
        backgroundContainer.layoutParams = params
    }
}

enum class GaYaTagColor(val value: Int) {
    Primary(0),
    PrimaryDarkest(1),
    PrimaryLightest(2),

    Secondary(3),
    SecondaryDarkest(4),
    SecondaryLightest(5),

    Success(6),
    SuccessDarkest(7),
    SuccessLightest(8),

    Alert(9),
    AlertDarkest(10),
    AlertLightest(11),

    Warning(12),
    WarningDarkest(13),
    WarningLightest(14),

    Info(15),
    InfoDarkest(16),
    InfoLightest(17)
}

enum class GaYaTagSize(val value: Int) {
    Small(0),
    Standard(1)
}

enum class GaYaTagPosition(val value: Int) {
    Center(0),
    Left(1),
    Right(2)
}
