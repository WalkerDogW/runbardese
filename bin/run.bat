
set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

start BadeseApi  -jar %JAVA_OPTS% runbardese-admin.jar



pause