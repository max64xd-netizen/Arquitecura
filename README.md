# Arquitectura Hexagonal - Gestión de Tareas

## Descripción del problema

En el ámbito académico, los estudiantes necesitan organizar sus actividades de forma clara y estructurada. Muchas veces no cuentan con una herramienta sencilla que les permita registrar, consultar y dar seguimiento a sus tareas.

Esta aplicación permite gestionar tareas académicas mediante operaciones básicas como:

* Crear
* Listar
* Completar
* Consultar tareas pendientes
* Eliminar tareas

---

## Estructura del proyecto

```
org.example.tareashexagonal
│
├── domain
│   ├── model
│   │   └── Tarea.java
│   ├── ports
│   │   ├── input
│   │   │   └── TareaUseCase.java
│   │   └── output
│   │       └── TareaRepositoryPort.java
│   ├── usecase
│   │   └── TareaUseCaseImpl.java
│   └── exceptions
│       └── GlobalExceptionHandler.java
│
├── infrastructure
│   ├── adapters
│   │   └── TareaRepositoryAdapter.java
│   ├── entrypoints
│   │   ├── dto
│   │   │   └── CrearTareaRequest.java
│   │   └── TareaController.java
│
├── config
│   └── BeanConfig.java
│
└── TareasHexagonalApplication.java
```

---

## Pasos para ejecutar

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA
3. Ejecutar la clase principal:

```
TareasHexagonalApplication.java
```

4. Verificar que el servidor esté corriendo en:

```
http://localhost:8080
```

---

## Pruebas con Postman

Crear tarea (POST)

```
http://localhost:8080/tareas
```

Body:

```json
{
  "titulo": "Estudiar",
  "descripcion": "Arquitectura hexagonal"
}
```

Listar tareas (GET)

```
http://localhost:8080/tareas
```

Completar tarea (PUT)

```
http://localhost:8080/tareas/{id}/completar
```

Ejemplo:

```
http://localhost:8080/tareas/1/completar
```

Eliminar tarea (DELETE)

```
http://localhost:8080/tareas/{id}
```

Ejemplo:

```
http://localhost:8080/tareas/1
```

---

## Tecnologías usadas

* Java 17
* Spring Boot
* Gradle
* Postman
* IntelliJ IDEA


## Explicación de puertos y adaptadores

Puertos de entrada (Input Ports)

* TareaUseCase
  Define las operaciones que el sistema puede realizar.

Puertos de salida (Output Ports)

* TareaRepositoryPort
  Define cómo el dominio se comunica con la persistencia.

Adaptadores de entrada

* TareaController
* CrearTareaRequest (DTO)

Reciben las peticiones HTTP y envían la información al dominio.

Adaptadores de salida

* TareaRepositoryAdapter

Implementa la persistencia utilizando una estructura en memoria (HashMap).

