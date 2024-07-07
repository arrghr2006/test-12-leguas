FROM alpine/java:22-jdk
COPY target/vehiculos-service-1.0.0-SNAPSHOT.jar /opt/app/app.jar
CMD ["java","-jar","/opt/app/app.jar"]