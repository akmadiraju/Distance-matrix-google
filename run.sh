#!/bin/sh

mvn clean
echo "**************mvn clean Completed **************"
mvn -U clean install

echo "************** mvn clean install Completed Successfully **************"
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n        -jar target/distance-matrix-0.0.1-SNAPSHOT.jar