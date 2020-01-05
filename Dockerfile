FROM adoptopenjdk/maven-openjdk8 as build
WORKDIR /app
COPY --from=clone /app/loginportal /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/loginportal-0.0.1-SNAPSHOT.jar /app
EXPOSE 8088
CMD ["java -jar loginportal-0.0.1-SNAPSHOT.jar"]