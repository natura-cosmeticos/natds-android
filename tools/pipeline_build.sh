#!/bin/sh
# task :sample:verifyDebugAndroidTestScreenshotTest removed because of an instability in Travis emulator
if [ $TRAVIS_BRANCH = "master" -a $TRAVIS_PULL_REQUEST = "false" ]; then
    ./gradlew clean ktlintFormat ktlint build publish -PdisablePreDex --stacktrace
else
    ./gradlew clean ktlintFormat ktlint build -PdisablePreDex --stacktrace
fi

