# 🚀 Task Manager - Spring Boot Application

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-green.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-green.svg)](https://www.thymeleaf.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.2-purple.svg)](https://getbootstrap.com/)

## 📋 Descripción
Task Manager es una aplicación web moderna desarrollada con Spring Boot que permite a los usuarios gestionar sus tareas diarias de manera eficiente. La aplicación cuenta con un sistema de autenticación seguro y una interfaz de usuario intuitiva.

## 🛠️ Tecnologías Utilizadas
- **Backend**: Spring Boot 3.2.3
- **Frontend**: Thymeleaf + Bootstrap 5.3.2
- **Base de Datos**: PostgreSQL
- **Seguridad**: Spring Security
- **Autenticación**: BCrypt Password Encoder
- **Gestión de Dependencias**: Maven

## ✨ Características
- ✅ Sistema de autenticación y registro de usuarios
- ✅ Gestión CRUD de tareas
- ✅ Interfaz responsiva y moderna
- ✅ Validación de formularios
- ✅ Mensajes flash para feedback al usuario
- ✅ Protección CSRF
- ✅ Sesiones seguras

## 🚀 Estado del Proyecto
### Desarrollo Local ✅
- [x] Configuración inicial del proyecto
- [x] Implementación de seguridad
- [x] Sistema de autenticación
- [x] Gestión de tareas
- [x] Interfaz de usuario
- [x] Validaciones
- [x] Mensajes de feedback

### Próximos Pasos 🚧
- [ ] Despliegue en producción
- [ ] Implementación de pruebas unitarias
- [ ] Integración continua (CI/CD)
- [ ] Monitoreo y logging
- [ ] Optimización de rendimiento
- [ ] Documentación API

## 🛠️ Requisitos
- Java 17 o superior
- PostgreSQL 15 o superior
- Maven 3.6 o superior

## ⚙️ Configuración
1. Clona el repositorio:
```bash
git clone https://github.com/mat1520/Task-Manager-Springboot.git
```

2. Configura la base de datos PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
```

3. Ejecuta la aplicación:
```bash
./mvnw spring-boot:run
```

## 🔒 Seguridad
- Autenticación basada en formularios
- Contraseñas encriptadas con BCrypt
- Protección contra ataques CSRF
- Sesiones seguras con cookies HttpOnly
- Validación de entrada de datos

## 📱 Interfaz de Usuario
- Diseño responsivo con Bootstrap 5
- Iconos de Bootstrap Icons
- Mensajes flash para feedback
- Formularios validados
- Tema claro y moderno

## 🤝 Contribución
Las contribuciones son bienvenidas. Por favor, lee las guías de contribución antes de enviar un pull request.

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👥 Autor
- **Mat1520** - [GitHub](https://github.com/mat1520)

---
⭐️ Si te gusta el proyecto, no olvides darle una estrella en GitHub! 