<<<<<<< HEAD
FROM openjdk:8
EXPOSE 8080
ADD target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
=======
#FROM openjdk:8
#EXPOSE 8080
#ADD target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
#ENTRYPOINT ["java","-jar","/springboot-reactjs-backend.jar","--spring.profiles.active=prod","--DB=mysql-svc"]

FROM openjdk:8
VOLUME /tmp
COPY target/springboot-reactjs-backend.jar springboot-reactjs-backend.jar
>>>>>>> 5c86859d4756b29a34d5b6c9dd5bfe16cb8c279e
ENTRYPOINT ["java","-jar","/springboot-reactjs-backend.jar","--spring.profiles.active=prod","--DB=mysql-svc"]