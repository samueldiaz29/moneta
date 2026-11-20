# Stage 1: Build
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

COPY pom.xml ./pom.xml

COPY services/user-service/pom.xml ./services/user-service/pom.xml
COPY services/user-service/src ./services/user-service/src

WORKDIR /app/services/user-service

RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/services/user-service/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
