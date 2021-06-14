package com.natura.android.appbartop

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.natura.android.R
import com.natura.android.extensions.setVisibilityFromBoolean
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.textfield.TextField

class StandardAppBarTop(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {

    private var typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.StandardAppBarTop)

    var barColor: Int = DEFAULT
        set(value) {
            field = value
            setColor(value)
        }

    var enabledElevation: Boolean = true
        set(value) {
            field = value
            setElevation(value)
        }

    private var contentType: Int = TEXT
    private var contentImage: Int? = null
    private var contentText: String? = ""
    private var actionRight: Boolean = false
    private var actionLeft: Boolean = false

    init {

        contentInsetStartWithNavigation = 0

        getAttributes()

        addContent()

        typedArray.recycle()
    }

    override fun addView(child: View?) {
        if (childCount > 5) {
            throw IllegalArgumentException("Standard App Bar Top can't have more than five elements (including the content)")
        }
        super.addView(child)
    }

    override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
        returnCountElementsException()
        super.addView(child, params)
    }

    override fun addView(child: View?, width: Int, height: Int) {
        returnCountElementsException()
        super.addView(child, width, height)
    }

    override fun addView(child: View?, index: Int) {
        returnCountElementsException()
        super.addView(child, index)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        returnCountElementsException()
        super.addView(child, index, params)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        resetProperties()
        positionActions()
        changeActionsVisibility()
        removeParentsElevation()
    }

    private fun changeActionsVisibility() {
        when {
            childCount == 2 -> setActionLeftVisibility()
            childCount > 2 -> {
                setActionLeftVisibility()
                setActionRightVisibility()
            }
        }
    }

    private fun setActionLeftVisibility() {
        getChildAt(1).setVisibilityFromBoolean(actionLeft)
    }

    private fun setActionRightVisibility() {
        for (i in SECOND_ELEMENT_INDEX_AFTER_CONTENT until childCount) {
            getChildAt(i).setVisibilityFromBoolean(actionRight)
        }
    }

    private fun positionActions() {
        when {
            childCount == 2 -> positionActionLeft()
            childCount > 2 -> {
                positionActionLeft()
                positionActionRight()
            }
        }
    }

    private fun positionActionLeft() {
        getChildAt(FIRST_ELEMENT_INDEX_AFTER_CONTENT).layoutParams = LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
            Gravity.CENTER_VERTICAL or Gravity.START
        )
    }

    private fun positionActionRight() {
        for (i in SECOND_ELEMENT_INDEX_AFTER_CONTENT until childCount) {
            getChildAt(i).layoutParams = LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER_VERTICAL or Gravity.END
            )
        }
    }

    private fun addContent() {
        when (contentType) {
            TEXT -> contentText?.let { addTextView(context, it) }
            MEDIA -> contentImage?.let { addImage(context, it) }
            SEARCH -> addTextField(context)
        }
    }

    private fun resetProperties() {
        title = ""
        navigationIcon = null
    }

    private fun getAttributes() {
        enabledElevation =
            typedArray.getBoolean(R.styleable.StandardAppBarTop_enabledElevation, true)
        barColor = typedArray.getInt(R.styleable.StandardAppBarTop_appBarColor, DEFAULT)
        contentType = typedArray.getInt(R.styleable.StandardAppBarTop_contentType, TEXT)
        contentImage = typedArray.getResourceId(R.styleable.StandardAppBarTop_contentMedia, 0)
        contentText = typedArray.getString(R.styleable.StandardAppBarTop_contentText)
        actionRight = typedArray.getBoolean(R.styleable.StandardAppBarTop_actionRight, false)
        actionLeft = typedArray.getBoolean(R.styleable.StandardAppBarTop_actionLeft, false)
    }

    private fun setColor(color: Int) {
        this.setBackgroundColor(
            when (color) {
                DEFAULT -> getColorTokenFromTheme(context, R.attr.colorSurface)
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorPrimary)
                INVERSE -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
                else -> Color.TRANSPARENT
            }
        )
    }

    private fun setElevation(value: Boolean) {
        if (value) {
            elevation = getElevationFromTheme(context)
        } else {
            this.elevation = 0F
        }
    }

    private fun getElevationFromTheme(context: Context): Float {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(R.attr.elevation02, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
                .toFloat()
        }

        return 0f
    }

    private fun removeParentsElevation() {
        if (parent is AppBarLayout) {

            val stateListAnimator = StateListAnimator()
            stateListAnimator.addState(
                IntArray(0),
                ObjectAnimator.ofFloat(this, "elevation", 0.1F)
            )
            (parent as AppBarLayout).stateListAnimator = stateListAnimator
        }
    }

    private fun returnCountElementsException() {
        if (childCount > LIMIT_ELEMENTS_APPBAR_CONTAINER) {
            throw IllegalArgumentException("Standard App Bar Top can't have more than five elements (including the content)")
        }
    }

    private fun addImage(context: Context, resourceImage: Int) {
        val imageView = ImageView(context)
        imageView.id = R.id.contentMedia
        imageView.setImageResource(resourceImage)
        imageView.layoutParams =
            LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                getLogoAlign(
                    context
                )
            )
        imageView.setPadding(
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0,
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0
        )
        addView(imageView)
    }

    private fun addTextView(context: Context, text: String) {
        val textView = TextView(context)
        textView.id = R.id.contentText
        textView.text = text
        textView.textSize = getDimenFromTheme(context, R.attr.heading6FontSize)
        textView.layoutParams =
            LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                getLogoAlign(
                    context
                )
            )
        textView.setPadding(
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0,
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0
        )

        addView(textView)
    }

    private fun addTextField(context: Context) {
        val textField = TextField(context)
        textField.id = R.id.contentSearch
        textField.layoutParams =
            LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                getLogoAlign(
                    context
                )
            )
        textField.setPadding(
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0,
            getDimenFromTheme(context, R.attr.spacingTiny).toInt(),
            0
        )
        addView(textField)
    }

    private fun getLogoAlign(context: Context): Int {
        return if (getWindowWidthInPx(context) < MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO) {
            Gravity.START
        } else {
            Gravity.CENTER
        }
    }

    private fun getWindowWidthInPx(context: Context): Int {

        return try {

            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val metrics = DisplayMetrics()

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                context.display?.getRealMetrics(metrics)
            } else {
                windowManager.defaultDisplay.getMetrics(metrics)
            }

            metrics.widthPixels
        } catch (ex: Exception) {
            MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO
        }
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3

        const val TEXT = 0
        const val MEDIA = 1
        const val SEARCH = 2

        private const val MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO = 361
        private const val LIMIT_ELEMENTS_APPBAR_CONTAINER = 5
        private const val FIRST_ELEMENT_INDEX_AFTER_CONTENT = 1
        private const val SECOND_ELEMENT_INDEX_AFTER_CONTENT = 2
    }
}
