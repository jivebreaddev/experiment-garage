FROM amazoncorretto:21-alpine3.17-jdk AS builder
COPY . .
RUN chmod 755 ./gradlew
RUN ./gradlew build -x test

FROM amazoncorretto:21-alpine3.17
ARG JAR_FILES=build/libs/*-SNAPSHOT.jar
COPY --from=builder ${JAR_FILES} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
