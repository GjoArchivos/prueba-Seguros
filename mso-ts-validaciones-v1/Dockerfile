# Imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# JAR generado por Maven
COPY target/mso-ts-validaciones-v1-1.0.0.jar app.jar

# Puerto del microservicio
EXPOSE 8082

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]