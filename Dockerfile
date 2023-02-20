FROM openjdk:latest
COPY target/quiz-1.0.0-SNAPSHOT.jar quiz.jar
ENTRYPOINT ["java", "-jar", "/quiz.jar"]