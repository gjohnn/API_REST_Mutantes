
# ADN Mutantes
#### Programacion III
#### Alumno:  Guerrero, Juan

En este repositorio esta la API REST del parcial de ADN_MUTANTES.

Dentro de la capa de business de ADN está el código que se encarga de la verificación de si es o no **Mutante**.

Para que sea mutante tiene que haber una secuencia de **`A, T, C, G`**  repetidas en horizontal, vertical, diagonal y diagonal inversa.

Toda esta información se encuentra en un array de String[] pero su resolución se pensó como una matriz.

Se utiliza H2 como motor de bases de datos para guardar `id`, `name` (nombre), `isMutant`(_true_ o _false_ si es mutante) y los `Timestaps` de creación, actualización y borrado -> `created_at`, `updated_at` y `deleted_at` respectivamente.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
