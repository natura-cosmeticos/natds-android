package com.natura.android.appbartop

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.extensions.setVisibilityFromBoolean
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.textfield.TextField

class StandardAppBarTop(context: Context, attrs: AttributeSet) : AppBarLayout(context, attrs) {

    private var typedArray: TypedArray

    private var barColor: Int = DEFAULT
        set(value) {
            field = value
            setColor(value, context)
        }

    private var enabledElevation: Boolean = true
        set(value) {
            field = value
            setElevation(value)
        }

    private var scrollable: Boolean = false
        set(value) {
            field = value
            handleScroll(value)
        }

    private var contentType: Int = TEXT
    private var contentImage: Int? = null
    private var contentText: String? = ""
    private var actionRight: Boolean = false
    private var actionLeft: Boolean = false
    private var proeminentContent: Boolean = false
    private var contentPosition: Int = LEFT

    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    private val actionLeftContainer by lazy { findViewById<LinearLayout>(R.id.actionLeftContainer) }
    private val actionRightContainer by lazy { findViewById<LinearLayout>(R.id.actionRightContainer) }
    private val actionCenterContainer by lazy { findViewById<LinearLayout>(R.id.actionCenterContainer) }

    init {
        try {
            View.inflate(context, R.layout.standard_appbar_top, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.StandardAppBarTop)

        initialConfigurations()
        getAttributes()
        addContent()

        typedArray.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        resetProperties()
        positionActions()
        throwsCountElementsException()
        changeActionsVisibility()
        removeParentsElevation()
    }

    fun getColor(): Int {
        return barColor
    }

    fun getElevationEnabled(): Boolean {
        return enabledElevation
    }

    fun getScrollable(): Boolean {
        return scrollable
    }

    fun getActionRight(): Boolean {
        return actionRight
    }

    fun getActionLeft(): Boolean {
        return actionLeft
    }

    fun getProeminentContent(): Boolean {
        return proeminentContent
    }

    fun getContentPosition(): Int {
        return contentPosition
    }

    fun getContentText(): String? {
        return contentText
    }

    fun getContentImage(): Int? {
        return contentImage
    }

    fun getContentType(): Int {
        return contentType
    }

    private fun changeActionsVisibility() {
        actionRightContainer.setVisibilityFromBoolean(actionRight)
        actionLeftContainer.setVisibilityFromBoolean(actionLeft)
    }

    private fun positionActions() {
        when {
            childCount == COUNT_ELEMENTS_ONLY_ACTION_LEFT -> {
                positionActionLeft()
                actionRightContainer.setVisibilityFromBoolean(false)
            }
            childCount > COUNT_ELEMENTS_ONLY_ACTION_LEFT -> {
                positionActionLeft()
                positionActionRight()
            }
        }
        positionActionCenter()
    }

    private fun positionActionCenter() {
        val child = getChildAt(1)
        this.removeView(child)

        if (proeminentContent) {
            actionLeftContainer.addView(child)
            actionLeftContainer.layoutParams = LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                2.5F
            )
            actionLeftContainer.orientation = LinearLayout.VERTICAL
            actionCenterContainer.setVisibilityFromBoolean(false)
        } else {

            actionCenterContainer.gravity = getContentAlign(context)
            actionCenterContainer.addView(child)
        }
    }

    private fun positionActionLeft() {
        val child = getChildAt(ACTION_LEFT_ELEMENT_INDEX)
        this.removeView(child)
        actionLeftContainer.addView(child)
    }

    private fun positionActionRight() {
        while (haveChildrenToMove()) {
            val child = getNextChild()
            removeView(child)
            actionRightContainer.addView(child)
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
        toolbar.title = ""
        toolbar.navigationIcon = null
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
        scrollable = typedArray.getBoolean(R.styleable.StandardAppBarTop_scrollable, false)
        contentPosition = typedArray.getInt(R.styleable.StandardAppBarTop_contentPosition, LEFT)
        proeminentContent = typedArray.getBoolean(
            R.styleable.StandardAppBarTop_proeminentContent,
            false
        )
    }

    private fun setColor(color: Int, context: Context) {
        setBackgroundColor(Color.TRANSPARENT)

        toolbar.setBackgroundColor(
            when (color) {
                DEFAULT -> getColorTokenFromTheme(context, R.attr.colorSurface)
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorPrimary)
                INVERSE -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
                else -> Color.TRANSPARENT
            }
        )
    }

    private fun setElevation(enabledElevation: Boolean) {
        if (enabledElevation) {
            toolbar.elevation = getElevationFromTheme(context)
        } else {
            toolbar.elevation = 0F
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

    private fun handleScroll(scrollable: Boolean) {
        val params = toolbar.layoutParams as LayoutParams
        params.scrollFlags = when (scrollable) {
            true -> (LayoutParams.SCROLL_FLAG_SCROLL)
            false -> (LayoutParams.SCROLL_FLAG_NO_SCROLL)
        }
    }

    private fun removeParentsElevation() {
        val stListAnimator = StateListAnimator()
        stListAnimator.addState(
            IntArray(0),
            ObjectAnimator.ofFloat(this, "elevation", 0.1F)
        )
        stateListAnimator = stListAnimator
    }

    private fun throwsCountElementsException() {
        if (countElements() > MAX_COUNT_ELEMENTS) {
            throw IllegalArgumentException("Standard App Bar Top can't have more than five elements (including the content)")
        }
    }

    private fun initialConfigurations() {
        toolbar.contentInsetStartWithNavigation = 0
        clipToPadding = false
        clipChildren = false
    }

    private fun addImage(context: Context, resourceImage: Int) {
        val imageView = ImageView(context)
        imageView.id = R.id.contentMedia
        imageView.setImageResource(resourceImage)
        imageView.layoutParams =
            LayoutParams(
                WRAP_CONTENT,
                WRAP_CONTENT
            )
        addView(imageView)
    }

    private fun addTextView(context: Context, text: String) {
        val textView = TextView(context)
        textView.id = R.id.contentText
        textView.text = text
        textView.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            context.resources.getDimension(R.dimen.ds_size_h6)
        )
        textView.layoutParams =
            LayoutParams(
                WRAP_CONTENT,
                WRAP_CONTENT
            )
        textView.isSingleLine = false
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.setLines(1)

        addView(textView)
    }

    private fun addTextField(context: Context) {
        val textField = TextField(context)
        textField.id = R.id.contentSearch
        textField.layoutParams =
            LayoutParams(
                MATCH_PARENT,
                WRAP_CONTENT
            )
        addView(textField)
    }

    private fun getContentAlign(context: Context): Int {
        return if ((getWindowWidthInPx(context) < MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO) || (contentPosition == LEFT)) {
            Gravity.START
        } else {
            Gravity.CENTER
        }
    }

    private fun haveChildrenToMove(): Boolean = getChildAt(ACTION_RIGHT_FIRST_ELEMENT_INDEX) != null

    private fun getNextChild(): View? = getChildAt(ACTION_RIGHT_FIRST_ELEMENT_INDEX)

    private fun countElements(): Int {
        return actionCenterContainer.childCount + actionRightContainer.childCount + actionLeftContainer.childCount
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

        const val LEFT = 0
        const val CENTER = 1

        private const val MINIMUM_SCREEN_SIZE_FOR_CENTRALIZED_LOGO = 361
        private const val MAX_COUNT_ELEMENTS = 5
        private const val COUNT_ELEMENTS_ONLY_ACTION_LEFT = 3
        private const val ACTION_LEFT_ELEMENT_INDEX = 2
        private const val ACTION_RIGHT_FIRST_ELEMENT_INDEX = 2
    }
}
