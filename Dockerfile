# Use a lightweight official OpenJDK base image
FROM eclipse-temurin:17-jdk-jammy as builder

# Set working directory
WORKDIR /app

# Copy everything (source, pom, mvnw, etc.)
COPY . .

# Give Maven wrapper execute permission
RUN chmod +x mvnw

# Build the project using the Maven wrapper (skip tests to speed up deploy)
RUN ./mvnw clean package -DskipTests

# ---- Production Stage ----
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port used by Spring Boot
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
