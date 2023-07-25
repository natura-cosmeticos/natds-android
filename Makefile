build: clean
	./gradlew build

clean:
	./gradlew clean

unit-test: unit-test-designsystem unit-test-sample

unit-test-sample:
	./gradlew sample:test --parallel

unit-test-designsystem:
	./gradlew designsystem:test --parallel --info --scan

instrumentation-test: clean disable-animations
	./gradlew connectedAndroidTest

screenshot-test: clean install-tools-screenshot-test
	./gradlew verifyDebugAndroidTestScreenshotTest

update-screenshots: clean disable-animations install-tools-screenshot-test
	./gradlew recordDebugAndroidTestScreenshotTest

install-tools-screenshot-test:
	bash ./tools/screenshot-tools.sh

disable-animations:
	adb shell settings put global window_animation_scale 0
	adb shell settings put global transition_animation_scale 0
	adb shell settings put global animator_duration_scale 0

enable-animations:
	adb shell settings put global window_animation_scale 1
	adb shell settings put global transition_animation_scale 1
	adb shell settings put global animator_duration_scale 1

publish-ds-lib-prod: clean
	./gradlew build publish --stacktrace

run-all-pipeline-steps: unit-test instrumentation-test

update-icons:
	sh ./tools/update_icons.sh

update-themes:
	sh ./tools/update_themes.sh

bump-version:
	bash ./tools/bump_version.sh

finish-all-emulators:
	sh ./tools/finish_emulators.sh

publish-docs:
	bash ./tools/create_docs.sh

distribute-sample:
	sh bundle exec fastlane build
	fastlane build
	fastlane distribute_sample

send-release-notification-teams:
	sh ./tools/send_release_notification.sh

create-component-skeleton:
	sh ./tools/create_component_skeleton.sh $(component)
