FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} task-service.jar
ENTRYPOINT ["java","-jar","/task-service.jar"]