#!/bin/bash
mkdir ./doc/html

npm install markdown-to-document -g --only=prod

for file in $(
  find . -path ./fastlane -prune -o \
  -name 'README.md' -type f -print
  find ./doc -iname "*.md" -type f -print
)
do
[[ $file = "./README.md" ]] && BASE_URL="https:\/\/github.com\/natura-cosmeticos\/natds-android\/blob\/master\/" || BASE_URL="https:\/\/github.com\/natura-cosmeticos\/natds-android\/blob\/master\/doc\/"
  echo "Working on $file file now"
  sed -i "s/](\(.*\).md)/]($BASE_URL\1.md)/g" $file
  mdtodoc "$file" --dest ./doc/html --layout "page" --theme "github" --numbered-headings --code-copy --mermaid
done

for file in $(find ./doc/html -type f -print)
do
  sed -i "s/<a\(.*\)/<a target='_blank'\1/g" $file
done