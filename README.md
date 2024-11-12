# Proyecto de Pruebas Unitarias con Mockito en Java

Este proyecto tiene como objetivo mostrar la implementación de **pruebas unitarias** en un proyecto Java usando **Spring Boot**, **JPA** y **Mockito**. Las pruebas se enfocan en verificar el comportamiento de los servicios de la aplicación mediante el uso de mocks, asegurando así la funcionalidad de cada componente de manera aislada.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot** - para la estructura de la aplicación y configuración de dependencias
- **Spring Data JPA** - para el manejo de la persistencia con una base de datos MySQL
- **Mockito** - para simular (mockear) dependencias y realizar pruebas unitarias
- **JUnit 5** - para la ejecución de pruebas

## Estructura del Proyecto

- **Entidades**: `Autor` y `Libro`, que representan tablas en la base de datos.
- **Repositorios**: `AutorRepository` y `LibroRepository`, que extienden `JpaRepository` para facilitar las operaciones CRUD.
- **Servicios**: `AutorService` y `LibroService`, que contienen la lógica de negocio.
- **Controladores**: `AutorController` y `LibroController`, que manejan las solicitudes HTTP.

## Configuración de la Base de Datos

El proyecto está configurado para conectarse a una base de datos MySQL. Los parámetros de conexión se encuentran en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Asegúrate de reemplazar `tu_base_de_datos`, `tu_usuario`, y `tu_contraseña` con los valores adecuados para tu entorno.

**NOTA: Este ejemplo no pretende mostrar el funcionamiento de la aplicación haciendo una conexión a la DB, solo se centra en el uso de Mockito para generar las pruebas unitarias**

## Ejecución de Pruebas Unitarias

Las pruebas unitarias están implementadas en la clase `AutorServiceTest`. Estas pruebas utilizan Mockito para simular el repositorio (`AutorRepository`) y probar el servicio (`AutorService`) de forma aislada.

Las pruebas incluyen:
- **Métodos Básicos de Mockito**: Uso de `when` y `verify` para simular y verificar interacciones con el repositorio.
- **Manejo de Excepciones**: Uso de `doThrow` para verificar el manejo de errores en métodos específicos.
- **Validaciones de Llamadas**: Uso de `times` y `never` para asegurar que los métodos se llamen el número de veces esperado.

### Ejemplo de Ejecución de Pruebas

Para ejecutar las pruebas se recomienda utilizar la herramienta que provee el IDE (Tal como se muestra en el video de la práctica)

👉🏽 [Video en el canal de YouTube]()

## Contribuciones

Las contribuciones son bienvenidas. Si tienes sugerencias o mejoras, no dudes en crear un pull request o abrir un issue.

## Licencia

Este proyecto está licenciado bajo la [MIT License](https://es.wikipedia.org/wiki/Licencia_MIT).

---

Este proyecto es una guía para implementar pruebas unitarias utilizando Mockito en un entorno de Spring Boot con persistencia JPA. Es ideal para desarrolladores que deseen aprender o mejorar sus habilidades en la escritura de pruebas unitarias en aplicaciones Java.