# Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy necessary files
COPY pom.xml pom.xml
COPY src src/

# Build the application without running tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application with JRE only
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the JAR from the builder stage to the final stage
COPY --from=builder /app/target/*.jar app.jar

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
