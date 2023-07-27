# Prueba Técnica Analista de Desarrollo 

Sistema para realizar el inventario y deprecación del valor de los activos de una compañía.

## Instrucciones para desplegar el proyecto en ambiente local con Docker

1. Asegúrate de tener Docker instalado en tu máquina local.

2. Clonar el repositorio:

   ```bash
   git clone https://github.com/bmindiola/technical-test-inventory.git
   ```

3. Navegar al directorio del proyecto:

   ```bash
   cd technical-test-inventory
   ```

4. Construir la imagen de Docker:

   ```bash
   DOCKER_BUILDKIT=1 docker build -t inventory/springboot .
   ```

5. Ejecutar la aplicación dentro de un contenedor Docker:

   ```bash
   docker run -p 8000:8000 inventory/springboot
   ```
6. Accede a la documentación de la aplicación localmente a través de la URL http://localhost:8000/docs/swagger-ui/index.html
   o simplemente prueba los servicios desde postman a con la URL http://localhost:8000/equipment y los diferentes verbos HTTP
   POST, GET, PUT o DELETE.
