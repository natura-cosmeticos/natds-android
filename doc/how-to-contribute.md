# How to contribute - WIP

Are you feeling that you can help us with anything in the project? Just get closer!!

There are many ways to contribute, check some of them:
## Do you want add something in the project? Just create a PR
We will review your PR, checking some criteria and if everything is fine, a new version of the lib will be publish with your contribution ASAP!

### Commits strcuture
To commit your PR, we indicate the usage of [Conversional Commits] (https://www.conventionalcommits.org/en/v1.0.0/).

The most common types the we use is:
Are you adding a new feature, your commit should look like: feat: [Short Description] [long description if you need]
Are you fixing a bug, your commit should look like: bug: [Short Description] [long description if you need]
Are you adding tests, your commig should look like: test: [Short Description] [long description if you need]

There are many other types that you can use to tag your commits: build:, chore:, ci:, docs:, style:, refactor:, perf:
[here you can find more infos about it](https://www.conventionalcommits.org/en/v1.0.0/).

#### Tool to help:
You can add an CLI to help you writing your commits. [Commitizen](https://github.com/commitizen/cz-cli) is the tool we use :)
##### Install the CLI
```bash
npm install -g commitizen
```
###### Do your work and commit
```bash
git add .
git cz
```

Commitizen will guide you about how to structure you commit

### Review criteria
Fine, now you should be asking your self, which critearia will be checked? Here some of them:
- Your code is covered by tests
- Your code is well strcutured, respecting SOLID principals
- Your code passed our automatic verifications (you can check the pipeline flow link in your PR) - and you can run this flow localy (check here for more info)
- You added a sample of the increment at Sample App (remember to updated the tests related to it)
- Your have made corresponding changes to the documentation
- Your changes generate no new warnings
- The component works fine with dark mode
- Your code uses DS design tokens

#### Do you find something that could be diferent in the lib and you want to let us know?
you can open an Issue and explain to us yout point. We're always checking new issues an working to keep your lib updated

#### Do you have any questions about the lib? Please contact us in XXXXXXX

## Setup Project
For use this repository, you need [Git-LFS](https://git-lfs.github.com/). Please follow the instructions and install **Git-LFS** before starting your contribution to this repository.
Copy and paste the file **github_credentials.properties.sample** and rename it to **github_credentials.properties**. Updating the fields **github.username** and **github.password**. For getting your GitHub password see the [Tutorial](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line). Its important to check **read:packages** and when generating you password.

**Important:** The file **github_credentials.properties** can not be commited.

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

### How to create a new version
In the file **publish.gradle** update field in the method **getVersionName** with the new version number. Example, for the version 1.0.1:

    def getVersionName = { ->
        return "1.0.1"
    }
