FROM maven:3.6.1-jdk-8 as builder
### Provide Default Argument
WORKDIR /usr/src/app 
COPY ./target . 
## Use only a JRE to run application
FROM gcr.io/distroless/java:8
# FROM openjdk:7
## Copy Artifact from maven image
WORKDIR /app 
COPY --from=builder /usr/src/app/rss-inventory-service-0.0.1-SNAPSHOT.jar /app/app.jar 
# MUST CONFIRM ARTIFACT NAME! TRY HITHERTO EXISTING PROJECT ARTIFACT NAME
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
