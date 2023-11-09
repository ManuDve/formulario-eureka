# Introducción

Proyecto de API Rest que funciona en conjunto al proyecto de [Formulario Eureka Front End](https://github.com/ManuDve/formulario-eureka-front)

## Prerequisitos de instalación

- Instalar [Spring Boot Tools con Eclipse](https://spring.io/tools)
- Instalar [JDK 17](https://jdk.java.net/java-se-ri/17)
- Instalar [Postman](https://www.postman.com/downloads/), crear una cuenta e iniciar sesión
- Instalar el plugin [Lombok 1.18.30](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30) en el IDE

## Configuración Inicial Spring Boot Tools

- Clonar el repositorio localmente

```
git clone https://github.com/ManuDve/formulario-eureka-back.git
```

- Importar Proyecto desde el File System
- Cargar las dependencias con Maven
- Levantar la intancia `formulario-eureka`

### Consola H2

Luego de levantar el servicio, se puede acceder a la consola de la base de datos a través de la siguiente URL
```
http://localhost:8080/formulario-h2
```

Las credenciales son:
```
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:formulario-db
user: sa
password: 
```

### Endpoints

Utilizando Postman, se exponen los siguientes endpoints a través del Gateway-Sever con puerto 8080

#### GET

```
http://localhost:8080/api/departamentos
```

```
http://localhost:8080/api/personas
```

Estos pueden aceptar parámetros por **ID**, por ejemplo:

```
http://localhost:8090/api/departamentos/{id}
```

```
http://localhost:8080/api/departamentos/2
```

#### POST

Debe ser realizado con la siguiente estructura **JSON**:

- Departamentos

```
http://localhost:8080/api/departamentos
```

```json
{
    "nombre": "Finanzas"
}
```

El parámetro de nombre es **único e irrepetible**.

```
http://localhost:8080/api/personas
```

Luego de crear un departamento, las personas llevan la ID del departamento al cual pertenecen:

```json
{
    "nombre": "Juan",
    "email": "juan@gmail.com",
    "departamento": {
        "id": 1
    }
}
```

```json
{
    "nombre": "Roberto",
    "email": "Roberto@gmail.com",
    "departamento": {
        "id": 1
    }
}
```
```json
{
    "nombre": "Claudia",
    "email": "claudia@gmail.com",
    "departamento": {
        "id": 2
    }
}
```

El parámetro con la ID de la organización es **obligatorio** y el email es **único e irrepetible**.
