FROM gradle AS build
COPY --chown=gradle:gradle . /home/gradle/src/dmmiseenprod.mepapp
WORKDIR /home/gradle/src/dmmiseenprod.mepapp
RUN gradle build

FROM openjdk:17-jdk-slim
EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/gradle/src/dmmiseenprod.mepapp/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT exec java -jar /app/spring-boot-application.jar