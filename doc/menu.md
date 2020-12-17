# Menu Component

### What is it?
Menu component represents the individual menu item

### Why should I use it?
Menu can be used to compose a list of options that can be added at applications

### When should I use it?
You should use it to compose a catalog of options in applications

### How to use it?
WIP

Following there's an example of a menu with a tag code:

```android
    <com.natura.android.menu.MenuView
        android:id="@+id/menuTag"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:menu_label="Sample menu item"
        app:menu_icon="outlined-action-add"
        app:menu_label_color="?colorSurface"
        app:menu_label_size="@dimen/ds_text_small"
        app:menu_has_tag="true"
        app:menu_tag_label="Sample tag" />
```
