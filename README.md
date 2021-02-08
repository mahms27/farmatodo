# farmatodo
prueba farmatodo


Este proyecto se encuentra desarrollado en java 8 bajo el framework springBoot.
Para  ejecución de proyecto  previamente debe estar instalada la base de datos MySql  en la ruta  /prueba/src/main/resources encontrara el archivo application.properties
al cual para que se ejecute el proyecto se le deben cambiar los valores a las propiedades

spring.datasource.username = root
spring.datasource.password = qpalwosk10

usando respectivamente los valores configurados en el username y password de la base de datos del ambiente donde se va a ejecutar el proyecto.

en caso de que el servidor de base de datos de Mysql instalado en el ambiente donde se ejecutara el proyecto esté en un puerto diferente al 3306 se debe tener en cuenta que la el  puerto debe ser cambiado de igual forma en la propiedad

spring.datasource.url = jdbc:mysql://localhost:3306/farmatodo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC


De igual forma se debe crear en MySql la base de datos farmatodo
          CREATE DATABASE farmatodo;

El proyecto corre por el puerto 8080 a continuación se adjuntan el listado de endpoint del api rest.

1.	http://localhost:8080/api/farmatodo/rickandmorty/getepisode/{episodio}
esta api GET   recibe como parámetro de entrada el número del episodio a consultar
ejemplo : localhost:8080/api/farmatodo/rickandmorty/getepisode/1

2.	http://localhost:8080/api/farmatodo/getHappyNumbers

esta api POST recibe como parámetro de entrada un  listado de números en formato

Ejemplo http://localhost:8080/api/farmatodo/getHappyNumbers
[
    0,
    375,
    668,
    90000000,
    7
]

3.	http://localhost:8080/api/farmatodo/addnaturalnumber/{numero}

este api GET recibe como parámetro de entrada un número natural

Ejemplo: localhost:8080/api/farmatodo/addnaturalnumber/5





