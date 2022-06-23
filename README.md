# Gateway Tracker Sinotrack
[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=jalucenyo_tracker-sinotrack)](https://sonarcloud.io/summary/new_code?id=jalucenyo_tracker-sinotrack)

## ¿ Que es ?

Este proyecto consiste es un servicio para transformar las información que 
envia los tracker GPS de la marca Sinotrack, a un objecto JSON que se envia
a una cola de mensajes en AWS.

## Tecnologias

Para realizar el proyecto se ha utilizado la siguientes tecnologias:

**Kotlin**: Como lenguage de programación

**Spring Boot** : Framework utilizado en el desarollo del servicio.

- Spring Integration: Crea un socket TCP, al cual se conecta el tracker para enviar la información
- spring-cloud-starter-aws-messagin: Starter con las libreria para conectar con AWS.

**AWS SQS (Simple Queue Service)** : Servicio de cola de mansajes de AWS.

## Diagrama

## Ejecutar el servicio

La conexión a los servicios de amazon requieren indicar las credenciales de acceso 
un "ACCESS_KEY" y su "SECRET_KEY". Es recomendable crear un usuario en dentro de
AWS IAM con los permisos minimos.

**Requisitos**

Para ejecutar el servicio, necesita tener instalado:
- Maven 3.8.1 o superior
- OpenJDK 17 o superior

Puedes ejecutarlo con maven con el siguiente comando:

~~~
mvnw -DAWS_ACCESS_KEY=YOUR_ACCESS_KEY -DAWS_SECRET_KEY=YOUR_SECRET_KEY  spring-boot:run
~~~

## Ejecutar el servicio con Docker

El serivcio esta disponible en como una imagen en [DockerHub](https://hub.docker.com/repository/docker/jalucenyo/tracker-sinotrack)

Puedes probar el servicio sin descargar el codigo, solo necesitas tener docker instalado,
y correr el siguiente comando:

~~~
docker run -p 5000:5000 --env AWS_ACCESS_KEY=YOUR_KEY --env AWS_SECRET_KEY=YOUR_SECRET --rm jalucenyo/tracker-sinotrack
~~~

*Recuerda indicar tu access key y secret de AWS*

## Proyectos relacionados

*Pendinte...*
 
## ¿Como colaborar ?

*Pendinte...*
