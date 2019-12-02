#!/bin/sh

if [ $TRAVIS_BRANCH = "master" -a $TRAVIS_PULL_REQUEST = "false" ]; then
    ./gradlew clean ktlintFormat ktlint build :sample:verifyDebugAndroidTestScreenshotTest -PdisablePreDex --stacktrace
#   ./gradlew clean ktlintFormat ktlint build :sample:verifyDebugAndroidTestScreenshotTest publish -PdisablePreDex --stacktrace
else
    ./gradlew clean ktlintFormat ktlint build :sample:verifyDebugAndroidTestScreenshotTest -PdisablePreDex --stacktrace
fi

