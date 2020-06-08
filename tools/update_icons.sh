#!/bin/sh
cd designsystem/src/main/res/drawable
(ls -d outlined_* && ls -d filled_*) >> ../../../../../sample/src/main/assets/icons_map.txt
sed -i -e 's/.xml//g' ../../../../../sample/src/main/assets/icons_map.txt
rm -rf icons_map.txt-e