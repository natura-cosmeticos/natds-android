# Tag

#### Note:

This component is available in the following variants:

* ✅ Standard

With the following attribute status:

* Size:
    * ✅ `Small` (default)
    * ✅ `Standard`
    
* Color:
    * ✅ `Primary` (default)
    * ✅ `Secondary`
    * ✅ `Alert`
    * ✅ `Warning`
    * ✅ `Success`
    * ✅ `Link`
    
* Position:
    * ✅ `Center` (default)
    * ✅ `Left`
    * ✅ `Right`

## What is it?
Tag is a component that represents a text tag that can be add as a marker.

## How to use it?
Tag receives a label, its color (represented by the attribute `type`), its size and its position.

Following there's a code example of a tag with color primary and default size and position:

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagPrimary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:textLabel="Tag primary sample"
        app:tag_type="primary" />
```

Following there's an example of a tag with alert type, standard size and left position:

```android
    <com.natura.android.tag.Tag
        android:id="@+id/tagAlert"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:textLabel="Tag alert sample"
        app:tag_type="alert"
        app:tag_size="standard"
        app:tag_position="left" />
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

![Tag](tag-activity.png)