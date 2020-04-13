clean:
	./gradlew clean

lint:
	./gradlew ktlint

unit-test: unit-test-designsystem unit-test-sample

unit-test-sample:
	./gradlew sample:test --info --parallel

unit-test-designsystem:
	./gradlew designsystem:test --info --parallel

instrumentation-test: clean
	./gradlew connectedAndroidTest

screenshot-test: clean
	./gradlew verifyDebugAndroidTestScreenshotTest

update-screenshots: clean
	./gradlew recordDebugAndroidTestScreenshotTest