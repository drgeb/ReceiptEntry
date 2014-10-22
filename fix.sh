#!/bin/sh
mvn -o clean
mvn -o smc:smc
mvn -o compile
mvn -o site -DskipTests
