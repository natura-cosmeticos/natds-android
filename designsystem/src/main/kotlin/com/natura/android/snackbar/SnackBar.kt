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
import com.natura.android.databinding.SnackbarBinding
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getIconResourceIdFromName


class SnackBar private constructor(
    private val snackMainView: View,
    private val snackMessage: String,
    private val snackTitle: String? = null,
    private val snackShowTitle: Boolean = false,
    private val snackMainButtonAction: (() -> Unit)? = null,
    private val snackMainButtonTitle: String? = null,
    private val showSnackIcon: Boolean = false,
    private val snackIconName: String? = null,
    private val snackIconButtonName: String? = null,
    private val snackColorType: SnackbarColorType? = null,
    private val snackPositionType: SnackbarPositionType? = null,
    private val snackAnimation: Boolean = false,
    private val snackAnimationType: SnackbarAnimationtype? = null,
    private val snackTimerType: SnackbarTimerType? = null,
    private val snackCustomTimerMillisecondInterval: Int? = null,
    private val snackActionButtonType: SnackbarActionButtonType? = null
) {

    @JvmOverloads
    constructor(
        mainView: View,
        title: String,
        showTitle: Boolean,
        message: String,
        mainButtonTitle: String?,
        mainButtonAction: (() -> Unit)?,
        mainButtonType: SnackbarActionButtonType = SnackbarActionButtonType.INLINE_BOTTON,
        animation: Boolean = false,
        animationType: SnackbarAnimationtype? = null,
        timerType: SnackbarTimerType? = null,
        customTimerMillisecondInterval: Int? = null,
    ) : this(
        snackMainView = mainView,
        snackTitle = title,
        snackShowTitle = showTitle,
        snackMessage = message,
        snackMainButtonTitle = mainButtonTitle,
        snackMainButtonAction = mainButtonAction,
        snackActionButtonType = mainButtonType,
        snackAnimation = animation,
        snackAnimationType = animationType,
        snackTimerType = timerType,
        snackCustomTimerMillisecondInterval = customTimerMillisecondInterval
    )

    @JvmOverloads
    constructor(
        mainView: View,
        message: String,
        color: SnackbarColorType,
        iconName: String,
        showTitle: Boolean = false,
        animation: Boolean = false,
        positionType: SnackbarPositionType? = null,
        animationType: SnackbarAnimationtype? = null,
        timerType: SnackbarTimerType? = null,
        customTimerMillisecondInterval: Int? = null,
    ) : this(
        snackMainView = mainView,
        snackTitle = "",
        snackShowTitle = false,
        snackMessage = message,
        showSnackIcon = true,
        snackIconName = iconName,
        snackColorType = color,
        snackAnimation = animation,
        snackPositionType = positionType,
        snackAnimationType = animationType,
        snackTimerType = timerType,
        snackCustomTimerMillisecondInterval = customTimerMillisecondInterval
    )


    @JvmOverloads
    constructor(
        mainView: View,
        message: String,
        title: String = "",
        showTitle: Boolean = false,
        mainButtonAction: (() -> Unit)? = null,
        mainButtonTitle: String? = null,
        showIcon: Boolean = false,
        iconName: String? = null,
        iconButtonName: String? = null,
        positionType: SnackbarPositionType = SnackbarPositionType.BOTTOM_CENTER,
        animationType: SnackbarAnimationtype = SnackbarAnimationtype.NONE,
        timerType: SnackbarTimerType? = null,
        customTimerMillisecondInterval: Int? = null,
        mainButtonType: SnackbarActionButtonType = SnackbarActionButtonType.NONE,
        animation: Boolean = false
    ) : this(
        snackMainView = mainView,
        snackTitle = title,
        snackShowTitle = showTitle,
        snackMessage = message,
        snackMainButtonAction = mainButtonAction,
        snackMainButtonTitle = mainButtonTitle,
        showSnackIcon = showIcon,
        snackIconName = iconName,
        snackIconButtonName = iconButtonName,
        snackPositionType = positionType,
        snackAnimationType = animationType,
        snackTimerType = timerType,
        snackCustomTimerMillisecondInterval = customTimerMillisecondInterval,
        snackActionButtonType = mainButtonType,
        snackAnimation = animation,
    )

    private var snackbarBody: MaterialCardView? = null
    private var layoutBody: ConstraintLayout? = null
    private var popupWindow: PopupWindow? = null
    private var gravityPosition: Int = 0
    private var toolbarHeight: Int = 0
    private var timer: CountDownTimer? = null
    private var binding: SnackbarBinding? = null
    private var context: Context

    private val mainButtonClickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            popupWindow?.dismiss()
            snackMainButtonAction?.invoke()
        }
    }

    init {
        binding = SnackbarBinding.inflate(LayoutInflater.from(snackMainView.context))
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
        binding?.txtMessage?.text = snackMessage
        if (snackShowTitle) {
            binding?.txtTitle?.text = snackTitle
        } else {
            binding?.txtTitle?.visibility = View.GONE
        }
    }

    private fun setSnackIcon() {
        val titleIcon = binding?.ivTitleIcon
        val noTitleIcon = binding?.ivNoTitleIcon
        when (showSnackIcon) {
            true -> {
                if (snackTitle?.isNotEmpty() == true) {
                    titleIcon?.visibility = View.VISIBLE
                    noTitleIcon?.visibility = View.GONE
                } else {
                    titleIcon?.visibility = View.GONE
                    noTitleIcon?.visibility = View.VISIBLE
                }
            }
            false -> {
                titleIcon?.visibility = View.GONE
                noTitleIcon?.visibility = View.GONE
            }
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

        when (snackActionButtonType) {
            SnackbarActionButtonType.NONE -> {
                btnInline?.visibility = View.GONE
                btnBlock?.visibility = View.GONE
                btnIcon?.visibility = View.GONE
            }
            SnackbarActionButtonType.BLOCK_BOTTON -> {
                btnInline?.visibility = View.GONE
                btnBlock?.visibility = View.VISIBLE
                btnIcon?.visibility = View.GONE
            }
            SnackbarActionButtonType.INLINE_BOTTON -> {
                btnInline?.visibility = View.VISIBLE
                btnBlock?.visibility = View.GONE
                btnIcon?.visibility = View.GONE
            }
            SnackbarActionButtonType.ICON_BOTTON -> {
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
            SnackbarPositionType.TOP_CENTER -> {
                val location = IntArray(2)
                snackMainView?.getLocationOnScreen(location)
                toolbarHeight = location[1]
                gravityPosition = Gravity.TOP
            }
            else -> {
                gravityPosition = Gravity.BOTTOM
            }
        }
    }

    private fun setColorType() {
        when (snackColorType) {
            SnackbarColorType.SUCCESS,
            SnackbarColorType.DEFAULT,
            SnackbarColorType.ERROR,
            SnackbarColorType.WARNING,
            SnackbarColorType.INFO -> {
                binding?.txtTitle?.visibility = View.GONE
                binding?.ivTitleIcon?.visibility = View.GONE
                binding?.btnBlock?.visibility = View.GONE
                binding?.btnInline?.visibility = View.GONE
                binding?.btnIcon?.visibility = View.GONE
                binding?.ivNoTitleIcon?.visibility = View.VISIBLE
                binding?.txtMessage?.visibility = View.VISIBLE
            }
        }
    }

    private fun setAnimationtype() {

        if (snackAnimation) {
            when (snackAnimationType) {
                SnackbarAnimationtype.CENTER -> {
                    when (snackPositionType) {
                        SnackbarPositionType.TOP_CENTER -> popupWindow?.animationStyle =
                            R.style.SnackBarInOutFromTop
                        SnackbarPositionType.BOTTOM_CENTER -> popupWindow?.animationStyle =
                            (R.style.SnackBarInOutFromBottom)
                    }
                }
                SnackbarAnimationtype.LEFT -> popupWindow?.animationStyle =
                    R.style.SnackBarInLeftOutRight
                SnackbarAnimationtype.RIGHT -> popupWindow?.animationStyle =
                    R.style.SnackBarInRightOutLeft
            }
        }
    }

    private fun setTimerType() {
        when (snackTimerType) {
            null,
            SnackbarTimerType.MINIMUM -> {
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
            SnackbarTimerType.INTERMEDIARY -> {
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
            SnackbarTimerType.INDETERMINATE -> {
                snackbarBody?.setOnClickListener {
                    popupWindow?.dismiss()
                }
            }
            SnackbarTimerType.CUSTOM -> {
                snackCustomTimerMillisecondInterval?.let { timeout->
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
            SnackbarColorType.SUCCESS -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorSuccess)
                snackbarBody?.setCardBackgroundColor(getColorTokenFromTheme(context, R.attr.colorSuccess))
            }

            SnackbarColorType.ERROR -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorError)
                snackbarBody?.setCardBackgroundColor(getColorTokenFromTheme(context, R.attr.colorError))
            }

            SnackbarColorType.WARNING -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorWarning)
                snackbarBody?.setCardBackgroundColor(getColorTokenFromTheme(context, R.attr.colorWarning))

                binding?.txtMessage?.setTextColor(getColorTokenFromTheme(context, R.attr.colorOnWarning))
                binding?.ivNoTitleIcon?.backgroundTintList =
                    ColorStateList.valueOf(getColorTokenFromTheme(context, R.attr.colorOnWarning))
            }

            SnackbarColorType.INFO -> {
                snackbarBody?.strokeColor = getColorTokenFromTheme(context, R.attr.colorLink)
                snackbarBody?.setCardBackgroundColor(getColorTokenFromTheme(context, R.attr.colorLink))
            }

            else -> {
                snackbarBody?.strokeColor = parseStringColorToInt("#333333")
                snackbarBody?.setCardBackgroundColor(parseStringColorToInt("#333333"))
            }
        }
    }

    private fun parseStringColorToInt(color: String): Int {
        return Color.parseColor(color)
    }

    companion object {
        private const val MINIMUM_INTERVAL_MILLISECOND = 5000
        private const val INTERMEDIARY_INTERVAL_MILLISECOND = 10000
    }
}

enum class SnackbarColorType {
    DEFAULT,
    SUCCESS,
    ERROR,
    WARNING,
    INFO
}

enum class SnackbarPositionType {
    TOP_CENTER,
    BOTTOM_CENTER
}

enum class SnackbarTimerType {
    MINIMUM,
    INTERMEDIARY,
    INDETERMINATE,
    CUSTOM
}

enum class SnackbarAnimationtype {
    NONE,
    CENTER,
    RIGHT,
    LEFT
}

enum class SnackbarActionButtonType {
    NONE,
    INLINE_BOTTON,
    BLOCK_BOTTON,
    ICON_BOTTON
}
