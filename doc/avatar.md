# Avatar Component

![Avatar](avatar.png)

## What is it?

Avatar is a component that allows you to add images or identification of people and profiles in
applications.

### Why should I use it?

Because it has all the mechanism to display a profile ID

### How to use it?

Add the Avatar component in your xml layout file

```android
 <com.natura.android.avatar.Avatar
        android:id="@+id/standardAvatarWithIcon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:avt_icon="@drawable/outlined_navigation_arrowleft"
        app:avt_size="standard" />
```

#### How are attributes defined?

`Size:`

```android
    
    app:avt_size="standard" //standard, semi, semix, medium, largexxx
    
    avatarInActivity.size = Avatar.STANDARD_SIZE  //STANDARD_SIZE, SEMI_SIZE, SEMIX_SIZE, MEDIUM_SIZE, LARGE_SIZE

```

`Type:`

```android
    
    app:avt_size="icon" //icon, label, image
    
    avatarInActivity.type = Avatar.ICON_TYPE  //ICON_TYPE, LABEL_TYPE, IMAGE_TYPE

```

`Icon:`

```android
    
    app:avt_icon="@drawable/yourIcon"
    
    avatarInActivity.icon = R.drawable.yourIcon

```

`Local Image:`

```android
    
    app:avt_image="@drawable/yourImage"
    
    avatarInActivity.icon = R.drawable.yourImage

```

`Url Image:`

```android
    
    app:avt_url_image="http://www.natura.com.br/yourimage.jpg"
    
    avatarInActivity.icon = "http://www.natura.com.br/yourimage.jpg"

```

`Label: (only 3 three letters)` 

```android
    
    app:avt_label="Design System"
    
    avatarInActivity.icon = "Design System"

```

`Fallback Icon:`

```android
    
    app:avt_fallback_icon="@drawable/yourIcon"
    
    avatarInActivity.labelfallback = R.drawable.yourIcon

```

`Fallback Label:`

```android
    
    app:avt_fallback_label="Design System"
    
    avatarInActivity.labelFallback = "Design System"

```

`Content Description:`

```android
    
    app:avt_content_description="Perfil de Design System"
    
    avatarInActivity.labelFallback = "Perfil de Design System"

```






# Avatar
Avatar is a component that allows you to add images or identification of people and profiles in applications.  
Extends from [AbstractComposeView](https://developer.android.com/reference/kotlin/androidx/compose/ui/platform/AbstractComposeView).

| _Created: 9.8.0_|
| ----- | 

## Attributes
| Attr | Description | Type | Options |
| - | --- | --- | --- |
|`app:avt_type`|  Defines the component type based on its main content.| string | icon, label or image |
|`app:avt_size`| Sets the component size.| string | standard, semi, semix, medium or largexxx |
|`app:avt_icon`| Receives an icon to be displayed in the component. | drawable | image (drawable)
|`app:avt_image`| Receives an image to be displayed in the component. |drawable | image (drawable)
|`app:avt_label`| Defines the component label. | string | text
|`app:avt_image_url`| Receives an image from web to be displayed in the component. | PNG/JPG | image
|`app:avt_fallback_icon`| Sets an icon to be displayed when the image fails to load. | drawable | image (drawable)
|`app:avt_fallback_label`| Sets an label to be displayed when the image fails to load. | string | text
|`app:avt_content_description`| Defines the component description for screen readers (accessibility). | string | text

## Usage examples
Avatar with icon and semix size

![Avatar Center Primary](./images/avatar_semix.png)

#### Layout XML

```android
    <com.natura.android.avatar.Avatar
        android:id="@+id/avatar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:avt_icon="@drawable/outlined_navigation_arrowleft"
        app:avt_size="semix" />
```

#### Kotlin

```kotlin
    val avatar = findViewById<Avatar>(R.id.avatar)
    avatar.size = Avatar.STANDARD_SIZE
    avatar.icon = R.drawable.outlined_navigation_arrowleft
```
<br><br>
Avatar with label and medium size

![Avatar Center Primary](./images/avatar_medium.png)

#### Layout XML

```android
    <com.natura.android.avatar.Avatar
        android:id="@+id/avatar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:avt_label="Design System"
        app:avt_type="label" />
```

#### Kotlin

```kotlin
    val avatar = findViewById<Avatar>(R.id.avatar)
    avatar.size = Avatar.MEDIUM_SIZE
    avatarInActivity.label = "Design System"
```
<br><br>

Avatar with image and largexxx size

![Avatar Center Primary](./images/avatar_largexxx.png)

#### Layout XML

```android
    <com.natura.android.avatar.Avatar
        android:id="@+id/avatar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:avt_image="@mipmap/nat_avatar"
        app:avt_size="largexxx"
        app:avt_type="image" />
```

#### Kotlin

```kotlin
    val avatar = findViewById<Avatar>(R.id.avatar)
    avatar.size = Avatar.LARGEXXX_SIZE
    avatar.image = R.drawable.nat_avatar
```
<br>

## Light mode / Dark mode

<p align="center">
  <img alt="Avatar Light" src="./images/avatar_lightMode.png" width="40%"> 
&nbsp;
  <img alt="Avatar Dark" src="./images/avatar_darkMode.png" width="40%">
</p>

## More code
You can check out more examples from SampleApp by clicking [here](../sample/src/main/res/layout/activity_avatar.xml).

## Attention points

1. A avatar is a DS component based on DS **multibrand themes**. It means if you want to use a avatar in your app, you MUST set the DS theme on a view parent or in the avatar component itself. [Check more info about how to set DS themes in your app](getting-started.md).





  

