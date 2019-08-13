FROM openjdk:8-jre
WORKDIR /usr/src
ADD ./target/SpringBoot-MongoDB-0.0.1-SNAPSHOT.jar /usr/src/SpringBoot-MongoDB-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/SpringBoot-MongoDB-0.0.1-SNAPSHOT.jar"]