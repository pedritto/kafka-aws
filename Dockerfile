FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]