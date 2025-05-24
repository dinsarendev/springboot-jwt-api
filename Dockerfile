# Stage 1: Build the application using Maven (Java 11)
FROM maven:3.9-eclipse-temurin-11 AS builder

WORKDIR /app
COPY pom.xml pom.xml
COPY src src/
RUN mvn clean package -DskipTests

# Stage 2: Run the application with Java 11 JRE
FROM eclipse-temurin:11-jre

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
