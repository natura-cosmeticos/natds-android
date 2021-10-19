# Selection Control

## What is it?
Selection controls allow the user to select options.

## How to use it?

### Checkboxes
Checkboxes allow the user to select one or more items from a set. Checkboxes can be used to turn an option on or off.
Nat DS Android Checkbox is based on a android [CheckBox](https://developer.android.com/reference/android/widget/CheckBox) with styles provided by Nat DS Theme.
To use it, a Nat DS Theme must be provided to the view or its parents. After that, its possible to add a CheckBox component on xml layout:

```android
    <CheckBox
        android:id="@+id/checkbox"
        android:text="CheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

### RadioButton
Radio buttons allow the user to select one option from a set. Use radio buttons when the user needs to see all available options.
Nat DS Android RadioButton is based on a android [RadioButton](https://developer.android.com/reference/android/widget/RadioButton) with styles provided by Nat DS Theme.
To use it, a Nat DS Theme must be provided to the view or its parents. After that, its possible to add a RadioButton component on xml layout:

```android
    <RadioButton
        android:id="@+id/radioButton"
        android:text="RadioButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

⚠️⚠️⚠️ Nat DS Android supports for now only Checkboxes and RadioButtons as selection controls. Switch variant is not available. ⚠️⚠️⚠️
