FROM gradle AS build
COPY --chown=gradle:gradle DMMiseEnProd/MEPAPP /home/gradle/DMMiseEnProd/MEPAPP
WORKDIR /home/gradle/DMMiseEnProd/MEPAPP
RUN gradle build

FROM openjdk:17-jdk-slim
EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/gradle/DMMiseEnProd/MEPAPP/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT exec java -jar /app/spring-boot-application.jar