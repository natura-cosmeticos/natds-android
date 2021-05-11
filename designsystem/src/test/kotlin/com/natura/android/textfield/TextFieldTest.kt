package com.natura.android.textfield

import android.app.Activity
import android.text.InputFilter
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import com.natura.android.icon.FontIcon
import com.natura.android.icon.toIcon
import com.natura.android.iconButton.IconButton
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
class TextFieldTest {

    val activityController = Robolectric.buildActivity(Activity::class.java)
    lateinit var textField: TextField

    val EMPTY_TEXT = ""
    val NOT_EMPTY_TEXT = "test"
    val NOT_EMPTY_TEXT_REQUIRED = "test*"
    val ERROR_ICON_CODE = "EA13"
    val SUCCESS_ICON_CODE = "EA15"
    val MULTILINE_TYPE = 131073

    @Before
    fun setup() {
        activityController.get().setTheme(R.style.Theme_Natura_Light)
        textField = TextField(activityController.get())
    }

    @Test
    fun basicLayout() {
        val layout = LayoutInflater.from(activityController.get())
            .inflate(R.layout.ds_text_field_input, null) as ConstraintLayout

        assertThat(layout.findViewById(R.id.text_field_input_label) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_value) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_icon) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_footer) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_footer_icon) as View).isNotNull()
    }

    @Test
    fun basicConstructor_NoStyledAttributes() {
        assertThat(textField.label).isNull()
        assertThat(textField.text).isEmpty()
        assertThat(textField.editTextView).isNotNull()
        assertThat(textField.footer).isNull()
        assertThat(textField.iconButton).isNull()
        assertThat(textField.image).isNotNull()
        assertThat(textField.state).isEqualTo(TextField.State.NONE)
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.DEFAULT)
        assertThat(textField.inputType).isEqualTo(InputType.TYPE_CLASS_TEXT)
        assertThat(textField.hint).isNull()
        assertThat(textField.lines).isEqualTo(1)
        assertThat(textField.maxLength).isEqualTo(Integer.MAX_VALUE)
        assertThat(textField.maxLength).isEqualTo(Integer.MAX_VALUE)
    }

    @Test
    fun textEditTextView() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        assertThat(textField.editTextView).isEqualTo(textView)
    }

    @Test
    fun setText_NullValue() {
        test_setText(null, EMPTY_TEXT, textField.stateLayout.DEFAULT)
    }

    @Test
    fun setText_EmptyValue() {
        test_setText(EMPTY_TEXT, EMPTY_TEXT, textField.stateLayout.DEFAULT)
    }

    @Test
    fun setText_NoEmptyValue() {
        test_setText(NOT_EMPTY_TEXT, NOT_EMPTY_TEXT, textField.stateLayout.FILLED)
    }

    private fun test_setText(
        value: String?,
        expectedValue: String,
        expectedLayout: TextField.LayoutStates.LayoutState
    ) {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.text = value
        assertThat(textField.text).isEqualTo(expectedValue)
        assertThat(textView.text.toString()).isEqualTo(expectedValue)
        assertThat(textField.layoutState).isEqualTo(expectedLayout)
    }

    @Test
    fun setLabel_NullValue() {
        test_setLabel(null, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setLabel_EmptyValue() {
        test_setLabel(EMPTY_TEXT, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setLabel_NoEmptyValue() {
        test_setLabel(NOT_EMPTY_TEXT, NOT_EMPTY_TEXT, View.VISIBLE)
    }

    @Test
    fun setLabel_FieldIsRequired() {
        val labelView = textField.findViewById(R.id.text_field_input_label) as TextView

        textField.required = true
        textField.label = NOT_EMPTY_TEXT
        assertThat(labelView.text.toString()).isEqualTo(NOT_EMPTY_TEXT_REQUIRED)
    }

    @Test
    fun setLabel_FieldIsNotRequired() {
        val labelView = textField.findViewById(R.id.text_field_input_label) as TextView

        textField.required = false
        textField.label = NOT_EMPTY_TEXT
        assertThat(labelView.text.toString()).isEqualTo(NOT_EMPTY_TEXT)
    }

    private fun test_setLabel(value: String?, expectedValue: String, expectedVisibility: Int) {
        val labelView = textField.findViewById(R.id.text_field_input_label) as TextView

        textField.label = value
        assertThat(labelView.text.toString()).isEqualTo(expectedValue)
        assertThat(labelView.visibility).isEqualTo(expectedVisibility)
    }

    @Test
    fun checkIconButtonVisibilityIfAttributeIsNull() {
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton

        textField.iconButton = null

        assertThat(iconView.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun checkIconButtonVisibilityIfAttributeIsEmpty() {
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton

        textField.iconButton = ""

        assertThat(iconView.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun checkIconButtonVisibilityIfAttributeIsSet() {
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton

        textField.iconButton = "outlined-default-mockup"

        val iconShadow = Shadows.shadowOf(iconView.getIcon().drawable)

        assertThat(iconShadow.createdFromResId).isEqualTo(R.drawable.default_icon_outlined_default_mockup)
        assertThat(iconView.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun checkImageVisibilityIfAttributeIsNull() {
        val imageView = textField.findViewById(R.id.text_field_input_image) as ImageView

        textField.image = 0

        assertThat(imageView.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun checkImageVisibilityIfAttributeIsSet() {
        val imageView = textField.findViewById(R.id.text_field_input_image) as ImageView

        textField.image = R.drawable.logo_placeholder

        val imageShadow = Shadows.shadowOf(imageView.drawable)

        assertThat(imageShadow.createdFromResId).isEqualTo(R.drawable.logo_placeholder)
        assertThat(imageView.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun setFooter_NullValue() {
        test_setFooter(null, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setFooter_EmptyValue() {
        test_setFooter(EMPTY_TEXT, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setFooter_NoEmptyValue() {
        test_setFooter(NOT_EMPTY_TEXT, NOT_EMPTY_TEXT, View.VISIBLE)
    }

    private fun test_setFooter(value: String?, expectedValue: String, expectedVisibility: Int) {
        val footerView = textField.findViewById(R.id.text_field_input_footer) as TextView
        val footerBoxView = textField.findViewById(R.id.text_field_input_footer_box) as View

        textField.footer = value
        assertThat(footerView.text.toString()).isEqualTo(expectedValue)
        assertThat(footerBoxView.visibility).isEqualTo(expectedVisibility)
    }

    @Test
    fun setError_NullValue() {
        test_seError(null, EMPTY_TEXT, View.GONE, EMPTY_TEXT)
    }

    @Test
    fun setError_NoEmptyValue() {
        test_seError(NOT_EMPTY_TEXT, NOT_EMPTY_TEXT, View.VISIBLE, ERROR_ICON_CODE.toIcon())
    }

    private fun test_seError(
        value: String?,
        expectedValue: String,
        expectedVisibility: Int,
        expectedIcon: String
    ) {
        val footerView = textField.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textField.findViewById(R.id.text_field_input_footer_icon) as FontIcon
        val footerBoxView = textField.findViewById(R.id.text_field_input_footer_box) as View

        textField.error = value
        assertThat(footerView.text.toString()).isEqualTo(expectedValue)
        assertThat(footerIconView.text).isEqualTo(expectedIcon)
        assertThat(footerIconView.visibility).isEqualTo(expectedVisibility)
        assertThat(footerBoxView.visibility).isEqualTo(expectedVisibility)
    }

    @Test
    fun setState_None() {
        test_setState(TextField.State.NONE, textField.stateLayout.DEFAULT, View.GONE, "")
    }

    @Test
    fun setState_Error() {
        test_setState(
            TextField.State.ERROR,
            textField.stateLayout.ERROR,
            View.VISIBLE,
            ERROR_ICON_CODE.toIcon()
        )
    }

    @Test
    fun setState_Success() {
        test_setState(
            TextField.State.SUCCESS,
            textField.stateLayout.SUCCESS,
            View.VISIBLE,
            SUCCESS_ICON_CODE.toIcon()
        )
    }

    private fun test_setState(
        state: TextField.State,
        expectedLayoutState: TextField.LayoutStates.LayoutState,
        expectedIconVisibility: Int,
        expectedIconValue: String
    ) {
        val labelView = textField.findViewById(R.id.text_field_input_label) as TextView
        val footerView = textField.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textField.findViewById(R.id.text_field_input_footer_icon) as FontIcon

        textField.state = state

        assertThat(textField.layoutState).isEqualTo(expectedLayoutState)
        assertThat(labelView.currentTextColor).isEqualTo(expectedLayoutState.labelColor)
        assertThat(footerView.currentTextColor).isEqualTo(expectedLayoutState.footerColor)
        assertThat(footerIconView.currentTextColor).isEqualTo(expectedLayoutState.footerColor)
        assertThat(footerIconView.visibility).isEqualTo(expectedIconVisibility)
        assertThat(footerIconView.text).isEqualTo(expectedIconValue)
    }

    @Test
    fun setInputType() {
        val expectedValue = InputType.TYPE_TEXT_VARIATION_PASSWORD
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.inputType = expectedValue
        assertThat(textView.inputType).isEqualTo(expectedValue)
    }

    @Test
    fun setHint() {
        val expectedValue = "test"
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.hint = expectedValue
        assertThat(textView.hint).isEqualTo(expectedValue)
    }

    @Test
    fun setLines() {
        val expectedValue = 5
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.inputType = MULTILINE_TYPE
        textField.lines = expectedValue
        assertThat(textView.maxLines).isEqualTo(expectedValue)
        assertThat(textView.minLines).isEqualTo(expectedValue)
    }

    @Test
    fun setMaxLines() {
        val expectedValue = 5
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.lines = expectedValue
        textField.maxLines = expectedValue
        assertThat(textView.maxLines).isEqualTo(expectedValue)
    }

    @Test
    fun setMaxLength() {
        val expectedValue = 5
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.maxLength = expectedValue
        assertThat((textView.filters[0] as InputFilter.LengthFilter).max).isEqualTo(expectedValue)
    }

    @Test
    fun onRequestFocus_ChangeToFocusColor() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textView.requestFocus()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.FOCUSED)
    }

    @Test
    fun onClearFocus_ChangeToDefaultColor() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textView.requestFocus()
        textView.clearFocus()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.DEFAULT)
    }

    @Test
    fun onClearFocus_ChangeToErrorColor() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.state = TextField.State.ERROR
        textView.requestFocus()
        textView.clearFocus()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.ERROR)
    }

    @Test
    fun onClearFocus_ChangeToSuccessColor() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText

        textField.state = TextField.State.SUCCESS
        textView.requestFocus()
        textView.clearFocus()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.SUCCESS)
    }

    @Test
    fun onClickIcon_CallListener() {
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton
        var clicked = false

        textField.setOnIconClickListener {
            clicked = true
        }
        iconView.performClick()
        assertThat(clicked).isTrue()
    }

    @Test
    fun onClickImage_CallListener() {
        val imageView = textField.findViewById(R.id.text_field_input_image) as ImageView
        var clicked = false

        textField.setOnImageClickListener() {
            clicked = true
        }
        imageView.performClick()
        assertThat(clicked).isTrue()
    }

    @Test
    fun onClickIcon_ChangeToFocusColor() {
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton

        textField.isEnabled = true
        iconView.performClick()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.FOCUSED)
    }

    @Test
    fun onClickImage_ChangeToFocusColor() {
        val imageView = textField.findViewById(R.id.text_field_input_image) as ImageView

        textField.isEnabled = true
        imageView.performClick()
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.FOCUSED)
    }

    @Test
    fun setIsEnabledFalse_ChangeToDisabledColor() {
        textField.isEnabled = false

        assertChildsEnabled(false)
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.DISABLED)

        textField.isEnabled = true
    }

    @Test
    fun checkLabelColorWhenTextfieldIsReadOnly() {
        textField.readOnly = true
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.READ_ONLY)
    }

    @Test
    fun checkLabelColorWhenTextfieldIsDisabled() {
        val footerView = textField.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textField.findViewById(R.id.text_field_input_footer_icon) as FontIcon

        textField.isEnabled = false
        textField.state = TextField.State.SUCCESS

        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.DISABLED)
        assertThat(footerView.currentTextColor).isNotEqualTo(textField.stateLayout.SUCCESS.footerColor)
        assertThat(footerIconView.currentTextColor).isNotEqualTo(textField.stateLayout.SUCCESS.footerColor)
    }

    @Test
    fun setIsEnabledTrue_ChangeToDefaultColor() {
        textField.isEnabled = true
        assertChildsEnabled(true)
        assertThat(textField.layoutState).isEqualTo(textField.stateLayout.DEFAULT)
    }

    @Test
    fun testFocusWhenBoxIsClicked() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText
        val textBoxView = textField.findViewById(R.id.text_field_input_main) as View

        textBoxView.callOnClick()
        assertThat(textView.isFocused).isTrue()
    }

    @Config(sdk = [28])
    @Test
    fun testNoFocusWhenBoxIsClickedButIsDisabled() {
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText
        val textBoxView = textField.findViewById(R.id.text_field_input_main) as View
        textField.isEnabled = false

        textBoxView.callOnClick()
        assertThat(textView.isFocused).isFalse()

        textField.isEnabled = true
    }

    private fun assertChildsEnabled(enabled: Boolean) {
        val labelView = textField.findViewById(R.id.text_field_input_label) as TextView
        val textView = textField.findViewById(R.id.text_field_input_value) as EditText
        val iconView = textField.findViewById(R.id.text_field_input_icon) as IconButton
        val footerView = textField.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textField.findViewById(R.id.text_field_input_footer_icon) as FontIcon
        assertThat(labelView.isEnabled).isEqualTo(enabled)
        assertThat(textView.isEnabled).isEqualTo(enabled)
        assertThat(iconView.isEnabled).isEqualTo(enabled)
        assertThat(footerView.isEnabled).isEqualTo(enabled)
        assertThat(footerIconView.isEnabled).isEqualTo(enabled)
    }
}
