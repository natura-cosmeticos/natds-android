#!/bin/sh
cd designsystem/src/main/res/drawable
rm -rf ../../../../../sample/src/main/assets/icons_map.txt
(ls -d outlined_* && ls -d filled_*) >> ../../../../../sample/src/main/assets/icons_map.txt
sed -i -e 's/.xml//g' ../../../../../sample/src/main/assets/icons_map.txt
rm -rf ../../../../../sample/src/main/assets/icons_map.txt-e
