FROM frolvlad/alpine-oraclejdk8:slim
RUN  apk update && apk upgrade && apk add netcat-openbsd
VOLUME /tmp
ADD sc-hystrix-dashboard-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

