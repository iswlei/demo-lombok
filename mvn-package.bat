@echo off

set work_dir=%cd%

call mvn clean package -D maven.javadoc.skip=true  

::> mvn-package.log

pause



