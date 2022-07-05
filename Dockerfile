FROM openjdk:11 
WORKDIR /app
COPY target/shipment-0.0.1-SNAPSHOT.jar /app
ENV SERVER_PORT 5000
EXPOSE $SERVER_PORT
CMD ["java", "-jar", "shipment-0.0.1-SNAPSHOT.jar" ]