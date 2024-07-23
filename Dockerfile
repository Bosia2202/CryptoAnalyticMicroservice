FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /cryptoAnalyticMicroservice
COPY pom.xml .
COPY src ./src
RUN mvn clean package


FROM openjdk:17-slim
WORKDIR /cryptoAnalyticMicroservice
COPY --from=build /cryptoAnalyticMicroservice/target/*.jar cryptoAnalyticMicroservice.jar
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "./cryptoAnalyticMicroservice.jar"]