FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway-service.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/gateway-service.jar"]