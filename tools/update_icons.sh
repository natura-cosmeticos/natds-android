#!/bin/bash

NATDS_ICON_VERSION="$(grep -o "iconsVersion\s=\s.*" build.gradle | awk '{ print $3 }' | tr -d \''"\')"
# get commons from github
domain='https://raw.githubusercontent.com/natura-cosmeticos/natds-commons/@naturacosmeticos/natds-icons@'
path="/packages/natds-icons/dist/"
file="natds-icons.txt"

echo "Downloading from $domain$NATDS_ICON_VERSION"$path$file
curl -L $domain"$NATDS_ICON_VERSION"$path$file -o sample/src/main/assets/icons_map.txt