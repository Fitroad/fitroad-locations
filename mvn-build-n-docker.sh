mvn clean compile
mvn package spring-boot:repackage
docker build -t local/fitroad-locations:1.0.0 -f Dockerfile .
minikube image load local/fitroad-locations:1.0.0