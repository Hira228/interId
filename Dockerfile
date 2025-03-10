FROM maven:3.8.1-openjdk-17-slim as base

COPY . .

RUN mvn resources:resources
RUN mvn clean install

FROM openjdk:17

COPY --from=base /target ./target
COPY ./src/main/resources /target

CMD ["java", "-jar", "./target/interid-0.0.1-SNAPSHOT.jar"]