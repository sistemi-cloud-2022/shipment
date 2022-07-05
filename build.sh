mvn package -Dmaven.test.skip=true
docker build --tag shipment:latest .