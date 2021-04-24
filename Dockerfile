FROM openjdk:8
ADD target/fx.jar fx.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar" , "fx.jar"]