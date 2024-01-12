#! /bin/bash

# Set Environment Variables
#export DERBY_HOME=/app/ext/
#export CLASSPATH=$DERBY_HOME/derby-10.17.1.0.jar:$DERBY_HOME/derbytools-10.17.1.0.jar:$DERBY_HOME/derbyoptionaltools-10.17.1.0:$DERBY_HOME/derbyshared-10.17.1.0.jar:.

# Create derby database
java -Dij.protocol=jdbc:derby: -Dij.database="schoolDB;create=true" org.apache.derby.tools.ij ../schoolDB.sql
