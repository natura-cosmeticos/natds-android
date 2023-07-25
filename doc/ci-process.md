# NatDS CI

The Continuous Integration of NatDS Android code occurs at Bitrise environment. There are some triggers to starts the pipeline process:

## Create a pull request
When pull request is created, Bitrise runs unit, instrumented and screenshot tests, and publishes a library snapshot version on Jitpack.

## Push at the master
When a push is done at master, Bitrise runs unit, instrumented and screenshot tests, and publishes a sampleapp artifactory for tests.

## Push tag following the format (v.\*\*\*)
When a tag is pushed in repository, Bitrise publishes a new version of library at production. To do this successfully, it's necessary to update library version at the file `publish.gradle.
