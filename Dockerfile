FROM maven:3.5.0-jdk-8

RUN mkdir /usr/src/r3vl-workspace

WORKDIR /usr/src/r3vl-workspace

ADD . .

WORKDIR /usr/src/r3vl-workspace/r3vl-build
RUN mvn clean package -DskipTests

WORKDIR /usr/src/r3vl-workspace/r3vl-api/target

EXPOSE 8082
ENV SPRING_PROFILES_ACTIVE=dev

CMD java -jar r3vl-api-0.0.1-SNAPSHOT.jar

