#!/bin/sh

SCRIPT_NAME=`basename "$0"`
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)

if [ ! -z $1 ] && [ "$1" != 'RELEASE' ] && [ "$1" != 'SNAPSHOT' ]
then
    echo "Final release artifacts are indicated by a second argument equal to: RELEASE"
    echo "USAGE: ./${SCRIPT_NAME} <SNAPSHOT|RELEASE> [container]"
    exit 1
fi

if [ -z $2 ]
then
  echo "Not a container deployment"
  if [ -z $1 ]
  then
    mvn clean deploy -DskipTests --batch-mode -Dsha1=${CURRENT_BRANCH}
  else
    mvn clean deploy -DskipTests --batch-mode -Dsha1=${CURRENT_BRANCH} -Dchangelist= build-helper:parse-version versions:set-property -Dproperty=revision \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion} --batch-mode \
    -Dmessage="[Artifact release] POM revision updated to \${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}, (artifact: '\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}-${CURRENT_BRANCH}' deployed)" \
    scm:checkin
  fi
else
  if [ "$2" != 'container' ]
  then
    if [ "$1" = 'RELEASE' ]
    then
      echo "Deploying production container"
#    mvn clean install -DskipTests=true -Dchangelist= jib:build
    else
      echo "Deploying snapshot container"
#    mvn clean install -DskipTests=true jib:build
    fi
  fi
fi