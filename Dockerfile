FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY . /app

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/idenficator-0.0.1-SNAPSHOT.jar"]

