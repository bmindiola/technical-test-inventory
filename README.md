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

## Instrucciones para desplegar el proyecto en Kubernetes usando Docker

1. Asegúrate de tener Kubernetes instalado y configurado correctamente en tu entorno de desarrollo o servidor de despliegue.
   Puede ser Minikube o Docker Desktop para configurar un clúster local para pruebas.
2. Construye la imagen de Docker siguiendo el cuarto paso mencionado anteriormente.
3. Aplica la configuración a Kubernetes:
   ```bash
   kubectl apply -f deployment.yaml
   ```
4. Verifica que los pods estén ejecutándose y obtén la dirección del servicio expuesto:
   ```bash
   kubectl get pods
   kubectl get services
   ```
5. Accede a la documentación de la aplicación a través de la URL http://localhost:90/docs/swagger-ui/index.html
   o simplemente prueba los servicios desde postman a con la URL http://localhost:90/equipment y los diferentes verbos HTTP
   POST, GET, PUT o DELETE.

## Diagramas

En esta sección, se encuentran los diagramas técnicos realizados para el proyecto:

- [Diagrama de Clases](diagrams/diagrama-clases.pdf): Representa la estructura de clases utilizadas en el sistema.
- [Diagrama de Componentes](diagrams/diagrama-componentes.pdf): Muestra la arquitectura de componentes.
- [Diagrama de Secuencia](diagrams/diagrama-secuencia.pdf): Ilustra la secuencia del servicio REST.
