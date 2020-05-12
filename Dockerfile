FROM openjdk:12-alpine
EXPOSE 8080
COPY ./build/libs/twilio-service-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","twilio-service-0.0.1-SNAPSHOT.jar"]