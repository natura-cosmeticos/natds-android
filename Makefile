clean:
	./gradlew clean

lint:
	./gradlew ktlint

run-lint-rules:
	./gradlew ktlintFormat

unit-test: unit-test-designsystem unit-test-sample

unit-test-sample:
	./gradlew sample:test --info --parallel

unit-test-designsystem:
	./gradlew designsystem:test --info --parallel

instrumentation-test: clean disable-animations
	./gradlew connectedAndroidTest

screenshot-test: clean
	./gradlew verifyDebugAndroidTestScreenshotTest

update-screenshots: clean
	./gradlew recordDebugAndroidTestScreenshotTest

disable-animations:
	adb shell settings put global window_animation_scale 0
	adb shell settings put global transition_animation_scale 0
	adb shell settings put global animator_duration_scale 0

enable-animations:
	adb shell settings put global window_animation_scale 1
	adb shell settings put global transition_animation_scale 1
	adb shell settings put global animator_duration_scale 1