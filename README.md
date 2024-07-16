# Proyecto de Literatura

Este proyecto es una aplicación de literatura construida con Spring Boot y Java.

## Descripción

La aplicación permite a los usuarios interactuar con datos de libros y autores. La aplicación puede interactuar con una base de datos y posiblemente con una API externa para obtener y manipular datos.

Las entidades principales en la aplicación son `Autor`, `Libros`, `DatosGenerales` y `DatosLibros`, que están mapeadas a la base de datos utilizando JPA (Java Persistence API).

El repositorio `LibrosRepository` proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) en la entidad `Libros`.

La clase `LiteraturaApplication` es la clase principal de la aplicación Spring Boot. Implementa `CommandLineRunner`, lo que significa que ejecuta algún código cuando la aplicación se inicia.

El servicio `MenuService` se utiliza para mostrar un menú al usuario.

Las clases `DatosGenerales` y `DatosLibros` están relacionadas con la serialización y deserialización de datos, utilizando anotaciones de la biblioteca Jackson para mapear los datos JSON a objetos Java.

## Instalación

Para instalar y ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Navega hasta el directorio del proyecto.
3. Ejecuta `mvn clean install` para construir el proyecto.
4. Ejecuta `mvn spring-boot:run` para iniciar la aplicación.

## Contribución

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir lo que te gustaría cambiar.

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)
