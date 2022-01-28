FROM openjdk:11
ARG JAR_FILE=build/libs/TourGuideAttraction-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TourGuideAttraction-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/TourGuideAttraction-0.0.1-SNAPSHOT.jar"]
EXPOSE 9007