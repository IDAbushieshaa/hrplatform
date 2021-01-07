FROM openjdk:11
COPY . /usr/hrplatform
WORKDIR /usr/hrplatform
RUN ./mvnw clean package
CMD ["java", "-jar", "./target/hrplatform-0.0.1.jar"]
