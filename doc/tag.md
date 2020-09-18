# Shortcut

## What is it?
Tag is a component that represents a text tag that can be add as a marker.

## How to use it?
Tag receives a label and its type. The tag type represents
it's visual style: primary or alert.

![Alert](tag_type.png)

Following there's an example of a tag primary code:

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagPrimary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:textLabel="Tag primary sample"
        app:tag_type="primary" />
```

Following there's an example of a tag alert code:

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagAlert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:textLabel="Tag alert sample"
        app:tag_type="alert" />
```

**A tag is a DS component based on DS multibrand themes. It means
if you want to use a tag in your app, you MUST set the DS theme
on a view parent or in the tag component itself. [Check
more info about how to set DS themes in your app](getting-started.md).**

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagAlert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:textLabel="Tag sample"
        app:tag_type="alert"
        android:theme="@style/Theme.Natura"/>
```
