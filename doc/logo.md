# Logo Pattern

### What is it?
The oficial logo aplication for brands that we support

### Why should I use it?
It's easier to set logo from the pattern, because it support diferent brands

### When should I use it?
Every time you neet to put brand logo to your product

### How to use it?
For now, logo patern is available by theme attribute. It means fist of all you MUST set to your view theme (or to a parent of this view) one of your themes.
Check more info about it [here](getting-started.md)

[![Logo](logoSample.png)]

After that, just set to your ImageView resource like below:

#### Horizontal Logo:

```android
        <ImageView
            android:id="@+id/logoHorizontal"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="?horizontalLogo"/>
   ```

#### Vertical Logo:

```android
       <ImageView
           android:id="@+id/logoVertical"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:src="?horizontalLogo"/>
  ```

### Extra infos
By default at light theme logo will follow its original colors and dark themes will color logo as white.


