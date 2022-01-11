# Tag
Tag is a component that represents a text tag that can be add as a marker.
Extends from ConstraintLayout.

| _Created: 2.7.0_  <br> _Last updated: 5.9.0_ |
| ----- | 

## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |
|`app:tag_type`|  Sets the component color.| string | primary(default), alert, secondary, success, warning or link |
|`app:tag_size`| Sets the component size.| string | small(default) or standard
|`app:tag_position`| Defines the layout of ends, according to the desired position of the component. | string | center(default), left or right
|`app:text_field_label`| Defines the Label showed inside the component. | string | text

## Usage examples
Tag with Position Center, Primary Type and Small Size

![Tag Center Primary](./images/tag_centersmall.png)

#### Layout XML

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagPrimary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:tag_type="primary"
        app:textLabel="Center Primary Small" />
```

#### Kotlin

```kotlin
    val tag = findViewById<Tag>(R.id.tagPrimary)
    tag.setLabel("Center Primary Small")
```
<br><br>
Tag with Position Left, Alert Type and Standard Size

![Tag Center Primary](./images/tag_leftstandard.png)

#### Layout XML

```android
     <com.natura.android.tag.Tag
        android:id="@+id/tagAlert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:tag_size="standard"
        app:tag_type="alert"
        app:tag_position="left"
        app:textLabel="Left Alert Standard" />

```

#### Kotlin

```kotlin
    val tag = findViewById<Tag>(R.id.tagAlert)
    tag.setLabel("Left Alert Standard")
```
<br><br>
Tag with Position Right, Warning Type and Small Size

![Tag Center Primary](./images/tag_rightsmall.png)

#### Layout XML

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagWarning"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:tag_size="small"
        app:tag_type="warning"
        app:tag_position="right"
        app:textLabel="Right Warning Small" />
```

#### Kotlin

```kotlin
    val tag = findViewById<Tag>(R.id.tagWarning)
    tag.setLabel("Right Warning Small")
```