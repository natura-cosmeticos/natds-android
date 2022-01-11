### RadioButton
Radio buttons allow the user to select one option from a set.   
Extends from [AppCompatRadioButton](https://developer.android.com/reference/androidx/appcompat/widget/AppCompatRadioButton).


| _Created: 1.0.0_ <br> _Last updated (With Breaking Change): 9.2.0_ |
| ----- | 

## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |
|` android:checked`|  Defines if the component is checked.| boolean | true or false <br> |
|` android:enabled`| Defines if the component is enabled.| boolean | true or false <br> |
|` android:text`| Sets the component label.| string | text |

## Usage Examples
RadioButton enabled unchecked

![RadioButton](./images/radiobutton_enabledUnchecked.png)

#### Layout XML

```android
    <com.natura.android.radiobutton.RadioButton
        android:id="@+id/radioButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Radio Button" />
```

#### Kotlin

```kotlin
    val radioButton = findViewById<RadioButton>(R.id.radioButton)
    radioButton.text = "Radio Button"
    radioButton.isEnabled = true
    radioButton.isChecked = false
```
<br><br>
RadioButton enabled checked
<br>       

![RadioButton](./images/radiobutton_enabledChecked.png)

#### Layout XML

```android
    <com.natura.android.radiobutton.RadioButton
        android:id="@+id/radioButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checked="true"
        android:text="Radio Button" />
```

#### Kotlin

```kotlin
    val radioButton = findViewById<RadioButton>(R.id.radioButton)
    radioButton.text = "Radio Button"
    radioButton.isEnabled = true
    radioButton.isChecked = true
```    
<br><br>
RadioButton disabled unchecked

![RadioButton](./images/radiobutton_disabledUnchecked.png)

#### Layout XML

```android
    <com.natura.android.radiobutton.RadioButton
        android:id="@+id/radioButton"
        android:enabled="false"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Radio Button" />
```

#### Kotlin

```kotlin
    val radioButton = findViewById<RadioButton>(R.id.radioButton)
    radioButton.text = "Radio Button"
    radioButton.isEnabled = false
    radioButton.isChecked = false
```

<br><br>
RadioButton disabled checked

![RadioButton](./images/radiobutton_disabledChecked.png)

#### Layout XML

```android
    <com.natura.android.radiobutton.RadioButton
        android:id="@+id/radioButton"
        android:enabled="false"
        android:checked="true"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Radio Button" />
```

#### Kotlin

```kotlin
    val radioButton = findViewById<RadioButton>(R.id.radioButton)
    radioButton.text = "Radio Button"
    radioButton.isEnabled = false
    radioButton.isChecked = true
```

<br>

## Light mode / Dark mode

<p align="center">
  <img alt="Radio Button Light" src="./images/radiobutton_lightMode.png" width="40%"> 
&nbsp;
  <img alt="Radio Button Dark" src="./images/radiobutton_darkMode.png" width="40%">
</p>

## More code
You can check out more examples from SampleApp by clicking [here](../sample/src/main/res/layout/activity_radiobutton.xml).

## Attention points

1. A radio button is a DS component based on DS **multibrand themes**. It means if you want to use a radio button in your app, you MUST set the DS theme on a view parent or in the radio button component itself. [Check more info about how to set DS themes in your app](getting-started.md).






