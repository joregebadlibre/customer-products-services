Crear una carpeta que contenga los 2 microservicios.
ejemplo: PRY_Docker

crear el archivo docker-compose.yml
o bajarlo del siguiente link:
https://github.com/joregebadlibre/dockercompose/blob/2792246dbc52f973301030a9727ff25866ae7e0b/docker-compose.yml

luego clonar con git el proyecto customer-products-service
git clone https://github.com/joregebadlibre/customer-products-services.git

luego clonar con git el proyecto customer
git clone https://github.com/joregebadlibre/customer.git

desde un cmd ejecutar el siguiente comando:
docker-compose up -d --build


luego en postman importar los siguiente curl:
https://github.com/joregebadlibre/dockercompose/blob/cb9fc1eac55b096030a1b71ab28a51afa2a5d8da/PRUEBATECNICA.postman_collection.json

nota: los micro se conectan una BDD en AWS.
