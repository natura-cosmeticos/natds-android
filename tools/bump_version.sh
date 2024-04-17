#!/bin/bash
git fetch

LAST_TAG=$(git describe --tags --abbrev=0)

RELEASE_TYPE="patch"

if git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^major:'; then
    RELEASE_TYPE="major"
elif git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^breaking:'; then
    RELEASE_TYPE="minor"
elif git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -i -E '^fix|^fixing|^adding|^bump version|feat|perf|refactor|revert'; then
    RELEASE_TYPE="patch"
fi

npx standard-version --release-as $RELEASE_TYPE

if [ "$LAST_TAG" == "$(git describe --tags --abbrev=0)" ]; then
    npx standard-version --release-as patch
fi

NATDS_VERSION=$(cat ./version.txt)

envman add --key NATDS_VERSION --value "$NATDS_VERSION"

git clean -f -d

if [ -n "$(git status --porcelain)" ]; then
    git commit -am "chore: Updates version"
    git push --follow-tags origin HEAD
else
    echo "No files to commit."
fi
