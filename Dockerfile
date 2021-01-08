FROM maven:3.6.3-jdk-11
COPY . /usr/hrplatform
WORKDIR /usr/hrplatform
RUN mvn clean install
CMD ["java", "-jar", "./target/hrplatform-0.0.1.jar"]
