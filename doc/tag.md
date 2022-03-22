# Tag
Tags are used to label, categorize, or organize items using keywords that describe them.  

Extends from [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout).

## Note for Design:

This component is available in the following variants:

- ✅ **Standard**

With the following attribute status:

- **Size**:
  - ✅ `Standard`
  - ✅ `Small`
- **Color**:
  - ✅ `Primary`
  - ✅ `Secondary`
  - ✅ `Alert`
  - ✅ `Success`
  - ✅ `Link`
  - ✅ `Warning`
- **Position**:
  - ✅ `Center`
  - ✅ `Left`
  - ✅ `Right`
  
## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |
|`app:tag_type`|  Sets the component color.| string | primary(default), alert, secondary, success, warning, link or custom |
|`app:tag_size`| Sets the component size.| string | small(default) or standard
|`app:tag_position`| Defines the layout of ends, according to the desired position of the component. | string | center(default), left or right
|`app:textLabel`| Defines the Label showed inside the component. | string | text
|`app:tag_icon`| Defines the icon showed inside the component. | string | text
|`app:tag_background_color`| Defines the custom color for the background, when the type is custom. | resource | color
|`app:tag_label_color`| Defines the custom color for the label, when the type is custom. | resource | color
## Usage examples
Tag with position center, primary type and small size

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
Tag with position left, alert type and standard size

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
Tag with position right, warning type and small size

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

<br><br>
Tag with icon and custom color

![Tag With Icon](./images/tag_withIcon.png)

#### Layout XML

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagWithIcon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:tag_icon="@drawable/outlined_action_mic"
        app:tag_position="center"
        app:tag_size="standard"
        app:tag_type="custom"
        app:tag_background_color="?colorNeutral300"
        app:tag_label_color="?colorOnPrimary"
        app:textLabel="Tag" />
```

#### Kotlin

```kotlin
    val tag = findViewById<Tag>(R.id.tagWarning)
    tag.setLabel("Right Warning Small")
```

<br>

## Light mode / Dark mode

<p align="center">
  <img alt="Tag Light" src="./images/tag_lightMode.png" width="40%"> 
&nbsp;
  <img alt="Tag Dark" src="./images/tag_darkMode.png" width="40%">
</p>

## More code
You can check out more examples from SampleApp by clicking [here](https://github.com/natura-cosmeticos/natds-android/tree/master/sample/src/main/res/layout/activity_tag.xml).

## Attention points

1. A tag is a DS component based on DS **multibrand themes**. It means if you want to use a tag in your app, you MUST set the DS theme on a view parent or in the tag component itself. [Check more info about how to set DS themes in your app](../README.md).

