# Design System Natura for Android

### What for
Library with Android components defined by [Natura Group Design System Team](https://zeroheight.com/25ddaa7f8/p/07a27e).

### Setup
For use this repository, you need [Git-LFS](https://git-lfs.github.com/). Please follow the instructions and install **Git-LFS** before starting your contribution to this repository.
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** and when generating you password.

**Important:** The file **github_credentials.properties** can not be commited.

### Library
In construction

### Testing
We are using [Screenshot Tests for Android](https://github.com/facebook/screenshot-tests-for-android) to validate our built components state, color and behavior.

**Tip from library page to build tests for the first time**
It is necessary to have python-2.7 installed for the gradle plugin to work, and we also recommending installing the python-pillow library which is required for recording and verifying screenshots.

## How to contribute

You can contribute submitting [pull requests](https://github.com/natura-cosmeticos/natds-android/pulls).

### How to create a new version
In the file **publish.gradle** update field in the method **getVersionName** with the new version number. Example, for the version 1.0.1:

    def getVersionName = { ->
        return "1.0.1"
    }

## How to use
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
    }
