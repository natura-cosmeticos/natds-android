#!/bin/bash
set -e

echo "Building docs for ${1}"

if [[ $1 = "master" ]]; then
  make publish-docs

  echo "build docs success!"
fi
