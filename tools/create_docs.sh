#!/bin/bash
mkdir ./doc/html

npm install markdown-to-document -g --only=prod

for file in $(
  find . -path ./fastlane -prune -o \
  -name 'README.md' -type f -print
  find ./doc -iname "*.md" -type f -print
)
do
  BASE_URL="https:\/\/natds-android-docs.netlify.app\/"
  echo "Working on $file file now"
  sed -i "s/](\(.*\).md)/]($BASE_URL\1.md)/g" $file
  mdtodoc $file --dest ./doc/html --layout "page" --theme "github" --numbered-headings --code-copy --mermaid
done