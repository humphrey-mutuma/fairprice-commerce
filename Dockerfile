# Use a base image with JDK
FROM openjdk:17-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml for dependency resolution
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download the dependencies (this will be cached if unchanged)
RUN ./mvnw dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Use a smaller base image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that your app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
