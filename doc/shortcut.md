# Shortcut
Shortcut is a component that represents a shortcut to some action.   
Extends from ConstraintLayout.


| _Created: 2.3.0_ <br> _Last updated (With Breaking Change): 9.0.0_ |
| ----- | 


## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |
|`app:shct_type`|  Defines the type of the component's background.| string | - **contained**: background is filled <br> - **outlined**: componente é apenas delineado <br> |
|`app:shct_text_label`| Sets the label of component.| string | text
|`app:shct_icon_name`| Defines the name of the icon that will be shown in the center of the component. | string | text
|`app:shct_notify`| Sets the number showed by notification at Shortcut | integer | When 0, notification is not visible, limit is 10000. |

## Usage Examples
Shortcut with mockup icon, type contained and notify

![Shortcut](./images/shortcut_contained.png)

#### Layout XML

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutContained"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_notify="1000"
        app:shct_text_label="Contained/Primary"
        app:shct_type="contained" />
```

#### Kotlin

```kotlin
    val shortcut = findViewById<Shortcut>(R.id.shortcutContained)
    shortcut.notify = 1000
    shortcut.setLabel("Contained/Primary")
    shortcut.setIcon("outlined-default-mockup")
```
<br><br>
Shortcut with mockup icon, type outlined and action

![Shortcut](./images/shortcut_outlined.png)

#### Layout XML

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Outlined/Primary"
        app:shct_type="outlined" />
```

#### Kotlin

```kotlin
    val shortcut = findViewById<Shortcut>(R.id.shortcutOutlined)
    shortcut.setLabel("Outlined/Primary")
    shortcut.setIcon("outlined-default-mockup")

    shortcut.setOnClickListener {
        Toast.makeText(this, "Testing shortcut", Toast.LENGTH_SHORT).show()
    }
```

## Attention points

⚠️ ⚠️ ⚠️ Before the 3.0.0 version, the parameter to set the shortcut icon is different ⚠️ ⚠️ ⚠️

- Attribute name: icon
- Parameter type: drawable

Ex: `app:icon="@drawable/outlined_default_mockup"`

```android
    <com.natura.android.shortcut.Shortcut
        android:id="@+id/shortcutOutlined"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:shct_icon_name="outlined-default-mockup"
        app:shct_text_label="Shortcut contained sample"
        app:shct_type="contained" />
```