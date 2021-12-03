#!/bin/bash
git fetch
if \
    { git log "$( git describe --tags --abbrev=0 )..HEAD" --format='%s' | cut -d: -f1 | sort -u | sed -e 's/([^)]*)//' | grep -q -i -E '^feat|fix|perf|refactor|revert$' ; } || \
    { git log "$( git describe --tags --abbrev=0 )..HEAD" --format='%s' | cut -d: -f1 | sort -u | sed -e 's/([^)]*)//' | grep -q -E '\!$' ; } || \
    { git log "$( git describe --tags --abbrev=0 )..HEAD" --format='%b' | grep -q -E '^BREAKING CHANGE:' ; }
then
    npm_config_yes=true npx standard-version
    NATDS_VERSION=$(cat ./version.txt)
    envman add --key NATDS_VERSION --value "$NATDS_VERSION"
    git clean -f -d
    git commit -m "chore: Updates version"
    git push --follow-tags origin HEAD
else
    echo "No applicable changes since the previous tag, skipping..."
fi
