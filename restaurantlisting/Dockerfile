FROM eclipse-temurin:17.0.9_9-jdk-jammy
WORKDIR /opt
COPY target/*jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
