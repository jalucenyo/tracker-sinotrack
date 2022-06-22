FROM openjdk:17
EXPOSE 8080
ADD target/tracker-sinotrack.jar tracker-sinotrack.jar
ENTRYPOINT ["java","-jar","/tracker-sinotrack.jar"]