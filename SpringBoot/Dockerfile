FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/SpringBoot-1.0-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8081
CMD ["java", "-jar", "SpringBoot-1.0-SNAPSHOT.jar"]