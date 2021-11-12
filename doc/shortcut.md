# Shortcut

## What is it?
Shortcut is a component that represents a shortcut to some action.

## How to use it?
Shortcut receives an icon, a notify, a label and its type. The shortcut type represents
it's visual style: contained or outlined.

![Shortcut](shortcut_type.png)

Following there's an example of an shortcut outlined:

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Shortcut outlined sample"
        app:shct_type="outlined" />
```

Following there's an example of an shortcut contained:

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Shortcut contained sample"
        app:shct_type="contained" />
```

To insert a notification badge, simply add the notify property to the xml. Its value can be modified programmatically.

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutContained"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_notify="10"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Contained/ \nPrimary"
        app:shct_type="contained" />
```

```kotlin
    shortcutContained.notify = 10
```

When value is 0, notification is not visible, when bigger than 99, notification shows 99+.

![Shortcut](shortcut_notify.png)


⚠️ ⚠️ ⚠️ Before the 3.0.0 version, the parameter to set the shortcut icon is different ⚠️ ⚠️ ⚠️

- attribute name: icon
- parameter type: drawable

Ex: app:icon="@drawable/outlined_default_mockup"

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Shortcut contained sample"
        app:shct_type="contained" />
```

**A shortcut is a DS component based on DS multibrand themes. It means
if you want to use a shortcut in your app, you MUST set the DS theme
on a view parent or in the shortcut component itself. [Check
more info about how to set DS themes in your app](getting-started.md).**

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Shortcut sample"
        app:shct_type="outlined"
        android:theme="@style/Theme.Natura"/>
```

### Setting shortcut action
A shortcut behave similar to a button. So, to add action to it
just set a shortcut click listenerr:

```kotlin
    shortcutContained.setOnClickListener {
        Toast.makeText(this, "Testing shortcut", Toast.LENGTH_SHORT).show()
    }
```
