FROM maven:3.6-jdk-8

WORKDIR /code

ADD pom.xml /code/pom.xml
ADD src /code/src
RUN ["mvn", "clean", "package"]
RUN ["ls","-l","/code/target"]
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/code/target/haier-java-demo:0.0.1-SNAPSHOT.jar" ]