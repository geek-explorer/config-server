#!/bin/ksh
nohup /usr/java/jdk1.8.0_191/bin/java -jar -Dspring.config.location=/app/cce/services/config-server/conf/application.yml -Djavax.net.ssl.trustStore=/app/cce/services/config-server/keystore/STCodexGitKeyStore -Djasypt.encryptor.password=stcam cam-config-server-1.0-SNAPSHOT.jar > /dev/null 2>&1
~

