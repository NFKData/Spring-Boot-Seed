#!/bin/bash

function build_image {
    docker build -t nfkdata/spring-boot-seed:${TAG_NAME} --build-arg JAR_FILE=$(ls -l target | tr -s " " | cut -d " " -f 9 | grep spring-boot | grep -v original) .
}

function push_image {
    docker login ${REPOSITORY}
    docker push nfkdata/spring-boot-seed:${TAG_NAME}
}

SHOULD_BUILD=false
SHOULD_PUSH=false
TAG_NAME="latest"
REPOSITORY=""

while getopts ":bpt:r" opt; do
	case ${opt} in
		b)
			SHOULD_BUILD=true
		;;
		p)
			SHOULD_PUSH=true
		;;
        t)
            TAG_NAME=${OPTARG}
        ;;
        r)
            REPOSITORY=${OPTARG}
        ;;
		\?)
			echo -e "Invalid option: -${OPTARG}"
		;;
	esac
done

readonly SHOULD_BUILD
readonly SHOULD_PUSH

if [[ $SHOULD_BUILD = true ]]; then
    echo -e "Should Build: ${SHOULD_BUILD}"
    build_image
fi

if [[ $SHOULD_PUSH = true ]]; then
    echo -e "Should Push: ${SHOULD_PUSH}"
    push_image
fi