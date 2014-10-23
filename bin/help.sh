#!/bin/sh

declare GROUPID=com.salesforce.smc
declare ARTIFACTID=smc-plugin

mvn -o help:describe -Dmojo=describe -DgroupId=${GROUPID} -DartifactId=${ARTIFACTID}
