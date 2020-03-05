package com.natura.android.textfield

import android.app.Activity
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.text.InputFilter
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import com.natura.android.icon.FontIcon
import com.natura.android.icon.toIcon
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk=[28])
class TextFieldInputTest {

    val activityController = Robolectric.buildActivity(Activity::class.java)
    val textFieldInput = TextFieldInput(activityController.get())

    val EMPTY_TEXT = ""
    val NOT_EMPTY_TEXT = "test"
    val ERROR_ICON_CODE = "EA13"
    val SUCCESS_ICON_CODE = "EA1A"

    @Test
    fun basicLayout() {
        val layout = LayoutInflater.from(activityController.get()).inflate(R.layout.ds_text_field_input, null) as ConstraintLayout

        assertThat(layout.findViewById(R.id.text_field_input_label) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_value) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_icon) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_footer) as View).isNotNull()
        assertThat(layout.findViewById(R.id.text_field_input_footer_icon) as View).isNotNull()
    }

    @Test
    fun basicConstructor_NoStyledAttributes() {
        assertThat(textFieldInput.label).isNull()
        assertThat(textFieldInput.text).isNull()
        assertThat(textFieldInput.footer).isNull()
        assertThat(textFieldInput.icon).isNull()
        assertThat(textFieldInput.state).isEqualTo(TextFieldInput.State.NONE)
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorHighEmphasis_48))
        assertThat(textFieldInput.inputType).isEqualTo(InputType.TYPE_CLASS_TEXT)
        assertThat(textFieldInput.hint).isNull()
        assertThat(textFieldInput.lines).isEqualTo(1)
        assertThat(textFieldInput.maxLength).isEqualTo(Integer.MAX_VALUE)
        assertThat(textFieldInput.maxLength).isEqualTo(Integer.MAX_VALUE)
    }

    @Test
    fun setText_NullValue() {
        test_setText(null, EMPTY_TEXT, View.VISIBLE)
    }

    @Test
    fun setText_EmptyValue() {
        test_setText(EMPTY_TEXT, EMPTY_TEXT, View.VISIBLE)
    }

    @Test
    fun setText_NoEmptyValue() {
        test_setText(NOT_EMPTY_TEXT, NOT_EMPTY_TEXT, View.VISIBLE)
    }

    private fun test_setText(value: String?, expectedValue: String, expectedVisibility: Int) {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.text = value
        assertThat(textView.text.toString()).isEqualTo(expectedValue)
        assertThat(textView.visibility).isEqualTo(expectedVisibility)
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

    private fun test_setLabel(value: String?, expectedValue: String, expectedVisibility: Int) {
        val labelView = textFieldInput.findViewById(R.id.text_field_input_label) as TextView

        textFieldInput.label = value
        assertThat(labelView.text.toString()).isEqualTo(expectedValue)
        assertThat(labelView.visibility).isEqualTo(expectedVisibility)
    }

    @Test
    fun setIcon_NullValue() {
        test_setIcon(null, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setIcon_EmptyValue() {
        test_setIcon(EMPTY_TEXT, EMPTY_TEXT, View.GONE)
    }

    @Test
    fun setIcon_NoEmptyValue() {
        test_setIcon(ERROR_ICON_CODE, ERROR_ICON_CODE.toIcon(), View.VISIBLE)
    }

    private fun test_setIcon(value: String?, expectedValue: String, expectedVisibility: Int) {
        val iconView = textFieldInput.findViewById(R.id.text_field_input_icon) as FontIcon

        textFieldInput.icon = value
        assertThat(iconView.text.toString()).isEqualTo(expectedValue)
        assertThat(iconView.visibility).isEqualTo(expectedVisibility)
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
        val footerView = textFieldInput.findViewById(R.id.text_field_input_footer) as TextView
        val footerBoxView = textFieldInput.findViewById(R.id.text_field_input_footer_box) as View

        textFieldInput.footer = value
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

    private fun test_seError(value: String?, expectedValue: String, expectedVisibility: Int,
                             expectedIcon: String) {
        val footerView = textFieldInput.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textFieldInput.findViewById(R.id.text_field_input_footer_icon) as FontIcon
        val footerBoxView = textFieldInput.findViewById(R.id.text_field_input_footer_box) as View

        textFieldInput.error = value
        assertThat(footerView.text.toString()).isEqualTo(expectedValue)
        assertThat(footerIconView.text).isEqualTo(expectedIcon)
        assertThat(footerIconView.visibility).isEqualTo(expectedVisibility)
        assertThat(footerBoxView.visibility).isEqualTo(expectedVisibility)
    }

    @Test
    fun setState_None() {
        val expectedStatusColor = getColor(R.color.colorHighEmphasis_48)
        test_setState(TextFieldInput.State.NONE, expectedStatusColor, View.GONE, "")
    }

    @Test
    fun setState_Error() {
        val expectedStatusColor = getColor(R.color.colorBrdNatRed)
        test_setState(TextFieldInput.State.ERROR, expectedStatusColor, View.VISIBLE, ERROR_ICON_CODE.toIcon())
    }

    @Test
    fun setState_Success() {
        val expectedStatusColor = getColor(R.color.colorBrdNatGreen)
        test_setState(TextFieldInput.State.SUCCESS, expectedStatusColor, View.VISIBLE, SUCCESS_ICON_CODE.toIcon())
    }

    private fun test_setState(state: TextFieldInput.State, expectedStatusColor: Int,
                              expectedIconVisibility: Int, expectedIconValue: String) {
        val labelView = textFieldInput.findViewById(R.id.text_field_input_label) as TextView
        val footerView = textFieldInput.findViewById(R.id.text_field_input_footer) as TextView
        val footerIconView = textFieldInput.findViewById(R.id.text_field_input_footer_icon) as FontIcon

        textFieldInput.state = state

        assertThat(textFieldInput.borderColor).isEqualTo(expectedStatusColor)
        assertThat(labelView.currentTextColor).isEqualTo(expectedStatusColor)
        assertThat(footerView.currentTextColor).isEqualTo(expectedStatusColor)
        assertThat(footerIconView.currentTextColor).isEqualTo(expectedStatusColor)
        assertThat(footerIconView.visibility).isEqualTo(expectedIconVisibility)
        assertThat(footerIconView.text).isEqualTo(expectedIconValue)
    }

    @Test
    fun setInputType() {
        val expectedValue = InputType.TYPE_TEXT_VARIATION_PASSWORD
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.inputType = expectedValue
        assertThat(textView.inputType).isEqualTo(expectedValue)
    }

    @Test
    fun setHint() {
        val expectedValue = "test"
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.hint = expectedValue
        assertThat(textView.hint).isEqualTo(expectedValue)
    }

    @Test
    fun setLines() {
        val expectedValue = 5
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.lines = expectedValue
        assertThat(textView.maxLines).isEqualTo(expectedValue)
        assertThat(textView.minLines).isEqualTo(expectedValue)
    }

    @Test
    fun setMaxLines() {
        val expectedValue = 5
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.maxLines = expectedValue
        assertThat(textView.maxLines).isEqualTo(expectedValue)
    }

    @Test
    fun setMaxLength() {
        val expectedValue = 5
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.maxLength = expectedValue
        assertThat((textView.filters[0] as InputFilter.LengthFilter).max).isEqualTo(expectedValue)
    }

    @Test
    fun onRequestFocus_ChangeToFocusColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textView.requestFocus()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorBrdNatOrange))
    }

    @Test
    fun onClearFocus_ChangeToDefaultColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textView.requestFocus()
        textView.clearFocus()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorHighEmphasis_48))
    }

    @Test
    fun onClearFocus_ChangeToErrorColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.state = TextFieldInput.State.ERROR
        textView.requestFocus()
        textView.clearFocus()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorBrdNatRed))
    }

    @Test
    fun onClearFocus_ChangeToSuccessColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.state = TextFieldInput.State.SUCCESS
        textView.requestFocus()
        textView.clearFocus()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorBrdNatGreen))
    }

    @Test
    fun onClickIcon_CallListener() {
        val iconView = textFieldInput.findViewById(R.id.text_field_input_icon) as FontIcon
        var clicked = false

        textFieldInput.setOnIconClickListener(View.OnClickListener {
            clicked = true
        })
        iconView.performClick()
        assertThat(clicked).isTrue()
    }

    @Test
    fun onClickIcon_ChangeToFocusColor() {
        val iconView = textFieldInput.findViewById(R.id.text_field_input_icon) as FontIcon

        iconView.performClick()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorBrdNatOrange))
    }

    @Test
    fun setIsEnabledFalse_ChangeToDisabledColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.isEnabled = false
        assertThat(textView.isEnabled).isFalse()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorDisabled))
    }

    @Test
    fun setIsEnabledTrue_ChangeToDefaultColor() {
        val textView = textFieldInput.findViewById(R.id.text_field_input_value) as EditText

        textFieldInput.isEnabled = false
        textFieldInput.isEnabled = true
        assertThat(textView.isEnabled).isTrue()
        assertThat(textFieldInput.borderColor).isEqualTo(getColor(R.color.colorHighEmphasis_48))
    }

    private fun getColor(id: Int) = ContextCompat.getColor(textFieldInput.context, id)

}