#!/bin/sh

source ~/.profile
mvn clean
echo "**************mvn clean Completed **************"
mvn -Dmaven.test.skip=true -U clean install

echo "************** mvn clean installCompleted **************"

if [ $1 == "debug" ]
then
java -Dspring.active.profile=local -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
-jar target/distance-matrix-0.0.1-SNAPSHOT.jar
else
java -Dspring.active.profile=local -jar target/distance-matrix-0.0.1-SNAPSHOT.jar
fi