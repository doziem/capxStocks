# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY --from=build /app/target/capxStockProject-0.0.1-SNAPSHOT.jar capxStockProject.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "capxStockProject.jar"]

# Use official PostgreSQL image from Docker Hub
FROM postgres:latest

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=agbo1212#
ENV POSTGRES_DB=capxStocks

# Expose port 5432 (PostgreSQL default port)
EXPOSE 5432