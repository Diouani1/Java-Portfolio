# Use Java 21 for both build and runtime
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app
COPY . .
# 🔧 Copy the local.properties from Render secrets
COPY /etc/secrets/local.properties ./local.properties
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---- Production Stage ----
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
