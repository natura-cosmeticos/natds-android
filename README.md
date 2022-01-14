# Design System Natura for Android

![build](https://img.shields.io/bitrise/7f2a8943b9821eb7/master?style=for-the-badge&token=FxAKpfZdgAYqXYTaox0E8Q)
![release](https://img.shields.io/github/v/release/natura-cosmeticos/natds-android?style=for-the-badge)

## What for
Library with Android components defined by [Natura Group Design System Team](https://ds.natura.design/28db352be/p/35bf2e-natds--natura-design-system).


![Design Systen](doc/images/header-readme.png)

## How to use

### How to add dependency
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** when generating you password.
In the file build.gradle, insert the informations:

    repositories {
    
        def githubProperties = new Properties()
        def githubFile = rootProject.file("github_credentials.properties")
        if (githubFile.exists()) {
            githubProperties.load(new FileInputStream(githubFile))
        }
        
        maven {
            name = "natds-android"
            url = uri("https://maven.pkg.github.com/natura-cosmeticos/natds-android")
            credentials {
                username = githubProperties['github.username'] ?: System.getenv("GITHUB_USERNAME")
                password = githubProperties['github.password'] ?: System.getenv("GITHUB_API_KEY")
            }
        }
    }

And:

    dependencies {
        implementation "com.natura.android:designsystem:<version>"
        implementation 'com.google.android.material:material:1.1.0'
    }       


## Nat DS Icons

![VERSION](https://img.shields.io/github/v/release/natura-cosmeticos/natds-commons?style=for-the-badge)

Since 4.0.0 Nat DS Android has no longer Nat DS Icons. In order to use Nat DS Icons, you MUST add a new dependency:

    repositories {

        def githubProperties = new Properties()
        def githubFile = rootProject.file("github_credentials.properties")
        if (githubFile.exists()) {
            githubProperties.load(new FileInputStream(githubFile))
        }

        //To Access Nat DS Icons dependency at Github Packages
        maven {
            name = "natds-commons"
            url = uri("https://maven.pkg.github.com/natura-cosmeticos/natds-commons")
            credentials {
                username = githubProperties['github.username'] ?: System.getenv("GITHUB_USERNAME")
                password = githubProperties['github.password'] ?: System.getenv("GITHUB_API_KEY")
            }
        }
        
    }

And:

    dependencies {
        implementation "com.natura:icons:$rootProject.<version>"
    }
    
You can use Nat DS Icons without using Nat DS Android.

## How DS is structured for use on Android - Applying   themes

Our lib is being built from Android themes and styles. This means to consume any of resources available in the library you need to define as a base theme for the use of your view, a design system theme.

However, it is necessary to define this place to insert the theme. According to the Android structure, there are the following options:

1. Set the theme attribute in tag Application at file AndroidManifest.XML 
    
```android
<application 
  android:theme="@style/Theme.Natura.Dark">
  ...

</application>
```

2. Set the theme attribute in tag Activity at file AndroidManifest.XML

```android
<activity
  android:name=".components.ButtonActivity"
  android:theme="@style/Theme.Natura.Light" />
```

3. Define the theme attribute in the views XML file
  
  
```android 
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:theme="@style/Theme.Natura.Light">

    ...

 </LinearLayout>   
   ```
   
4) Set the theme using the setTheme() method in the views onCreate
```android
    setTheme(R.style.Theme_Natura_Light)
```

Our suggestion: always try to apply the DS theme to the most generic layers of your App. This
greatly simplifies the use.

But, if for some reason is not possible, fine. Define the theme locally in the view where you want
to apply DS.

### Design Tokens - The foundation of Nat DS

Now you get how to access DS themes, let's talk about the most basic portion of our DS: the design tokens. We call design tokens all the basic attributes of design systems. For example: colors, typography definitions, etc. Currently android lib provide the following tokens:

- Color
- Border-radius
- Elevation
- Font-family
- Font-weight
- Line-height
- Opacity
- Sizes
- Spacing

And how can this be used by applications? First of all, it is worth remembering that the components made available by DS are built from these tokens. In addition, you can explore our tokens to define your screens and components.

For example: you need to add text to a view that will be styled with the following attributes:

- Font Family: Roboto, sans-serif
- Font Size: 96sp
- Letter Spacing: 0.015625
- Font weight: Regular
- Lineheight: Medium (1.5)

You can set these attributes manually in an Android TextView component

 ```android
     <TextView
         android:id="@+id/textView"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:text="My Text"
         android:padlineSpacingMultipliering="1.5"
         android:textSize="96sp"
         android:textColor="#333333"/>
 ```

or you can simply use the Heading 1 typography token that has exactly these attributes:

  ```android
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Meu texto"
          android:textAppereance="?textAppereanceHeading1"/>
  ```

| Notice: we use ?textAppereanceHeading1 to fill the textAppereance attribute of the TextView component. When we write ?attributeName, we are indicating to Android that we want to pull this reference from the theme applied to this view. |
| --- |

Also, if you need to, for example apply a different color to your text. Okay! You can use a color
token for this:

  ```android
      <TextView
          android:id="@+id/textView"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:text="Meu texto"
          android:textAppereance="?textAppereanceHeading1"
          textColor:"?colorPrimary"/>
  ```

### Components

Components are a collection of interface elements used to create great and consistent user experiences. The currently available components are listed in [general Natura Group Design System documentation](https://ds.natura.design), with instructions and usage examples.

You can also check tokens and components by downloading from this repository and running the Sample App.


<!-- ## How to contribute
[Help us to grow!](doc/how-to-contribute.md) -->
