# Getting Started - Nat Design System - WIP

### How DS is structured for use on Android - Applying themes
Our lib is being built from Android themes and styles. This means to consume any of resources
available in the library you need, at some level, to define as a base theme for the use of your
view a design system theme.

Perhaps now you are asking yourself: what? wait...

Look at this example:

We have several colors available on the DS. One is the colorSuccess color. This should be used in any
context where we want give feedback that some task were completed successfully. Let's say you want
to color a button with that color:

```android
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:backgroundTint="?colorSuccess">
 ```

Notice: we use ?colorSuccess to fill the backgroundTint attribute of the Button component.
When we write ?attributeName, we are indicating to Android that we want to pull this reference
from the theme applied to this view.

However, we need to define this theme somewhere. You know where? I'll show you:

1) Tag Application in MANIFEST.XML, set the theme attribute or
2) Tag Activity in MANIFEST.XML define the theme or attribute
3) Define the theme attribute in the views XML file or
4) Set the theme using the setTheme () method in the views onCreate

Our suggestion: always try to apply the DS theme to the most generic layers of your App. This greatly simplifies the use :)
But, if for some reason is not possible, fine. Define the theme locally in the view where you want to apply DS.

### Design Tokens - The foundation of Nat DS
Now you get how to access DS themes, let's talk about the most basic portion of our DS: the design tokens.
We call design tokens all the basic attributes of design systems. For example: colors, ypography definitions, etc.
Currently android lib provide the following tokens:

- Border radius​
- [Color​](color.md)
- Elevation​
- [Icons (drawables)](icon-token.md)
- Opacity​
- Size​
- Spacing​
- [Typography](typography-token.md)

And how can this be used by applications?
First of all, it is worth remembering that the components made available by DS are built from these tokens. In addition, you can explore our tokens
to define your screens and components.

For example: you need to add text to a view that will be styled with the following attributes:
 -  Font Family: Roboto, sans-serif
 -  Font Size: 96sp
 - Letter Spacing: 0.015625
 - Font weight: Regular
 - Lineheight: Medium (1.5)

You can set these attributes manually in an Android TextView component:

 ```android
     <TextView
         android:id="@+id/textView"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:text="Meu texto"
         android:padlineSpacingMultipliering="1.5"
         android:textSize="96sp"
         android:textColor="#333333"
         ..../>
 ```

or you can simply use the Heading 1 typography token that has exactly these attributes:
  ```android
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Meu texto"
          android:textAppereance="?textAppereanceHeading1"
          ..../>
  ```

Also, if you need to, for example apply a different color to your text. Okay! You can use a color token for this:

  ```android
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Meu texto"
          android:textAppereance="?textAppereanceHeading1"
          textColor:"?colorPrimary"
          ..../>
  ```
  
  💡 **More info about [typography here](typography-token.md)**

  ### How to Use Components
  - [App Bar Top](app-bar-top.md)
  - [Badge](badge.md)
  - [Button](button.md)
  - [Dialog](dialog.md)
  - Error
  - [Expansion Panel](expansion-panel.md)
  - Ext
  - Icon
  - [Logo](logo.md)
  - Menu
  - Navigation View
  - [Shortcut](shortcut.md)
  - [Tag](tag.md)
  - [Text Field](textfield.md)

