### RadioButton

### What is it?
Radio buttons allow the user to select one option from a set.
Nat DS Android RadioButton is based on a android [RadioButton](https://developer.android.com/reference/android/widget/RadioButton) with styles provided by Nat DS Theme.

### When should I use it?
Radio buttons should be used instead of checkboxes if only one item can be selected from a list.

### How to use it?
To use it, a Nat DS Theme must be provided to the view or its parents. After that, its possible to add a RadioButton component on xml layout:

```android
    <RadioButton
        android:id="@+id/radioButton"
        android:text="RadioButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```