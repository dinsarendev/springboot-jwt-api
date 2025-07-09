# Stage 1: Build the application using Maven (Java 11)
FROM maven:3.9-eclipse-temurin-11 AS builder

# Set the working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Set timezone explicitly
ENV TZ=Asia/Phnom_Penh

# Configure the timezone in the container
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone

# Package the application
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk

# Set timezone in the runtime container too
ENV TZ=Asia/Phnom_Penh

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=builder /app/target/*.war app.jar

# Expose application port (change 8080 if your app uses a different port)
EXPOSE 30033

# Print timezone information before starting the app
RUN echo "Container timezone set to: $(date)"

# Run the Spring Boot application
ENTRYPOINT ["java","-Duser.timezone=Asia/Phnom_Penh","-jar", "/app/app.jar"]