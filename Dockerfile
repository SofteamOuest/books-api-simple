FROM java:8u111-jdk-alpine
MAINTAINER Mehdi EL KOUHEN <mehdi.elkouhen@gmail.com>

RUN addgroup books
RUN adduser books-api -G books -H -D

WORKDIR /home/books-api

COPY target/api-book.jar .
RUN chown books-api:books api-book.jar

USER books-api:books

CMD java -jar api-book.jar

#RUN apk update

#RUN apk add curl

EXPOSE 8080