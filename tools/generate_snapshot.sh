#!/bin/sh
if [ -n "${BITRISE_GIT_BRANCH+x}" ];
then
  eval git tag -a "$BITRISE_GIT_BRANCH-SNAPSHOT" -m "$BITRISE_GIT_BRANCH-SNAPSHOT"
  eval git push origin "$BITRISE_GIT_BRANCH-SNAPSHOT"
else
  echo "Only works on CI Bitrise"
fi