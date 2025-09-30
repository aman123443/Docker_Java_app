# Stage 1: Build the application using Maven and a full JDK
FROM eclipse-temurin:17-jdk-alpine as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker's layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the application source code
COPY src src

# Package the application into a .jar file
RUN ./mvnw package -DskipTests

# Stage 2: Create the final, smaller image with only the JRE and the application JAR
FROM eclipse-temurin:17-jre-alpine

# Set the working directory
WORKDIR /app

# Copy the packaged .jar file from the 'builder' stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on (Spring Boot default is 8080)
EXPOSE 8080

# The command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]