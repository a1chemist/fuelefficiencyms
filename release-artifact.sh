#!/bin/sh

SCRIPT_NAME=`basename "$0"`
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)

if [ ! -z $1 ] && [ "$1" != 'RELEASE' ]
then
    echo "Final release artifacts are indicated by a second argument equal to: RELEASE"
    echo "USAGE: ./${SCRIPT_NAME} [RELEASE]"
    exit 1
fi

if [ -z $1 ]
then
    mvn clean deploy -DskipTests --batch-mode -Dsha1=${CURRENT_BRANCH}
else
    mvn clean deploy -DskipTests --batch-mode -Dsha1=${CURRENT_BRANCH} -Dchangelist= build-helper:parse-version versions:set-property -Dproperty=revision \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion} --batch-mode \
    -Dmessage="[Artifact release] POM revision updated to \${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}, (artifact: '\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}-${CURRENT_BRANCH}' deployed)" \
    scm:checkin
fi
