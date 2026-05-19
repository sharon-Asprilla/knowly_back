# Usa una imagen base con Java 17 (compatible con Render)
FROM eclipse-temurin:17-jdk

# Copia el archivo JAR generado por Maven
COPY target/knowly_back-0.0.1-SNAPSHOT.jar app.jar

# Render asigna el puerto automáticamente
ENV PORT=8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
