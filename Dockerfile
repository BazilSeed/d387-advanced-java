FROM mcr.microsoft.com/openjdk/jdk:17-distroless
WORKDIR /app
COPY target/*-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]