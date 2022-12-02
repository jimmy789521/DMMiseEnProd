FROM gradle AS build
COPY --chown=gradle:gradle . /home/gradle/DMMiseEnProd/MEPAPP/src
WORKDIR /home/gradle/DMMiseEnProd/MEPAPP/src
RUN gradle build

FROM openjdk:17-jdk-slim
EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/gradle/DMMiseEnProd/MEPAPP/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT exec java -jar /app/spring-boot-application.jar