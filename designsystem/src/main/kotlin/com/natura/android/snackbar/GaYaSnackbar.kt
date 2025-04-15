package com.natura.android.snackbar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.doOnDetach
import com.google.android.material.card.MaterialCardView
import com.natura.android.R
import com.natura.android.databinding.GayasnackbarBinding
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaSnackbar private constructor(
    private val snackMainView: View,
    private val snackMessage: String,
    private val snackTitle: String? = null,
    private val snackShowTitle: Boolean = false,
    private val snackMainButtonAction: (() -> Unit)? = null,
    private val snackMainButtonTitle: String? = null,
    private val showSnackIcon: Boolean = false,
    private val snackIconName: String? = null,
    private val snackIconButtonName: String? = null,
    private val snackColorType: GaYaSnackbarColorType? = null,
    private val snackPositionType: GaYaSnackbarPositionType? = null,
    private val snackAnimation: Boolean = false,
    private val snackAnimationType: GaYaSnackbarAnimationtype? = null,
    private val snackTimerType: GaYaSnackbarTimerType? = null,
    private val snackCustomTimerMillisecondInterval: Int? = null,
    private val snackActionButtonType: GaYaSnackbarActionButtonType? = null
) {

    private var snackbarBody: MaterialCardView? = null
    private var layoutBody: ConstraintLayout? = null
    private var popupWindow: PopupWindow? = null
    private var gravityPosition: Int = 0
    private var toolbarHeight: Int = 0
    private var timer: CountDownTimer? = null
    private var binding: GayasnackbarBinding? = null
    private var context: Context

    private val mainButtonClickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            popupWindow?.dismiss()
            snackMainButtonAction?.invoke()
        }
    }

    init {
        binding = GayasnackbarBinding.inflate(LayoutInflater.from(snackMainView.context))
        layoutBody = binding?.root
        context = snackMainView.context
        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        popupWindow = PopupWindow(binding?.root, width, height, false)
        snackbarBody = binding?.snackBody
        setActionButtonType()
        setPositionType()
        setAnimationtype()
        setTimerType()
        setSnackTexts()
        setSnackIcon()
        setColorType()
        configureBackgroundColor()
        snackMainView.doOnDetach {
            timer?.cancel()
            popupWindow?.dismiss()
        }
    }

    private fun setSnackTexts() {
        // Título
        if (snackShowTitle && !snackTitle.isNullOrBlank()) {
            binding?.txtTitle?.text = snackTitle
            binding?.txtTitle?.visibility = View.VISIBLE
        } else {
            binding?.txtTitle?.visibility = View.GONE
        }

        // Mensagem
        if (!snackMessage.isNullOrBlank()) {
            binding?.txtMessage?.text = snackMessage
            binding?.txtMessage?.visibility = View.VISIBLE
        } else {
            binding?.txtMessage?.visibility = View.GONE
        }
    }


    private fun setSnackIcon() {
        val titleIcon = binding?.ivTitleIcon
        val noTitleIcon = binding?.ivNoTitleIcon

        // Ícone com título
        if (showSnackIcon && snackShowTitle && !snackTitle.isNullOrBlank()) {
            titleIcon?.visibility = View.VISIBLE
        } else {
            titleIcon?.visibility = View.GONE
        }

        // Ícone sem título
        if (showSnackIcon && (!snackShowTitle || snackTitle.isNullOrBlank())) {
            noTitleIcon?.visibility = View.VISIBLE
        } else {
            noTitleIcon?.visibility = View.GONE
        }

        snackIconName?.let {
            setIcon(it, titleIcon)
            setIcon(it, noTitleIcon)
        }
    }


    fun setIcon(iconName: String, imageView: ImageView?) {
        val iconDrawableId = getIconResourceIdFromName(snackMainView.context, iconName)
        imageView?.setBackgroundResource(iconDrawableId)
    }

    private fun setActionButtonType() {
        val btnInline = binding?.btnInline
        val btnBlock = binding?.btnBlock
        val btnIcon = binding?.btnIcon

        snackMainButtonTitle?.let {
            btnInline?.text = it
            btnBlock?.text = it
        }

        val typeToApply = when {
            snackActionButtonType != null && snackActionButtonType != GaYaSnackbarActionButtonType.NONE -> snackActionButtonType
            !snackMainButtonTitle.isNullOrBlank() -> GaYaSnackbarActionButtonType.INLINE_BOTTON
            else -> GaYaSnackbarActionButtonType.NONE
        }

        when (typeToApply) {
            GaYaSnackbarActionButtonType.NONE -> {
                btnInline?.visibility = View.GONE
                btnBlock?.visibility = View.GONE
                btnIcon?.visibility = View.GONE
            }

            GaYaSnackbarActionButtonType.BLOCK_BOTTON -> {
                btnInline?.visibility = View.GONE
                btnBlock?.visibility = View.VISIBLE
                btnIcon?.visibility = View.GONE
            }

            GaYaSnackbarActionButtonType.INLINE_BOTTON -> {
                btnInline?.visibility = View.VISIBLE
                btnBlock?.visibility = View.GONE
                btnIcon?.visibility = View.GONE
            }

            GaYaSnackbarActionButtonType.ICON_BOTTON -> {
                btnInline?.visibility = View.GONE
                btnBlock?.visibility = View.GONE
                btnIcon?.visibility = View.VISIBLE

                snackIconButtonName?.let {
                    setIcon(it, btnIcon)
                }
            }
        }

        btnIcon?.setOnClickListener(mainButtonClickListener)
        btnBlock?.setOnClickListener(mainButtonClickListener)
        btnInline?.setOnClickListener(mainButtonClickListener)
    }

    private fun setPositionType() {
        when (snackPositionType) {
            GaYaSnackbarPositionType.TOP_CENTER -> {
                val location = IntArray(2)
                snackMainView.getLocationOnScreen(location)
                toolbarHeight = location[1]
                gravityPosition = Gravity.TOP
            }

            else -> {
                gravityPosition = Gravity.BOTTOM
            }
        }
    }

    private fun setColorType() {
        if (!snackShowTitle) {
            binding?.txtTitle?.visibility = View.GONE
            binding?.ivTitleIcon?.visibility = View.GONE
        }

    }

    private fun setAnimationtype() {

        if (snackAnimation) {
            when (snackAnimationType) {
                GaYaSnackbarAnimationtype.CENTER -> {
                    when (snackPositionType) {
                        GaYaSnackbarPositionType.TOP_CENTER ->
                            popupWindow?.animationStyle = R.style.SnackBarInOutFromTop

                        GaYaSnackbarPositionType.BOTTOM_CENTER ->
                            popupWindow?.animationStyle = (R.style.SnackBarInOutFromBottom)

                        else -> {}
                    }
                }

                GaYaSnackbarAnimationtype.LEFT ->
                    popupWindow?.animationStyle = R.style.SnackBarInLeftOutRight

                GaYaSnackbarAnimationtype.RIGHT ->
                    popupWindow?.animationStyle = R.style.SnackBarInRightOutLeft

                else -> {}
            }
        }
    }

    private fun setTimerType() {
        when (snackTimerType) {
            null,
            GaYaSnackbarTimerType.MINIMUM -> {
                timer = object : CountDownTimer(
                    MINIMUM_INTERVAL_MILLISECOND.toLong(),
                    MINIMUM_INTERVAL_MILLISECOND.toLong()
                ) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        popupWindow?.dismiss()
                    }
                }.start()
            }

            GaYaSnackbarTimerType.INTERMEDIARY -> {
                timer = object : CountDownTimer(
                    INTERMEDIARY_INTERVAL_MILLISECOND.toLong(),
                    INTERMEDIARY_INTERVAL_MILLISECOND.toLong()
                ) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        popupWindow?.dismiss()
                    }
                }.start()
            }

            GaYaSnackbarTimerType.INDETERMINATE -> {
                snackbarBody?.setOnClickListener {
                    popupWindow?.dismiss()
                }
            }

            GaYaSnackbarTimerType.CUSTOM -> {
                snackCustomTimerMillisecondInterval?.let { timeout ->
                    timer = object : CountDownTimer(
                        timeout.toLong(),
                        timeout.toLong()
                    ) {
                        override fun onTick(millisUntilFinished: Long) {}
                        override fun onFinish() {
                            popupWindow?.dismiss()
                        }
                    }.start()
                }
            }
        }
    }

    fun show() {
        popupWindow?.showAtLocation(snackMainView, gravityPosition, 0, toolbarHeight)
    }

    fun dismiss() {
        popupWindow?.dismiss()
    }

    private fun configureBackgroundColor() {
        when (snackColorType) {
            GaYaSnackbarColorType.SUCCESS -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorSuccess)
                snackbarBody?.setCardBackgroundColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorSuccess
                    )
                )

                binding?.txtTitle?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnSuccess
                    )
                )

                binding?.txtMessage?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnSuccess
                    )
                )
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorOnSuccess))
            }

            GaYaSnackbarColorType.ERROR -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorError)
                snackbarBody?.setCardBackgroundColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorError
                    )
                )
                binding?.txtTitle?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnError
                    )
                )

                binding?.txtMessage?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnError
                    )
                )
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorOnError))
            }

            GaYaSnackbarColorType.WARNING -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorWarning)
                snackbarBody?.setCardBackgroundColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorWarning
                    )
                )

                binding?.txtTitle?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnWarning
                    )
                )

                binding?.txtMessage?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnWarning
                    )
                )
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorOnWarning))
            }

            GaYaSnackbarColorType.INFO -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorLink)
                snackbarBody?.setCardBackgroundColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorLink
                    )
                )
                binding?.txtTitle?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnInfo
                    )
                )

                binding?.txtMessage?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnInfo
                    )
                )
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorOnInfo))
            }

            else -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorNeutralDarkest)
                snackbarBody?.setCardBackgroundColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorNeutralDarkest
                    )
                )
                binding?.txtTitle?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorSurface
                    )
                )

                binding?.txtMessage?.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorSurface
                    )
                )
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorSurface))
            }
        }
    }

    private fun parseStringColorToInt(): Int {
        return Color.parseColor("#333333")
    }

    companion object {
        private const val MINIMUM_INTERVAL_MILLISECOND = 5000
        private const val INTERMEDIARY_INTERVAL_MILLISECOND = 10000

        fun build(mainView: View, block: Builder.() -> Unit): GaYaSnackbar {
            return Builder(mainView).apply(block).build()
        }
    }

    class Builder(private val mainView: View) {
        var message: String = ""
        var title: String? = null
        var showTitle: Boolean = false
        var mainButtonAction: (() -> Unit)? = null
        var mainButtonTitle: String? = null
        var showIcon: Boolean = false
        var iconName: String? = null
        var iconButtonName: String? = null
        var colorType: GaYaSnackbarColorType? = null
        var positionType: GaYaSnackbarPositionType? = null
        var animation: Boolean = false
        var animationType: GaYaSnackbarAnimationtype? = null
        var timerType: GaYaSnackbarTimerType? = null
        var customTimerMillisecondInterval: Int? = null
        var actionButtonType: GaYaSnackbarActionButtonType? = null

        fun build(): GaYaSnackbar {
            return GaYaSnackbar(
                snackMainView = mainView,
                snackMessage = message,
                snackTitle = title,
                snackShowTitle = showTitle,
                snackMainButtonAction = mainButtonAction,
                snackMainButtonTitle = mainButtonTitle,
                showSnackIcon = showIcon,
                snackIconName = iconName,
                snackIconButtonName = iconButtonName,
                snackColorType = colorType,
                snackPositionType = positionType,
                snackAnimation = animation,
                snackAnimationType = animationType,
                snackTimerType = timerType,
                snackCustomTimerMillisecondInterval = customTimerMillisecondInterval,
                snackActionButtonType = actionButtonType
            )
        }
    }
}

fun showGaYaSnackbar(mainView: View, block: GaYaSnackbar.Builder.() -> Unit): GaYaSnackbar {
    val snackbar = GaYaSnackbar.build(mainView, block)
    snackbar.show()
    return snackbar
}

enum class GaYaSnackbarColorType {
    DEFAULT,
    SUCCESS,
    ERROR,
    WARNING,
    INFO
}

enum class GaYaSnackbarPositionType {
    TOP_CENTER,
    BOTTOM_CENTER
}

enum class GaYaSnackbarTimerType {
    MINIMUM,
    INTERMEDIARY,
    INDETERMINATE,
    CUSTOM
}

enum class GaYaSnackbarAnimationtype {
    NONE,
    CENTER,
    RIGHT,
    LEFT
}

enum class GaYaSnackbarActionButtonType {
    NONE,
    INLINE_BOTTON,
    BLOCK_BOTTON,
    ICON_BOTTON
}
