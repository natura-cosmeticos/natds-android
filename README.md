# Design System Natura for Android

![release](https://img.shields.io/github/v/release/natura-cosmeticos/natds-android?style=for-the-badge)



### What for
Library with Android components defined by [Natura Group Design System Team](https://zeroheight.com/08f80f4e1/p/335165-natds--natura-design-system).

### Setup
For use this repository, you need [Git-LFS](https://git-lfs.github.com/). Please follow the instructions and install **Git-LFS** before starting your contribution to this repository.
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** and when generating you password.

**Important:** The file **github_credentials.properties** can not be commited.

### Getting Started
To start usign our lib, check [here](doc/getting-started.md).

### Testing with Screenshots
We are using [Screenshot Tests for Android](https://github.com/facebook/screenshot-tests-for-android) to validate our built components state, color and behavior.

**Tip from library page to build tests for the first time**
It is necessary to have python-2.7 installed for the gradle plugin to work, and we also recommending installing the python-pillow library which is required for recording and verifying screenshots.

#### Prerequisites
1 - Install python-pillow
```
$ pip install mock
$ pip install Pillow
```

2 - Configure emulator with follow mandatory details:
```
CPU/ABI: Google Play Intel Atom (x86)
Target: google_apis_playstore [Google Play] (API level 29)
Skin: pixel_2
hw.lcd.width: 1080
hw.lcd.height: 1920
hw.initialOrientation: Portrait
image.androidVersion.api: 29
tag.id: google_apis_playstore
hw.lcd.density: 420
```

#### Recording and Verifying screenshots
```
$ ./gradlew recordDebugAndroidTestScreenshotTest
$ ./gradlew verifyDebugAndroidTestScreenshotTest
```
All new screenshots will be recorded on folder `screenshots\<device_folder>`

#### Executing integration tests
```
$ ./gradlew clean connectedAndroidTest
```

### Sample
In construction

## How to contribute

You can contribute submitting [pull requests](https://github.com/natura-cosmeticos/natds-android/pulls).

### How to add resource icons
It is preferable that the icon resources are saved as vectors (XML format). The nomenclature of drawables must be `ds_ic_<pack>_<scope>_<name withuot separators>`.

For instance: `ds_ic_outlined_navigation_arrowbottom.xml`

### How to create a new version
In the file **publish.gradle** update field in the method **getVersionName** with the new version number. Example, for the version 1.0.1:

    def getVersionName = { ->
        return "1.0.1"
    }

## How to use

### How to add dependency
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** when generating you password.
In the file build.gradle, insert the informations:

    repositories {
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

### How to use Tokens
- Border Radius
- Color
- Elevation
- [Icons (drawables)](doc/icon-token.md)
- Opacity
- Size
- Spacing
- [Typography](doc/typography-token.md)

### How to use Components
- [App Bar Top](doc/app-bar-top.md)
- [Dialog](doc/dialog.md)
- Error
- [Expansion Panel](doc/expansion-panel.md)
- Ext
- Icon
- [Logo](doc/logo.md)
- Menu
- Navigation View
- Text Field
