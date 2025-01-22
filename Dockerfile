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