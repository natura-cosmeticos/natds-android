# TextField

#### Note:

This component is available in the following variants:

* ✅ Standard

With the following attribute status:

* Size:
    * ✅ `MediumX` (default)
    * ✅ `Medium`
    
* Feedback:
    * ✅ `Error`
    * ✅ `Success`
    
* Action:
    * ✅ `None` (default)
    * ✅ `Icon Button`
    * ✅ `Image`
    
* ✅ Required
* ✅ Disabled
* ✅ Read Only
* ✅ Helper Text

* Type:
    * ✅ `Text`
    * ✅ `Password`
    * ✅ `Multi-line`
    * ✅ `Number`

* Interaction state:
    * ✅ `Enabled`
    * ✅ `Focus`
    * ✅ `Filled`
    
    

### What is it?
A component that let users enter and edit text.

### When should I use it?
Use it to create forms or every time its necessary to get data from users input

### How to use it?

Add the TextField component in your xml layout file

```android
    <com.natura.android.textfield.TextField
        android:id="@+id/text_item"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Hint"
        app:text_field_label="Text Field label."
        app:text_field_text="Text Field content"
        app:text_field_footer="Text Field footer content"
        />
```
#### TextField component has the following attributes that can be set:
- `android:inputType`: Nat DS TextField component is defined on Android EditText component. This attribute is inherited from EditText and set the type of content supported by Text Field:
    - text: Plain old text.
    - textMultiLine: Can be combined with <var>text</var> and its variations to indicate that though the regular text view should be multiple lines
    - textPassword: Text that is a password.
    - number: A numeric only field.
    - numberPassword: A numeric password field.

- `android:maxLines`: Makes the TextView be at most this many lines tall. When used on an editable text, the <code>inputType</code> attribute's value must be combined with the <code>textMultiLine</code> flag for the maxLines attribute to apply.
- `android:maxLength`: set an input filter to constrain the text length to the specified number
- `android:lines`: Makes the text be exactly this many lines tall
- `android:hint`: Hint text to display when the text is empty
- `android:enable`: specifies whether the widget is enabled. A non-enabled TextField prevents the user from editing the contained text.
- `app:text_field_text`: content of TextField
- `app:text_field_icon`: icon visible on right side of TextField. Receives an string that represent an icon on natds-icons.ttf file
- `app:text_field_label`: Label showed above the input. Can be used to describe the field
- `app:text_field_footer`: Label showed below the input. Can be used to give feedback about the field state
- `app:text_field_state`: Describe the state of the field. Can receive the values: none, success or error
- `app:text_field_size`: Describe the size (height) of the field. Can receive the values: mediumx or medium
- `app:text_field_required`: specifies if the widget is required, with an asterisk in label.
- `app:text_field_readonly`: specifies whether the widget is read only.
- `app:text_field_image`: image visible on right side of TextField. Receives an image resource


#### Set Text Field text content programmatically

```kotlin
    val textField = findViewById<TextField>(R.id.myTextField)
    textField.text = "set text programmatically"
```

