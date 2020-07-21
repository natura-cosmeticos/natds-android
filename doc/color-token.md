# Typography Token - How to Use

## What is it?
Color tokens can help you color applications.

## Why should I use it?
With color tokens it is posible to explore semantic colors with multibrand support.
You can check [our docs](https://zeroheight.com/08f80f4e1/p/79d8b0--colors) about color
to understand better the usage

## When should I use it?
Every time you want to color something in your application

## How to use it?
The colors will adapt automatically to the base theme chosen

### Primary / Secondary
To use primary or secondary colors at components, you should set the color attribute of the component as
follow:

```android
    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/colorPrimaryContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?colorPrimary">
```
Checks that android:background attribute was filled with the "?colorPrimary" value. It means this attribute
will receive the value of this attribute set on theme.

- colorPrimary
- colorSecondary
-

