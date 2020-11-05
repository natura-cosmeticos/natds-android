#!/bin/sh
for file in $(find . -type d \( -path ./node_modules -o -path ./android -o -path ./ios \) -prune -o -iname "*.md" -print)
do
  echo "Working on $file file name now"
  mdtodoc $file --layout "page" --theme "github" --highlight-style "atom-one-light" --numbered-headings --code-copy --mermaid
done