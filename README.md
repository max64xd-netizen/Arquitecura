# Arquitecura hexagonal

---Descripción del problema
En el ámbito académico, los estudiantes necesitan organizar sus actividades de forma clara y estructurada. Muchas veces no cuentan con una herramienta sencilla que les permita registrar, consultar y dar seguimiento a sus tareas.

Esta aplicación resuelve ese problema permitiendo gestionar tareas académicas mediante operaciones básicas como 
-crear
-listar
-completar
-consultar pendientes
-eliminar tareas

---Estructura del proyecto

├──org.example.tareashexagonal
 ├── domain │ 
      ├── model  
      │   └── Tarea.java 
      ├── ports │ 
           ├── input 
                └── TareaUseCase.java 
      ├── output │
           └── TareaRepositoryPort.java
      ├── usecase 
           └── TareaUseCaseImpl.java
      ├── exceptions
            └── GlobalExceptionHandler.java
      ├── infrastructure 
           ├── adapters
                └── TareaRepositoryAdapter.java    
           ├── entrypoints 
                ├── dto
                   └── CrearTareaRequest.java
           ├──TareaController.java 
├──BeaConfig
├──TareasHexagonalApplication

---Pasos para ejecutar

-Clonar el repositorio:
-Abrir el proyecto en IntelliJ IDEA
-Ejecutar la clase principal:
-TareasHexagonalApplication.java
-Verificar que el servidor esté corriendo en:
-http://localhost:8080

---Pruebas con Postman
--Crear tarea (POST)
http://localhost:8080/tareas

Body 
{
  "titulo": "Estudiar",
  "descripcion": "Arquitectura hexagonal"
}

--Listar tareas (GET)
http://localhost:8080/tareas

--Completar tarea (PUT)
http://localhost:8080/tareas/(id de la tarea)/completar 
ejemplo 
http://localhost:8080/tareas/1/completar

--Eliminar tarea (DELETE)
http://localhost:8080/tareas/(id de la tarea)
ejemplo
http://localhost:8080/tareas/1


---Tecnologías usadas
-Java 17
-Spring Boot
-Gradle
-Postman 
-IntelliJ IDEA

---Explicación de puertos y adaptadores

--Puertos de entrada (Input Ports)
-TareaUseCase
Define las operaciones que el sistema puede realizar (crear, listar, completar, etc.)

--Puertos de salida (Output Ports)
-TareaRepositoryPort
Define cómo el dominio se comunica con la persistencia de datos, sin depender de una implementación específica.

--Adaptadores de entrada
-TareaController
-CrearTareaRequest (DTO)
Reciben las peticiones HTTP y transforman los datos para el dominio.

--Adaptadores de salida
-TareaRepositoryAdapter
Implementa la persistencia usando memoria (HashMap).
