FROM java:8u111-jdk-alpine

ADD target/helloworld.jar .

CMD java -jar helloworld.jar