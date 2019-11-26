#!/bin/sh

if [ $TRAVIS_BRANCH = "master" -a $TRAVIS_PULL_REQUEST = "false" ]; then
    ./gradlew clean ktlintFormat ktlint build :designsystem:verifyDebugAndroidTestScreenshotTest -PdisablePreDex --stacktrace
#   ./gradlew clean ktlintFormat ktlint build :designsystem:verifyDebugAndroidTestScreenshotTest publish -PdisablePreDex --stacktrace
else
    ./gradlew clean ktlintFormat ktlint build :designsystem:verifyDebugAndroidTestScreenshotTest -PdisablePreDex --stacktrace
fi

