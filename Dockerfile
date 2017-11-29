FROM java:8u111-jdk-alpine

ADD target/books.jar .

CMD java -jar helloworld.jar