#!/bin/sh
mkdir ./doc/html

#npm install markdown-to-document -g --only=prod

for file in $(
  find . -path ./fastlane -prune -o \
  -name 'README.md' -type f -print
  find ./doc -iname "*.md" -type f -print
)
do
  declare BASE_URL="https:\/\/github.com\/natura-cosmeticos\/natds-android\/blob\/master\/doc\/"

  if [ $file == './README.md' ]
    then BASE_URL="https:\/\/github.com\/natura-cosmeticos\/natds-android\/blob\/master\/"
  fi

  echo "Working on $file file now"
  sed -i -E "s/](\(.*\).md)/]($BASE_URL\1.md)/g" $file
  mdtodoc $file --dest ./doc/html --layout "page" --theme "github" --numbered-headings --code-copy --mermaid
done