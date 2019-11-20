#!/bin/sh

if [ $TRAVIS_BRANCH = "master" -a $TRAVIS_PULL_REQUEST = "false" ]; then
    ./gradlew clean build publish -PdisablePreDex --stacktrace
else
    ./gradlew clean build -PdisablePreDex --stacktrace
fi

