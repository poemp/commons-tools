@echo off

echo Install Jar To Local Maven
cd ..

call mvn clean install -Dmaven.test.skip=true

cd bin

pause