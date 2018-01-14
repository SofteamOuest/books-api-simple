FROM java:8u111-jdk-alpine
MAINTAINER Mehdi EL KOUHEN <mehdi.elkouhen@gmail.com>

WORKDIR /home/books-api

COPY target/api-book.jar .

CMD java -jar api-book.jar

EXPOSE 8080