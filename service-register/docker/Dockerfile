FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-register.jar
ENTRYPOINT ["java","-jar","/service-register.jar"]