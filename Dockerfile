FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=target/task_manager_api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} task_manager_api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/task_manager_api-0.0.1-SNAPSHOT.jar"]