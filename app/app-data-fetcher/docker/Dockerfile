FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} data-fetcher.jar
ENTRYPOINT ["java","-jar","/data-fetcher.jar"]