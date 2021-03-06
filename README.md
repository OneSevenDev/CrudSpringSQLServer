# Hola mundo Spring MVC, estructura principal usando eclipse

## CRUD basico hecho en Spring MVC:
Se solicita poder gestionar las operaciones basicas para un trabajador, donde se necesitara su nombre, apellidos, edad y un cargo a asignar en la empresa usando un `<select><option>POSITION</option></select>`.
El trabajador no podra cambiar de cargo desde la opcion de modificar (editar)

### Requisitos necesarios:
- Ejecutar script sql en su gestor de datos favorito (En este caso use SQLServer 2014)
- Asegurar que en el archivo `pom.xml` este la dependencia de su Gestor de Datos.
link: [Script de la base de datos](https://github.com/OneSevenDev/demoSpring/blob/master/databaseempresa.sql)
- Agregar datos a la base de datos para poder visualizar la lista
- Instalar la extension de [Spring STS](https://spring.io/) en [Eclipse](https://eclipse.org/downloads/)
  - Link donde explico que extension descargar: [Link de tutorial Hola mundo Spring](https://manuelguarnizblog.wordpress.com/2016/09/28/hola-mundo-con-spring-mvc/)
- Usar el codigo como mejor sea, cualquier recomendaci�n visitenme en [@Cruzemg95](https://twitter.com/cruzemg95)

### �Com� lo instalo y ejecuto?
- Usando en Bash de Git clonamos el proyecto
- Abrimos Eclipse y ubicamos la carpeta en donde hemos clonado el proyecto
- Configuramos el servidor [Tomcat Apache](https://tomcat.apache.org/download-80.cgi) -> [Revisar aqu� Proceso](https://youtu.be/Wt8prq-JTXA)
- Ejecutamos el proyecto sobre el servidor local

### Imagenes demostrativas del CRUD en Spring MVC

** Imagen demostrativa de CREATE **

![Imagen de muestra, crear trabajador en spring](https://raw.githubusercontent.com/OneSevenDev/CrudSpringSQLServer/master/images/create.jpg)

** Imagen demostrativa de READ **

![Imagen de muestra, crear trabajador en spring](https://raw.githubusercontent.com/OneSevenDev/CrudSpringSQLServer/master/images/read.jpg)

** Imagen demostrativa de UPDATE **

![Imagen de muestra, crear trabajador en spring](https://raw.githubusercontent.com/OneSevenDev/CrudSpringSQLServer/master/images/update.jpg)

** Imagen demostrativa de DELETE **

![Imagen de muestra, crear trabajador en spring](https://raw.githubusercontent.com/OneSevenDev/CrudSpringSQLServer/master/images/delete.jpg)

* Orientaci�n educativa - Saludos *
