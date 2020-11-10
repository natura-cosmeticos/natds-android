#!/bin/sh
mkdir ./doc/html

npm install markdown-to-document -g --only=prod

for file in $(
  find . -path ./fastlane -prune -o \
  -name 'README.md' -type f -print
  find ./doc -iname "*.md" -type f -print
)
do
  echo "Working on $file file now"
  mdtodoc $file --dest ./doc/html --layout "page" --theme "github" --numbered-headings --code-copy --mermaid
done