FROM openjdk:8-jre-alpine
LABEL maintainer="vorse0rider@xl.co.id"
WORKDIR /app
COPY target/api-0.0.1*.jar /app/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "app.jar" ]
EXPOSE 8080