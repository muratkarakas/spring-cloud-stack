#!/bin/bash
cd sc-config-server
mvn package docker:build -DskipTests

cd ..
cd sc-eureka-server
mvn  package docker:build -DskipTests

cd ..
cd sc-service
mvn  package docker:build -DskipTests

cd ..
cd sc-service-client
mvn  package docker:build -DskipTests


cd ..
cd sc-zipkin
mvn  package docker:build -DskipTests


cd ..
cd sc-hystrix-dashboard
mvn  package docker:build -DskipTests

cd ..
cd sc-zuul-proxy
mvn  package docker:build -DskipTests


cd ..
docker-compose up