# Typography Token - How to Use

### What is it?
Typography tokens can help youto style texts.

### Why should I use it?
Typography token is the easiest way to support multibrand and consume an standard style to texts

### When should I use it?
Every time you need an text on your application, you can use the attribute *textAppereance* to sytle it

### How to use it?
Right now Nat DS Typography Tokens support these variets:
[![typography.png](https://i.postimg.cc/mDMSnyLh/typography.png)](https://postimg.cc/YGrgGgmw)

Today all brands supported by Nat DS use the same typography token reference

### Heading 1
 Theme attribute name: textAppearanceHeadline1
 -  Font Family: Roboto, sans-serif
 -  Font Size: 96sp
 - Letter Spacing: 0.015625
 - Font weight: Regular
 - Lineheight: Medium (1.5)
 ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 1"
   android:textAppearance="?textAppearanceHeadline1"/>
   ```

### Heading 2
 Theme attribute name: textAppearanceHeadline2
 - Font Family: Roboto, sans-serif
 - Font Size: 60sp
 - Letter Spacing: -0.00833333333
 - Font weight: Regular
 - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 2"
   android:textAppearance="?textAppearanceHeadline2"/>
   ```
 ### Heading 3
 Theme attribute name: textAppearanceHeadline3
 - Font Family: Roboto, sans-serif
 - Font Size: 48sp
 - Letter Spacing: 0
 - Font weight: Regular
 - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 3"
   android:textAppearance="?textAppearanceHeadline3"/>
   ```

 ### Heading 4
 Theme attribute name: textAppearanceHeadline4
 - Font Family: Roboto, sans-serif
 - Font Size: 34sp
 - Letter Spacing: 0.00735294118
 - Font weight: Regular
 - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 4"
   android:textAppearance="?textAppearanceHeadline4"/>
   ```

 ### Heading 5
 Theme attribute name: textAppearanceHeadline5
 - Font Family: Roboto, sans-serif
 - Font Size: 24sp
 - Letter Spacing: 0
 - Font weight: Regular
 - Lineheight: Medium (1.5)

  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 5"
   android:textAppearance="?textAppearanceHeadline5"/>
   ```

 ### Heading 6
 Theme attribute name: textAppearanceHeadline6
 - Font Family: Roboto, sans-serif
 - Font Size: 20sp
 - Letter Spacing: 0.0125
 - Font weight: Medium
 - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 6"
   android:textAppearance="?textAppearanceHeadline6"/>
   ```

 ### Subtitle 1
 Theme attribute name: textAppearanceSubtitle1
 - Font Family: Roboto, sans-serif
 - Font Size: 16sp
 - Letter Spacing: 0.009375
 - Font weight: Medium
 - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Subtitle 2"
   android:textAppearance="?textAppearanceSubtitle1"/>
   ```

  ### Subtitle 2
  Theme attribute name: textAppearanceSubtitle2
  - Font Family: Roboto, sans-serif
  - Font Size: 14sp
  - Letter Spacing: 0.00714285714
  - Font weight: Medium
  - Lineheight: Medium (1.5)
  ```android
  <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Subtitle 2"
   android:textAppearance="?textAppearanceSubtitle2"/>
   ```

 ### Body 1
 Theme attribute name: textAppearanceBody1
 - Font Family: Roboto, sans-serif
 - Font Size: 16sp
 - Letter Spacing: 0.03125
 - Font weight: Regular
 - Lineheight: Medium (1.5)
   ```android
   <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Body 1"
    android:textAppearance="?textAppearanceBody1"/>
    ```

  ### Body 2
 Theme attribute name: textAppearanceBody2
 - Font Family: Roboto, sans-serif
 - Font Size: 14sp
 - Letter Spacing: 0.03125
 - Font weight: Regular
 - Lineheight: Medium (1.5)
   ```android
   <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Body 2"
    android:textAppearance="?textAppearanceBody2"/>
    ```

  ### Button
 Theme attribute name: textAppearanceButton
 - Font Family: Roboto, sans-serif
 - Font Size: 14sp
 - Letter Spacing: 0.0892857143
 - Font weight: Medium
 - Lineheight: Medium (1.5)
   ```android
   <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Button"
    android:textAppearance="?textAppearanceButton"/>
    ```

  ### Caption
 Theme attribute name: textAppearanceCaption
 - Font Family: Roboto, sans-serif
 - Font Size: 12sp
 - Letter Spacing: 0.0333333333
 - Font weight: Regular
 - Lineheight: Medium (1.5)
   ```android
   <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Caption"
    android:textAppearance="?textAppearanceCaption"/>
    ```

  ### Overline
 Theme attribute name: textAppearanceOverline
 - Font Family: Roboto, sans-serif
 - Font Size: 12sp
 - Letter Spacing: 0.166666667
 - Font weight: Medium
 - Lineheight: Medium (1.5)
   ```android
   <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Overline"
    android:textAppearance="?textAppearanceOverline"/>
    ```

 ### Styles
 All these variations allow the application of the bold and italic styles through the xml, as shown below:
 ```android
 <TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 4"
   android:textStyle="bold"
   android:textAppearance="?textAppearanceHeadline4"/>
```

 ```android
<TextView
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:text="Heading 1"
   android:textStyle="italic"
   android:textAppearance="?textAppearanceHeadline1"/>
```