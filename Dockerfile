FROM openjdk:11

RUN mkdir /home/app

COPY target/fitroad-locations-1.0.0.jar /home/app

CMD ["java", "-jar", "/home/app/fitroad-locations-1.0.0.jar"]