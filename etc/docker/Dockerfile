FROM alpine/git as cloner
WORKDIR /opt
RUN git clone https://github.com/code4romania/expert-consultation-backend

FROM adoptopenjdk:11-jdk-hotspot as builder
COPY --from=cloner /opt /opt
WORKDIR /opt/expert-consultation-backend
RUN chmod +x gradlew
RUN ./gradlew build

FROM adoptopenjdk:11-jre-hotspot
ARG JARNAME
WORKDIR /opt
COPY --from=builder /opt/expert-consultation-backend/build/libs/$JARNAME /opt/expert-consultation.jar
CMD ["java", "-jar", "/opt/expert-consultation.jar", "--spring.profiles.active=production"]
