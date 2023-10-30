# Checkbox

> Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on or off.

Extends from [AppCompatCheckBox](https://developer.android.com/reference/androidx/appcompat/widget/AppCompatCheckBox).


## Properties

| Property           | Values                         | Status            |
| --------------     | -------------------------      | ----------------- |
| Variant             | Checked, Unchecked, Indeterminate                   | ✅  Available     |
| State          | Enabled, Pressed   | ✅  Available     |
| Disabled         | True or False        | ✅  Available     |


## Technical Usages Examples

![Checkbox](./images/checkbox_lightMode.png)

<br>

##### Checkbox enabled checked

![Checkbox](./images/checkbox_checked.png)


```android
    <com.natura.android.checkbox.CheckBox
        android:id="@+id/checkbox"
        android:text="Checkbox Checked"
        android:layout_width="wrap_content"
        android:checked="true"
        android:layout_height="wrap_content"/>
```

<br>
em Kotlin
<br>

```kotlin
    val checkbox = findViewById<CheckBox>(R.id.checkbox)
    checkbox.state = CheckBox.CHECKED
```
<br><br>


##### Checkbox enabled checked

![Checkbox](./images/checkbox_indeterminate.png)

<br>
em Kotlin
<br>

```kotlin
    val checkbox = findViewById<CheckBox>(R.id.checkbox)
    checkbox.state = CheckBox.INDETERMINATE
```
<br><br>

##### Checkbox unchecked disabled

![Checkbox](./images/checkbox_disabled.png)


```android
    <com.natura.android.checkbox.CheckBox
        android:id="@+id/checkbox"
        android:text="Checkbox Checked"
        android:layout_width="wrap_content"
        android:enabled="false"
        android:layout_height="wrap_content"/>
```
<br>
em Kotlin
<br>

```kotlin
    val checkbox = findViewById<CheckBox>(R.id.checkbox)
    checkbox.state = CheckBox.UNCHECKED
```
<br>


## More code
You can check out more examples from SampleApp by clicking [here](https://github.com/natura-cosmeticos/natds-android/tree/master/sample/src/main/res/layout/activity_checkbox.xml).
