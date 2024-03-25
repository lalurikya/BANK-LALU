FROM maven:3.9.6-amazoncorretto-17-al2023 as Builder
RUN mkdir app
WORKDIR app
COPY src /app
COPY pom.xml /app
RUN mvn install

FROM openjdk:17.0.1-jdk-slim
WORKDIR app
COPY ./target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


#FROM openjdk:17-jdk-alpine
#COPY . /app
#WORKDIR /app
#RUN mvn install
#ENTRYPOINT ["java","-jar","/app/app.jar"]
#EXPOSE 8080

## Menggunakan image OpenJDK 17 sebagai base image
#FROM adoptopenjdk/openjdk17:alpine AS builder
#
## Menyalin file dari host ke dalam image
#COPY . /app
#
## Mengatur direktori kerja di dalam image
#WORKDIR /app
#
## Membangun proyek Spring Boot dengan Maven
#RUN ./mvnw package -DskipTests
#
## Menggunakan image Alpine Linux sebagai base image untuk menjalankan aplikasi
#FROM adoptopenjdk/openjdk17:alpine-jre
#
## Menyalin artifact hasil build dari stage sebelumnya ke dalam image
#COPY --from=builder /app/target/*.jar /app/app.jar
#
## Port yang akan diexpose oleh container
#EXPOSE 8080
#
## Perintah yang akan dijalankan saat container dijalankan
#CMD ["java", "-jar", "/app/app.jar"]
