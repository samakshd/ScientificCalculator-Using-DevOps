FROM openjdk:11
COPY ./target/ScientificCalculator-Using-DevOps-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "ScientificCalculator-Using-DevOps-1.0-SNAPSHOT-jar-with-dependencies.jar"]