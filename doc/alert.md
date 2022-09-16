# Alert

## Note for Design:

This component is available in the following variants:

* ✅ Standard

With the following attribute status:

* Type(available as type):
    * ✅ `contained` (default
    * ✅ `outlined`

* Color(available as type):
    * ✅ `success`
    * ✅ `error`
    * ✅ `warning`
    * ✅ `info` (default)
    * ✅ `custom`
    
* ✅ Title 
* ✅ Icon

show_icon

## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |

|`app:show_title`| Parameter defines whether the title will be rendered. | boolean | true or false
|`app:title_text`| Define the content that will be rendered at the alert title. | String | text
|`app:show_icon`| Parameter defines whether the icon will be rendered. | boolean | true or false
|`app:iconName`| Receives a string with the drawable to be render at component| string | text (icon name)
|`app:alert_type`| Defines whether the alert should render the contained or outlined border | string | contained, outlined
|`app:alert_color`| Sets the alert color | string | success, error, warning, info, custom

|`app:alert_custom_background_color`| Give the alert a custom color | color | success, error, warning, info, custom
|`app:alert_custom_stroke_color`| Give the stroke a custom color | color | success, error, warning, info, custom



#### Usage examples
Alert contained  variants

![alert contained variants](./images/alert_contained_variants.png)

#### Layout XML

```android
    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Success"
        app:show_icon="true"
        app:iconName="outlined_alert_check"
        app:alert_type="contained"
        app:alert_color="success">

        ...

    </com.natura.android.alert.Alert>

    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Error"
        app:show_icon="true"
        app:iconName="outlined_alert_cancel"
        app:alert_type="contained"
        app:alert_color="error">

        ...

    </com.natura.android.alert.Alert>


    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Warningr"
        app:show_icon="true"
        app:iconName="outlined_alert_warning"
        app:alert_type="contained"
        app:alert_color="warning">

        ...

    </com.natura.android.alert.Alert>


    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Warning"
        app:show_icon="true"
        app:iconName="outlined_alert_warning"
        app:alert_type="contained"
        app:alert_color="warning">

        ...

    </com.natura.android.alert.Alert>


    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Info"
        app:show_icon="true"
        app:iconName="outlined_alert_info"
        app:alert_type="contained"
        app:alert_color="info">

        ...

    </com.natura.android.alert.Alert>


    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Custom"
        app:show_icon="true"
        app:alert_type="contained"
        app:alert_color="custom">

        ...

    </com.natura.android.alert.Alert>
```

<br><br>


Alert outlined

![alert outlined](./images/alert_outlined.png)

#### Layout XML

```android
    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Info Outlined"
        app:show_icon="true"
        app:iconName="outlined_alert_info"
        app:alert_type="outlined"
        app:alert_color="info">

        ...

    </com.natura.android.alert.Alert>
```


<br><br>


Alert without icon

![alert without icon](./images/alert_without_icon.png)

#### Layout XML

```android
    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="true"
        app:title_text="Alert Only Title"
        app:show_icon="false"
        app:alert_type="contained"
        app:alert_color="info">

        ...

    </com.natura.android.alert.Alert>
```

<br><br>

Alert without title

![alert without title](./images/alert_without_title.png)

#### Layout XML

```android
    <com.natura.android.alert.Alert
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_title="false"
        app:show_icon="true"
        app:iconName="outlined_alert_info"
        app:alert_type="contained"
        app:alert_color="info">

        ...

    </com.natura.android.alert.Alert>
```


## Light mode / Dark mode

<p align="center">
  <img alt="Alert Light" src="./images/textfield_lightMode.png" width="40%"> 
&nbsp;
  <img alt="Alert Dark" src="./images/textfield_darkMode.png" width="40%">
</p>


## More code
You can check out more examples from SampleApp by clicking [here](https://github.com/natura-cosmeticos/natds-android/tree/master/sample/src/main/res/layout/activity_textfield.xml).

## Attention points

1. A alert is a DS component based on DS **multibrand themes**. It means if you want to use a alert in your app, you MUST set the DS theme on a view parent or in the alert component itself. [Check more info about how to set DS themes in your app](../README.md).