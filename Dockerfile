FROM openjdk:11.0.12
EXPOSE 8080
ADD ./application-0.0.1-SNAPSHOT-jar-with-dependencies.jar application-0.0.1-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java","-jar","/application-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
