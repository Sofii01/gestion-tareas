# Aplicación de Gestión de Tareas

Proyecto backend desarrollado en **Java 17** con **Spring Boot** y **Arquitectura Hexagonal (Clean Architecture)**, enfocado en el diseño limpio y en prácticas de testing modernas.

Actualmente implementa 3 casos de uso:

- ✅ Crear tarea
- 📋 Obtener todas las tareas
- 🔍 Obtener tarea por ID

> ⚠️ El manejo de excepciones y los DTOs aún no están implementados, ya que el enfoque inicial está centrado en la estructura de dominio, la separación por capas y las pruebas automatizadas.

---

##  Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven 3.5+
- JPA + MySQL
- H2 (para pruebas)
- JUnit 5 + Mockito
- Docker + Docker Compose

---

## Cómo iniciar el proyecto

### 1. Clonar el repositorio

```
git clone <repo_url>
cd gestion-tareas
```
### 2. Crear archivo .env
   En la raíz del proyecto, crear un archivo .env con la siguiente configuración:
```
DB_HOST=mysql_container_name
DB_PORT=3306
DB_NAME=gestion_tareas
DB_USERNAME=root
DB_PASSWORD=tu_password
DB_OPTS=allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
```
📌 Recomiendo usar gestion_tareas como nombre de base de datos
### 3. Construir y levantar los contenedores
```
# Compilar el proyecto (el flag -DskipTests es opcional)
mvn clean package -DskipTests

# Construir la imagen Docker
docker build -t gestion_tareas .

# Levantar los contenedores con Docker Compose
docker-compose up --build
```
### Estructura del proyecto
```
src/
├── domain/           # Lógica de negocio (entidades y puertos)
├── application/      # Casos de uso (interactúan con el dominio)
├── infrastructure/   # Adaptadores y configuración (web, JPA, etc.)
└── config/           # Configuración de beans, properties, etc.
```

### 🛠️ TODO Próximo
- Implementación de DTOs para desacoplar la capa web
- Manejo global de excepciones con @ControllerAdvice 
- Endpoint para actualizar y eliminar tareas
- Documentación con Swagger 
- Seguridad (JWT o Basic Auth)