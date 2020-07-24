# Color token

## What is it?
Colors suported by DS.

## Why should I use it?
It helps your aplication to be multibrand

## When should I use it?
Every time you need to color something in your aplication.
The actual supported colors are:

### App Major Colors
- Color Primary: `colorPrimary`
   - Color Primary Dark `colorPrimaryDark`
   - Color Primary Light `colorPrimaryLight`
- Color Secondary `colorSecondary`
   - Color Secondary Dark `colorSecondaryDark`
   - Color Secondary Light `colorSecondaryLight`
- On Colors
_use those colors over app major colors_
Ex: `colorOnPrimary`

### Surface
- Color background `colorBackground`
- Color surface `colorSurface`
- On Colors
_use those colors over surface colors_
Ex: `colorOnSurface`

### Content
- Color Highlight
- Color High Emphasis
- Color Medium Emphasis
- Color LowEmphasis

### Feedback
- Color Link
- Color Alert
- Color Warning
- Color Success
- On Colors
_use those colors over feedback colors_
Ex: `colorOnSuccess`

💡[Values for theme colors by brand and more infos about theme colors](https://zeroheight.com/08f80f4e1/p/79d8b0--colors).

## How to use it?
###You should access colors from theme to set it on layouts

```android
    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/colorPrimaryContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?colorPrimary">
    ```
Setting the attribute `android:background` as `?colorPrimary` to put this brand color as background of a layout.
To add a text over this layout, you can set its colors as `colorOnPrimary`

```android
    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/colorPrimaryContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="colorPrimary">
        <TextView
            android:id="@+id/colorPrimaryLabel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Primary"
            android:textColor="?colorOnPrimary" />
```

###You should access colors from theme to set on code
```kotlin
        val typedValue = TypedValue()
        context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        colorPrimaryLabel.textColor = typedValue.data
```
