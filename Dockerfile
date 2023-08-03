FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/kattapp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--","java","-jar","/app.jar"]
