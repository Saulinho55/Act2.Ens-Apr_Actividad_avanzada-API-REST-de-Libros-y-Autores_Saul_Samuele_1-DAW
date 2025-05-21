# Act2.Ens-Apr_Actividad_avanzada-API-REST-de-Libros-y-Autores_Saul_Samuele_1-DAW

Este proyecto se trata de una API REST desarrollada con Spring Boot donde se puede gestionar libros y sus autores. Se podrá realizar: Listar libros por el ID, tanto de este, como de su autor. Crear y eliminar libros. Crear un autor y listar dichos autores. Buscar con filtros y ordenación libros o actualizar libros. 

Este proyecto expone los siguientes endpoints:
GET	/api/v1/libros	-Listar todos los libros  
GET	/api/v1/libros/{id}	-Obtener libro por ID  
POST	/api/v1/libros	-Crear nuevo libro (vincular a autor)  
PUT	/api/v1/libros/{id}	-Actualizar libro  
DELETE	/api/v1/libros/{id}	-Eliminar libro  
GET	/api/v1/libros/buscar	-Buscar con filtros y ordenación (Filtros: titulo -> ?titulo="titulo" anio -> ?anio="año" sortBy-> sortBy="anioPublicacion"&order=desc/asc order -> ?titulo="titulo"&anio="año"&sortBy="anioPublicacion"&order=asc/esc  
GET	/api/v1/autores	-Listar autores  
GET	/api/v1/autores/{id}	-Ver autor con sus libros  
POST	/api/v1/autores	-Crear nuevo autor  

Esto se comprueba gracias a la herramienta Postman donde se podrá realizar consultas con dichos enlaces y código JSON. Se debe colocar el endpoint y ejecutar en la sección body/raw y ejecutarlo. 

Está estructurado con el siguiente esquema: 

com.api.librosyautores  
├── controller  
│   ├── LibroController.java  
│   └── AutorController.java  
├── model  
│   ├── Libro.java  
│   └── Autor.java  
├── repository  
│   ├── LibroRepository.java  
│   └── AutorRepository.java  
├── service  
│   ├── LibroService.java  
│   └── AutorService.java  
└── LibrosyautoresApplication.java  

