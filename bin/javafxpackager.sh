#!/bin/sh
declare SRCDIR=src/main/java
declare APPCLASS=com.drgeb.receiptentry.App
declare SRCDIR=target/classes
declare OUTDIR=target/javapackager
declare OUTFILE=fileout
declare WIDTH=34
declare HEIGHT=43
declare APPNAME=RECEIPTENTRY

#javapackager  -createbss -srcdir ${SRCDIR}  -outdir ${OUTDIR}

#javapackager -createjar -appclass ${APPCLASS} -srcdir ${SRCDIR} -outdir ${OUTDIR} -outfile ${OUTFILE} -v

##javafxpackager -deploy

javapackager -deploy -outdir ${OUTDIR} -outfile ${OUTFILE}  -width ${WIDTH} -height ${HEIGHT} -name ${APPNAME} -appclass ${APPCLASS} -v -srcdir ${SRCDIR}

#javapackager -makeall -appclass ${APPCLASS} -name ${APPNAME} -width ${WIDTH} -height ${HEIGHT}
