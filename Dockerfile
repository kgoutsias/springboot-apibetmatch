# Use the official OpenJDK 19 image as the base image
FROM openjdk:19-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/springboot-apibetmatch-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which your application is running (change if necessary)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
