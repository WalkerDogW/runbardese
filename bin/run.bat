@echo off
echo.
echo [信息] 运行Web工程。
echo.

cd %~dp0

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

start BadeseApi -jar -jar %JAVA_OPTS% runbardese-admin.jar

cd bin
pause