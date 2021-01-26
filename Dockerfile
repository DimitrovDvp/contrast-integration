FROM java:8
COPY ./target/cs-project-0.0.1-SNAPSHOT.jar cs-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cs-project-0.0.1-SNAPSHOT.jar"]