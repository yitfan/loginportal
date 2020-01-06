FROM adoptopenjdk/maven-openjdk8 as build
COPY src /app
COPY pom.xml /app  
WORKDIR /app
RUN mvn clean package

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target /app
EXPOSE 8088
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar loginportal-0.0.1-SNAPSHOT.jar"]