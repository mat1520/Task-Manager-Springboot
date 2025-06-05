# Usa una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto
COPY . .

# Da permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Construye el proyecto (descarga dependencias y compila)
RUN ./mvnw clean package -DskipTests

# Expone el puerto (Render usará la variable $PORT)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "target/todo-app-0.0.1-SNAPSHOT.jar"] 