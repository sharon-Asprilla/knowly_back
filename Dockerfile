# Etapa 1: Compilar con Maven y Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todo el código fuente
COPY . .

# Compila el proyecto y genera el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con solo Java
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia el JAR desde la etapa anterior
COPY --from=build /app/target/knowly_back-0.0.1-SNAPSHOT.jar app.jar

# Render asigna el puerto automáticamente
ENV PORT=8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
