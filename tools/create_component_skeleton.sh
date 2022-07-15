#!/bin/bash

# Removes spacing, special characters and converts to uppercase and lowercase.
lower_case_name=$(echo "$1" | tr '[:upper:]' '[:lower:]' | tr -dc '[:alnum:]\n\r' | tr -d '[:space:]')
upper_case_name=$(echo "$1" | tr '[:lower:]' '[:upper:]' | tr -dc '[:alnum:]\n\r' | tr -d '[:space:]')
capital_case_name=$(echo "${lower_case_name:0:1}" | tr  '[a-z]' '[A-Z]')${lower_case_name:1}

SKELETON_PATH="./tools/skeleton"
COMPONENT_CLASS_PATH="./designsystem/src/main/kotlin/com/natura/android"
COMPONENT_LAYOUT_PATH="./designsystem/src/main/res/layout"
COMPONENT_UNIT_TEST_PATH="./designsystem/src/test/kotlin/com/natura/android"
COMPONENT_DOC_PATH="./doc/"

COMPONENT_ACTIVITY_CLASS_PATH="./sample/src/main/kotlin/com/natura/android/sample/components"
COMPONENT_ACTIVITY_LAYOUT_PATH="./sample/src/main/res/layout"


# Copies component files (kotlin and xml) to their respective folders, renames them and adapts the component names in the class.
mkdir -p $COMPONENT_CLASS_PATH/"${lower_case_name}"
cp -r $SKELETON_PATH/Component.kt $COMPONENT_CLASS_PATH/"${lower_case_name}"/
mv $COMPONENT_CLASS_PATH/"${lower_case_name}"/Component.kt $COMPONENT_CLASS_PATH/"$lower_case_name/$capital_case_name.kt"

sed -i '' -e "s/component/$lower_case_name/g" $COMPONENT_CLASS_PATH/"$lower_case_name/$capital_case_name.kt"
sed -i '' -e "s/COMPONENT/$upper_case_name/g" $COMPONENT_CLASS_PATH/"$lower_case_name/$capital_case_name.kt"
sed -i '' -e "s/Component/$capital_case_name/g" $COMPONENT_CLASS_PATH/"$lower_case_name/$capital_case_name.kt"

read -p "Do you need a xml layout file to build the component? (y/n)" -n 1 -r
echo    # (optional) move to a new line
if [[ $REPLY =~ ^[Yy]$ ]]
then
  cp -r $SKELETON_PATH/component.xml $COMPONENT_LAYOUT_PATH/
  mv $COMPONENT_LAYOUT_PATH/component.xml $COMPONENT_LAYOUT_PATH/"$lower_case_name.xml"
fi

# Copies documentation file (Markdown) to their respective folder and renames it.
cp -r $SKELETON_PATH/component.md $COMPONENT_DOC_PATH/
mv $COMPONENT_DOC_PATH/component.md $COMPONENT_DOC_PATH/"$lower_case_name.md"

# Copies unit test file (Kotlin) to their respective folder, renames it and adapts the component names in the class.
mkdir -p $COMPONENT_UNIT_TEST_PATH/"${lower_case_name}"
cp -r $SKELETON_PATH/ComponentTest.kt  $COMPONENT_UNIT_TEST_PATH/"${lower_case_name}"/
mv $COMPONENT_UNIT_TEST_PATH/"${lower_case_name}"/ComponentTest.kt $COMPONENT_UNIT_TEST_PATH/"$lower_case_name/$capital_case_name""Test.kt"

sed -i '' -e "s/component/$lower_case_name/g" $COMPONENT_UNIT_TEST_PATH/"$lower_case_name/$capital_case_name""Test.kt"
sed -i '' -e "s/COMPONENT/$upper_case_name/g" $COMPONENT_UNIT_TEST_PATH/"$lower_case_name/$capital_case_name""Test.kt"
sed -i '' -e "s/Component/$capital_case_name/g" $COMPONENT_UNIT_TEST_PATH/"$lower_case_name/$capital_case_name""Test.kt"

# Copies activity files (kotlin and xml) to their respective folders, renames them and adapts the component names in the class.
cp -r $SKELETON_PATH/ComponentActivity.kt $COMPONENT_ACTIVITY_CLASS_PATH/
mv $COMPONENT_ACTIVITY_CLASS_PATH/ComponentActivity.kt $COMPONENT_ACTIVITY_CLASS_PATH/"$capital_case_name""Activity.kt"

sed -i '' -e "s/COMPONENT/$upper_case_name/g" $COMPONENT_ACTIVITY_CLASS_PATH/"$capital_case_name""Activity.kt"
sed -i '' -e "s/Component/$capital_case_name/g" $COMPONENT_ACTIVITY_CLASS_PATH/"$capital_case_name""Activity.kt"

cp -r $SKELETON_PATH/activity_component.xml $COMPONENT_ACTIVITY_LAYOUT_PATH/
mv $COMPONENT_ACTIVITY_LAYOUT_PATH/activity_component.xml $COMPONENT_ACTIVITY_LAYOUT_PATH/"activity_""$lower_case_name.xml"

# Adds activity at manifest
sed -i '' -e "s/<\/application>/    <activity \n            android:name=\".components."$capital_case_name"Activity""\" \n            android:theme=\"@style\/Theme.Natura.Light\" \/>\n    <\/application>/g" sample/src/main/AndroidManifest.xml