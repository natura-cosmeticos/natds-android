# Button
Buttons allow users to take actions, and make choices, with a single tap.

## Note for Design:

This component is available in the following styles:

- ✅ **Contained**
- ✅ **Outlined**
- ✅ **Text**

With the following attribute status:

- ✅ **Disabled**
- **Size**:
  - 🚧 `Semi`
  - 🚧 `Semix`
  - 🚧 `Medium`
- **Icon**:
  - 🚧 `Left`
  - 🚧 `Right`
- **Display**:
  - 🚧 `Inline`
  - 🚧 `Block`

## Attributes
| Attr | Description | Type | Options |
| - | --- |:-:|-|
|`style`|  Set component appearance attributes.| Theme attribute| -`containedButton`: Default style of the native component and that provides the button background filled with the primary color<br> - `outlinedButton`: Style that proves the only outlined component. <br> -`textButton`: Style that proves the component with its text only.|

## Usage Examples
Button Contained Disabled

![Button](./images/button_contained.png)

#### Layout XML

```android
    <Button
          android:id="@+id/button"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:minWidth="?sizeHuge"
          android:enabled="false"
          style="?containedButton"
          android:text="contained" />
```

<br><br>

Button Outlined

![Button](./images/button_outlined.png)

#### Layout XML

```android
    <Button
          android:id="@+id/button"
          style="?outlinedButton"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:minWidth="?sizeHuge"
          android:text="outlined" />
```

<br><br>


Button Text

![Button](./images/button_text.png)

#### Layout XML

```android
    <Button
          android:id="@+id/button"
          style="?textButton"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:minWidth="?sizeHuge"
          android:text="text" />
```

<br><br>


## Light mode / Dark mode

<p align="center">
  <img alt="Button Light" src="./images/button_lightMode.png" width="40%"> 
&nbsp;
  <img alt="Button Dark" src="./images/button_darkMode.png" width="40%">
</p>

## More code
You can check out more examples from SampleApp by clicking [here](../sample/src/main/res/layout/activity_button.xml).

## Attention points

1. A button is a DS component based on DS **multibrand themes**. It means if you want to use a button in your app, you MUST set the DS theme on a view parent or in the button component itself. [Check more info about how to set DS themes in your app](../README.md).






