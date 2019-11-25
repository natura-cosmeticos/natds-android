#!/bin/sh

if [ $TRAVIS_BRANCH = "master" -a $TRAVIS_PULL_REQUEST = "false" ]; then
    ./gradlew clean ktlintFormat ktlint build -PdisablePreDex --stacktrace
#   ./gradlew clean ktlintFormat ktlint build publish -PdisablePreDex --stacktrace
else
    ./gradlew clean ktlintFormat ktlint build  -PdisablePreDex --stacktrace
fi

