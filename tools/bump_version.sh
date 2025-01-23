#!/bin/bash
git fetch

if [ -n "$MANUAL_VERSION" ]; then
    echo "Definindo versão manual: $MANUAL_VERSION"
    npx standard-version --release-as "$MANUAL_VERSION"
else
    LAST_TAG=$(git describe --tags --abbrev=0)

    if git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^\s*major:'; then
        npx standard-version --release-as major
    elif git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^\s*breaking:'; then
        npx standard-version --release-as minor
    else
        npx standard-version --release-as patch
    fi
fi

NATDS_VERSION=$(cat ./version.txt)

envman add --key NATDS_VERSION --value "$NATDS_VERSION"

git clean -f -d
git commit -m "chore: Updates version"
git push --follow-tags origin HEAD

