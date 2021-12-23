#!/bin/bash

# create new file to edit
cp ./tools/message_teams.json ./tools/updated_message_teams.json

# get and update version at message
NEW_VERSION=`cat ./version.txt`
sed -i '' 's/VERSIONVALUE/'$NEW_VERSION'/g' ./tools/updated_message_teams.json

releaselinecontent='https://github.com/natura-cosmeticos/natds-android/compare/'

major=`echo $NEW_VERSION | cut -d. -f1`
minor=`echo $NEW_VERSION | cut -d. -f2`
patch=`echo $NEW_VERSION | cut -d. -f3`
rgxversion="v.$major\.$minor\.$patch" # regex for new version

# save last version output to file
awk 's{print $0 > "./tools/message_release.txt"}; $0~v {print $0 > "./tools/message_release.txt"; s=1; next}; (!($0~v) && $0~l) {s=0};' RS= v=$rgxversion l=$releaselinecontent CHANGELOG.md
# erase last line of file
sed -i '' -e '$ d' ./tools/message_release.txt

# write release message with line breaks
awk '{printf "%s\\\n ",$0 > "./tools/message_text.txt"} END {print ""}' ./tools/message_release.txt

# update release message at json
CHANGELOG_UPDATES=`cat ./tools/message_text.txt`
sed -i '' "s|CHANGELOGMESSAGE|$CHANGELOG_UPDATES|g" ./tools/updated_message_teams.json

# send message
message=`cat ./tools/updated_message_teams.json`
curl -H 'Content-Type: application/json' -d "$message" "$TEAMS_RELEASE_WEBHOOK"
# remove helper files
rm ./tools/updated_message_teams.json
rm ./tools/message_release.txt
rm ./tools/message_text.txt