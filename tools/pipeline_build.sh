#!/bin/sh
# task :sample:verifyDebugAndroidTestScreenshotTest removed because of an instability in Travis emulator
if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ]; then
    ./gradlew clean build publish -PdisablePreDex --stacktrace
else
    ./gradlew clean build -PdisablePreDex --stacktrace
fi