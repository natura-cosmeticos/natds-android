# TextField

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
    - none: There is no content type. The text is not editable.
    - text: Plain old text.
    - textCapCharacters: Can be combined with <var>text</var> and its variations to request capitalization of all characters.
    - textCapWords: Can be combined with <var>text</var> and its variations to request capitalization of the first character of every word.
    - textCapSentences: Can be combined with <var>text</var> and its variations to request capitalization of the first character of every sentence.
    - textAutoCorrect: an be combined with <var>text</var> and its variations to request auto-correction of text being input.
    - textAutoComplete: an be combined with <var>text</var> and its variations to specify that this field will be doing its own auto-completion and talking with the input method appropriately. The text field will be constrained to a single line.
    - textImeMultiLine: Can be combined with <var>text</var> and its variations to indicate that though the regular text view should not be multiple lines, the IME should provide multiple lines if it can.
    - textNoSuggestions: Can be combined with <var>text</var> and its variations to indicate that the IME should not show any dictionary-based word suggestions.
    - textUri: Text that will be used as a URI.
    - textEmailAddress: ext that will be used as an e-mail address.
    - textEmailSubject: text that is being supplied as the subject of an e-mail.
    - textShortMessage: Text that is the content of a short message.
    - textLongMessage: Text that is the content of a long message.
    - textPersonName: Text that is the name of a person.
    - textPostalAddress: Text that is being supplied as a postal mailing address.
    - textPassword: Text that is a password.
    - textVisiblePassword: Text that is a password that should be visible.
    - textFilter: Text that is filtering some other data.
    - textPhonetic: Text that is for phonetic pronunciation, such as a phonetic name field in a contact entry.
    - number: A numeric only field.
    - numberSigned: Can be combined with <var>number</var> and its other options to allow a signed number.
    - numberDecimal: Can be combined with <var>number</var> and its other options to allow a decimal (fractional) number.
    - numberPassword: A numeric password field.
    - phone: For entering a phone number.
    - datetime: For entering a date and time.
    - date: For entering a date.
    - time: For entering a time.

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

![Text Field Sample](textfieldsample.png)


#### Set Text Field text content programmatically

```kotlin
    val textField = findViewById<TextField>(R.id.myTextField)
    textField.text = "set text programmatically"
```

