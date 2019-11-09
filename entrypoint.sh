#!/bin/sh

echo -e ### ENV ###
env

echo -e ### START ###

java -Xms32m -Xmx512m -jar /opt/${JAR_FILE}