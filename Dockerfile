# Use an OpenJDK runtime as a parent image for building the application
FROM openjdk:21-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

# Grant execution rights to the Maven wrapper script
RUN chmod +x ./mvnw

# Package the application to a JAR file
RUN ./mvnw clean package -DskipTests

# Use an OpenJDK runtime as a parent image for running the application
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar /app/nami.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/nami.jar"]