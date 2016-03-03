# Base Docker-Image
# ===
FROM codenvy/jdk7

# Verzeichnis für Camunda-Installation erstellen
# Camunda-Wildfly-Dist herunterladen und entpacken
# ===
RUN mkdir /home/user/camunda && \
wget \
-qO- \
"http://camunda.org/release/camunda-bpm/wildfly/7.3/camunda-bpm-wildfly-7.3.0.tar.gz" | tar -zx -C /home/user/camunda/

# Wildfly-Config anpassen
# ===
RUN cd /home/user/camunda/server/wildfly-8.2.0.Final/standalone/configuration/ && \
sed -i 's/enable-welcome-root="true"/enable-welcome-root="false"/g' standalone.xml && \
sed -i 's/127.0.0.1/0.0.0.0/g' standalone.xml && \
sed -i 's/<deployment-scanner/<deployment-scanner auto-deploy-exploded="true"/g' standalone.xml

# Wildfly-Port bei Codenvy registrieren 
# ===

# DEFAULT MODE
# ---
EXPOSE 8080
ENV CODENVY_APP_PORT_8080_HTTP 8080

# DEBUG MODE
# ---
# EXPOSE 8000
# ENV CODENVY_APP_PORT_8000_DEBUG 8000
# ENV JAVA_OPTS "-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"

# Anwendung auf Server Kopieren
ADD $build$ /home/user/camunda/server/wildfly-8.2.0.Final/standalone/deployments/

# Server starten
WORKDIR /home/user/camunda/server/wildfly-8.2.0.Final/bin/
CMD ./standalone.sh