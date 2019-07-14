FROM openjdk:11
ADD target/cloudproject1-0.0.1-SNAPSHOT.jar cloudproject1-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/Desktop/RESTFulApi-Election/target/cloudproject1-0.0.1-SNAPSHOT.jar"]
