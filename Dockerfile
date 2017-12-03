FROM java:8u111-jdk-alpine

ADD target/api-book.jar .

CMD java -jar api-book.jar

EXPOSE 8080