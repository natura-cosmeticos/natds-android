        #!/bin/bash

# get most recent themes tag and save it to version-theme
git ls-remote --tags --sort="v:refname" https://github.com/natura-cosmeticos/natds-commons.git | grep "@naturacosmeticos/natds-themes@[0-9]*\.[0-9]*\.[0-9]*" | tail -n1 | sed 's/.*\///; s/\^{}//' > version-theme.txt

# get commons from github
domain='https://github.com/natura-cosmeticos/natds-commons/archive/refs/tags/@naturacosmeticos/'
version=`cat version-theme.txt`
extension='.tar.gz'

echo "Downloading from $domain$version$extension"
mkdir /tmp/natds
curl $domain$version$extension -J -L -o /tmp/natds/Themes.tar.gz
tar -xzvf /tmp/natds/Themes.tar.gz -C /tmp/natds

# copy themes folder from commons to project source files

rsync -av --exclude='theme_natdsTest_dark_ssot.xml' --exclude='theme_natdsTest_light_ssot.xml' /tmp/natds/*/packages/natds-themes/build/android/theme/* ./designsystem/src/main/res/values

echo "Themes copied to project source files"