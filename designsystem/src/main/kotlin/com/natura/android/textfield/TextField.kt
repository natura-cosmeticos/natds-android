package com.natura.android.textfield

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.os.Parcel
import android.os.Parcelable
import android.text.InputFilter
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.icon.FontIcon
import com.natura.android.iconButton.IconButton
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme

@SuppressLint("CustomViewStyleable")
open class TextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var typedArray: TypedArray

    enum class State {
        NONE, ERROR, SUCCESS
    }

    class LayoutStates(val context: Context) {
        private val colorPrimary = getColorTokenFromTheme(context, R.attr.colorPrimary)
        private val colorError = getColorTokenFromTheme(context, R.attr.colorError)
        private val colorSuccess = getColorTokenFromTheme(context, R.attr.colorSuccess)
        private val colorLowEmphasis = getColorTokenFromTheme(context, R.attr.colorLowEmphasis)
        private val colorMediumEmphasis =
            getColorTokenFromTheme(context, R.attr.colorMediumEmphasis)
        private val colorHighEmphasis = getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
        private val colorLowEmphasisOpacityDisabledLow = getColorTokenFromTheme(context, R.attr.colorLowEmphasisOpacityDisabledLow)
        private val colorHighLightOpacityFull = getColorTokenFromTheme(context, R.attr.colorHighLightOpacityFull)

        data class LayoutState(
            val borderWidth: Int,
            val borderColor: Int,
            val labelColor: Int,
            val textColor: Int,
            val footerColor: Int,
            val hintColor: Int,
            val backgroundColor: Int
        )

        val DEFAULT = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val FILLED = LayoutState(
            R.dimen.ds_border_tiny,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val DISABLED = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorHighLightOpacityFull
        )
        val FOCUSED = LayoutState(
            R.dimen.ds_border_emphasis,
            colorPrimary,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val ERROR = LayoutState(
            R.dimen.ds_border_emphasis,
            colorError,
            colorError,
            colorHighEmphasis,
            colorError,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val SUCCESS = LayoutState(
            R.dimen.ds_border_tiny,
            colorSuccess,
            colorSuccess,
            colorHighEmphasis,
            colorSuccess,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )

        val READ_ONLY = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorLowEmphasisOpacityDisabledLow
        )

        val READ_ONLY_FOCUSED = LayoutState(
            R.dimen.ds_border_emphasis,
            colorPrimary,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorLowEmphasisOpacityDisabledLow
        )
    }

    var stateLayout = LayoutStates(context)

    private val SUCCESS_ICON = "EA15"
    private val ERROR_ICON = "EA13"

    private val inputLabel by lazy { findViewById<TextView>(R.id.text_field_input_label) }

    private val inputBox by lazy { findViewById<LinearLayout>(R.id.text_field_input_box) }
    private val inputValue by lazy { findViewById<EditText>(R.id.text_field_input_value) }
    private val inputIconButton by lazy { findViewById<IconButton>(R.id.text_field_input_icon) }
    private val inputContainerMain by lazy { findViewById<ConstraintLayout>(R.id.text_field_input_main) }
    private val inputImage by lazy { findViewById<ImageView>(R.id.text_field_input_image) }

    private val footerBox by lazy { findViewById<ConstraintLayout>(R.id.text_field_input_footer_box) }
    private val footerValue by lazy { findViewById<TextView>(R.id.text_field_input_footer) }
    private val footerIcon by lazy { findViewById<FontIcon>(R.id.text_field_input_footer_icon) }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        inputLabel?.isEnabled = enabled
        inputValue?.isEnabled = enabled
        inputIconButton?.isEnabled = enabled
        inputImage?.isEnabled = enabled
        footerIcon?.isEnabled = enabled
        footerValue?.isEnabled = enabled

        state = when (enabled) {
            false -> State.NONE
            true -> state
        }

        resetLayoutState()
    }

    val editTextView: EditText
        get() {
            return inputValue
        }

    var inputType: Int = EditorInfo.TYPE_CLASS_TEXT
        set(value) {
            field = value
            inputValue?.inputType = value
            inputValue?.setSelection(inputValue?.text?.length ?: 0)
        }

    var hint: String? = null
        set(value) {
            field = value
            inputValue.hint = value
        }

    var required: Boolean = false
        set(value) {
            field = value
        }

    var size: Int = MEDIUMX
        set(value) {
            field = value
            configureSize()
        }

    var maxLength: Int = 0
        set(value) {
            field = value

            val fArray = arrayOfNulls<InputFilter>(1)
            fArray[0] = InputFilter.LengthFilter(value)
            inputValue.filters = fArray
        }

    var maxLines: Int = 0
        set(value) {
            field = value
            inputValue.maxLines = value
        }

    var lines: Int = 0
        set(value) {
            field = value
            if (isMultilineType()) {
                inputValue.setLines(value)
            }
        }

    var text: String? = null
        set(value) {
            field = value
            inputValue.setText(value)
            resetLayoutState()
        }
        get() {
            return inputValue.text.toString()
        }

    var iconButton: String? = null
        set(value) {
            field = value
            changeVisibility(inputImage, false)
            inputIconButton.setIcon(iconButton)
            changeVisibilityByValue(inputIconButton, value)
        }

    var image: Int = 0
        set(value) {
            field = value
            if (value != 0) {
                changeVisibility(inputIconButton, false)
                inputImage.setImageResource(value)
                inputImage.visibility = View.VISIBLE
            }
        }

    var label: String? = null
        set(value) {
            field = value
            setTextLabel(value)
            changeVisibilityByValue(inputLabel, value)
        }

    var footer: String? = null
        set(value) {
            field = value
            footerValue.text = value
            changeVisibilityByValue(footerBox, value)
        }

    var layoutState = stateLayout.DEFAULT
        private set(value) {
            field = value
            inputLabel?.setTextColor(value.labelColor)
            (inputBox.background as GradientDrawable).setStroke(
                resources.getDimension(value.borderWidth).toInt(),
                value.borderColor
            )
            footerValue?.setTextColor(value.footerColor)
            (inputBox.background as GradientDrawable).setColor(value.backgroundColor)
            footerIcon?.setTextColor(value.footerColor)
            inputValue?.setHintTextColor(value.hintColor)
        }

    var state: State = State.NONE
        set(value) {
            field = value
            resetLayoutState()
            if (isEnabled) {
                when (value) {
                    State.ERROR -> {
                        setFooterIcon(ERROR_ICON, View.VISIBLE)
                    }
                    State.SUCCESS -> {
                        setFooterIcon(SUCCESS_ICON, View.VISIBLE)
                    }
                    else -> {
                        setFooterIcon("", View.GONE)
                    }
                }
            } else {
                setFooterIcon("", View.GONE)
            }
        }

    var error: String? = null
        set(value) {
            field = value
            if (isEnabled) {
                footer = value
                state = if (value != null) {
                    State.ERROR
                } else {
                    State.NONE
                }
            }
        }

    var readOnly: Boolean = false
        set(value) {
            field = value
            configureReadOnly(value)
            resetLayoutState()
        }

    fun setOnIconClickListener(l: OnClickListener?) {
        inputIconButton?.setOnClickListener(l)
    }

    init {
        this.let {
            View.inflate(context, R.layout.ds_text_field_input, it)
        }

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_text_field_input)

        getAtributes()

        inputValue.setOnFocusChangeListener { _, hasFocus -> onFocusChanged(hasFocus) }
        inputIconButton.setOnClickListener { onFocusChanged(true) }

        inputContainerMain.setOnClickListener {
            inputValue.requestFocus()
        }

        typedArray.recycle()
    }

    private fun getAtributes() {
        inputType = typedArray.getInteger(
            R.styleable.ds_text_field_input_android_inputType,
            EditorInfo.TYPE_CLASS_TEXT
        )
        hint = typedArray.getString(R.styleable.ds_text_field_input_android_hint)
        maxLines = typedArray.getInteger(R.styleable.ds_text_field_input_android_maxLines, 1)
        maxLength = typedArray.getInteger(
            R.styleable.ds_text_field_input_android_maxLength,
            Integer.MAX_VALUE
        )
        lines = typedArray.getInteger(R.styleable.ds_text_field_input_android_lines, 1)
        isEnabled = typedArray.getBoolean(R.styleable.ds_text_field_input_android_enabled, true)
        required = typedArray.getBoolean(R.styleable.ds_text_field_input_text_field_required, false)
        size = typedArray.getInt(R.styleable.ds_text_field_input_text_field_size, MEDIUMX)
        text = typedArray.getString(R.styleable.ds_text_field_input_text_field_text)
        label = typedArray.getString(R.styleable.ds_text_field_input_text_field_label)
        footer = typedArray.getString(R.styleable.ds_text_field_input_text_field_footer)
        iconButton = typedArray.getString(R.styleable.ds_text_field_input_text_field_icon)
        image = typedArray.getResourceId(R.styleable.ds_text_field_input_text_field_image, 0)
        state = intToState(typedArray.getInt(R.styleable.ds_text_field_input_text_field_state, 0))
        readOnly = typedArray.getBoolean(R.styleable.ds_text_field_input_text_field_readonly, false)
    }

    private fun resetLayoutState() {
        layoutState = if (isEnabled) {
            when (state) {
                State.ERROR -> stateLayout.ERROR
                State.SUCCESS -> stateLayout.SUCCESS
                else -> {
                    when {
                        readOnly -> stateLayout.READ_ONLY
                        inputContainerMain.isFocused -> stateLayout.FOCUSED
                        inputValue.text.isNotEmpty() -> stateLayout.FILLED
                        else -> stateLayout.DEFAULT
                    }
                }
            }
        } else {
            stateLayout.DISABLED
        }
    }

    private fun setFooterIcon(value: String, visibility: Int) {
        footerIcon.text = value
        footerIcon.visibility = visibility
    }

    private fun changeVisibilityByValue(view: View, value: String?) {
        if (value == null || value.isEmpty()) view.visibility = View.GONE
        else view.visibility = View.VISIBLE
    }

    private fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = when (visible) { true -> View.VISIBLE false -> View.GONE }
    }

    private fun intToState(vstate: Int) = when (vstate) {
        1 -> State.SUCCESS
        2 -> State.ERROR
        else -> State.NONE
    }

    private fun onFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            layoutState = when (readOnly) {
                true -> stateLayout.READ_ONLY_FOCUSED
                false -> stateLayout.FOCUSED
            }
        } else {
            resetLayoutState()
        }
    }

    private fun setTextLabel(label: String?) {
        if (required && !label.isNullOrEmpty()) {
            inputLabel.text = "$label*"
            return
        }
        inputLabel.text = label
    }

    private fun isMultilineType(): Boolean {
        if (inputType == MULTILINE_TYPE) {
            return true
        }

        return false
    }

    private fun configureSize() {
        val textFieldBoxLayoutParams = inputBox.layoutParams

        if (!isMultilineType()) {
            when (size) {
                MEDIUM -> {
                    textFieldBoxLayoutParams.height =
                        getDimenFromTheme(context, R.attr.sizeMedium).toInt()
                    inputBox.setPadding(
                        inputBox.paddingLeft,
                        MEDIUM_PADDING_TOP,
                        inputBox.paddingRight,
                        MEDIUM_PADDING_BOTTOM
                    )
                }
                else -> {
                    textFieldBoxLayoutParams.height =
                        getDimenFromTheme(context, R.attr.sizeMediumX).toInt()
                    inputBox.setPadding(
                        inputBox.paddingLeft,
                        MEDIUMX_PADDING_TOP,
                        inputBox.paddingRight,
                        MEDIUMX_PADDING_BOTTOM
                    )
                }
            }

            inputBox.layoutParams = textFieldBoxLayoutParams
        }
    }

    private fun configureReadOnly(enabled: Boolean) {
        if (enabled) {
            editTextView.keyListener = null
        }

        editTextView.setTextIsSelectable(enabled)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return SavedState(super.onSaveInstanceState()).apply {
            childrenStates = saveChildViewStates()
        }
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        when (state) {
            is SavedState -> {
                super.onRestoreInstanceState(state.superState)
                state.childrenStates?.let { restoreChildViewStates(it) }
            }
            else -> super.onRestoreInstanceState(state)
        }
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {
        dispatchThawSelfOnly(container)
    }

    internal class SavedState : BaseSavedState {

        internal var childrenStates: SparseArray<Parcelable>? = null

        constructor(superState: Parcelable?) : super(superState)

        constructor(source: Parcel) : super(source) {
            childrenStates = source.readSparseArray(javaClass.classLoader)
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeSparseArray(childrenStates)
        }

        companion object CREATOR : Parcelable.Creator<SavedState> {
            override fun createFromParcel(source: Parcel) = SavedState(source)
            override fun newArray(size: Int): Array<SavedState?> = arrayOfNulls(size)
        }
    }

    private fun ViewGroup.saveChildViewStates(): SparseArray<Parcelable> {
        val childViewStates = SparseArray<Parcelable>()
        getChildren().forEach { child -> child.saveHierarchyState(childViewStates) }
        return childViewStates
    }

    private fun ViewGroup.restoreChildViewStates(childViewStates: SparseArray<Parcelable>) {
        getChildren().forEach { child -> child.restoreHierarchyState(childViewStates) }
    }

    private fun ViewGroup.getChildren(): List<View> {
        val children = mutableListOf<View>()
        (0 until childCount).forEach {
            children.add(getChildAt(it))
        }
        return children
    }

    companion object {
        const val MEDIUM = 0
        const val MEDIUMX = 1
        const val MEDIUM_PADDING_TOP = 14
        const val MEDIUM_PADDING_BOTTOM = 13
        const val MEDIUMX_PADDING_TOP = 18
        const val MEDIUMX_PADDING_BOTTOM = 17
        const val MULTILINE_TYPE = 131073
    }
}
