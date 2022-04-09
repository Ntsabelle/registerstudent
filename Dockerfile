#BASE DOCKER IMAGE
FROM openjdk:11
LABEL maintainer = "Joseph reg student"
ADD target/registerstudent-0.0.1-SNAPSHOT.jar registerstudent-docker.jar
ENTRYPOINT ["java","-jar","registerstudent-docker.jar"]
