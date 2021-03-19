# List Item Component

## What is it?

List item view is a container that can be applied to the layout of an item in a list.

### Why should I use it?

To facilitate the work of creating a list item that adheres to Natura's visual standard.

### When should I use it?

Every time you want to create a list item with Natura's visual pattern and effects.

### How to use it?

Add the List Item component in your xml layout file
        
```android
<com.natura.android.listitem.ListItem
        android:id="@+id/listItem"
        android:layout_width="match_parent"
        android:layout_height="50dp">

        ...

        <TextView
            android:id="@+id/itemListDescription"
            android:layout_marginStart="?spacingSmall"
            android:layout_marginTop="?spacingSmall"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="teste" />

    </com.natura.android.listitem.ListItem>
```
#### List item component has the following attribute that can be set:

- `dividerBottom`:  Defines the type of bottom separator that the view can contain. The options are: None (0), Fullbleed (1), Inset(2),  Middle(3)

```kotlin
    listItem.setDivider(2)
```

- `touchState`:  defines whether the view is enabled to receive touch events. It can be true or false.

```kotlin
    listItem.setTouchStateTrue()
    listItem.setTouchStateFalse()
```

- `selectableState`:  defines whether the display is enabled to remain selected after the touch. It can be true or false.

```kotlin
    listItem.setSelectableStateTrue()
    listItem.setSelectableStateFalse()
```

⚠️ ⚠️ ⚠️ For better use of the component, it is important to define a height in dp, and the margins that need to be placed, apply them to the internal elements. ⚠️ ⚠️ ⚠️



           
![List Item](list-item.png)

