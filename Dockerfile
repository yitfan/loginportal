FROM adoptopenjdk/maven-openjdk8 as build
COPY src /app
COPY pom.xml /app  
WORKDIR /app
RUN mvn install -X

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/loginportal-0.0.1-SNAPSHOT.jar /app
EXPOSE 8088
CMD ["java -jar loginportal-0.0.1-SNAPSHOT.jar"]