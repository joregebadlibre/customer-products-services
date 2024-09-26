# PRY_Docker

Este proyecto contiene dos microservicios. Sigue los pasos a continuación para configurar y ejecutar el entorno.

## Pasos para la configuración

1. **Crear una carpeta para los microservicios:**
   ```bash
   mkdir PRY_Docker
   cd PRY_Docker

2.-Crear el archivo docker-compose.yml o descargarlo del siguiente enlace: [docker-compose.yml](https://github.com/joregebadlibre/dockercompose/blob/cb9fc1eac55b096030a1b71ab28a51afa2a5d8da/docker-compose.yml)

3.-Clonar los proyectos con Git:

git clone https://github.com/joregebadlibre/customer-products-services.git

git clone https://github.com/joregebadlibre/customer.git

4.-Ejecutar el siguiente comando desde un terminal:

docker-compose up -d --build

5.-Importar los siguientes curl en Postman: [PRUEBATECNICA.postman_collection.json](https://github.com/joregebadlibre/dockercompose/blob/cb9fc1eac55b096030a1b71ab28a51afa2a5d8da/PRUEBATECNICA.postman_collection.json)

Nota
Los microservicios se conectan a una base de datos en AWS.
