#!/bin/sh
export HOME=/Volumes/lucky/Users/drgeb/Programming
export ALTERNATELOCATION=${HOME}/git/ReceiptEntry/target/alternateLocation
export JARFILE=${HOME}/git/ReceiptEntry/target/receiptentry.jar

export CLASSPATH=${ALTERNATELOCATION}/SmcGenerator-6.4.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/SmcParser-6.4.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/afterburner.fx-1.6.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/aopalliance-1.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/asm-3.3.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/cglib-2.2.2.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/commonj.sdo-2.1.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/commons-logging-1.1.3.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/derby-10.9.1.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/eclipselink-2.5.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/hamcrest-core-1.3.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jackson-annotations-2.4.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jackson-core-2.4.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jackson-core-asl-1.9.5.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jackson-databind-2.4.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jackson-mapper-asl-1.9.5.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/javaocr-core-1.1-SNAPSHOT.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/javax.persistence-2.1.0.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/jcl-over-slf4j-1.6.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/junit-4.11.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/log4j-1.2.16.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/slf4j-api-1.6.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/slf4j-log4j12-1.6.1.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-aop-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-beans-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-context-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-core-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-expression-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-security-config-3.2.5.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-security-core-3.2.5.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/spring-web-3.2.8.RELEASE.jar:${CLASSPATH}
export CLASSPATH=${ALTERNATELOCATION}/statemap-6.4.0.jar:${CLASSPATH}

java -cp ${CLASSPATH} -jar ${JARFILE}

#Using the javafx-maven-plugin
#mvn -o jfx:run


#1. Start the jetty server by
# cd /Volumes/lucky/Users/drgeb/Programming/git/JavaFX-Spring/server
#mvn jetty:run
