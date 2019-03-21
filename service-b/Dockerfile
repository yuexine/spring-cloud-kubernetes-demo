FROM openjdk:8-jre
MAINTAINER WuYuexin <wuyuexin@3in.org>
VOLUME /tmp

ARG JAR_FILE
COPY target/${JAR_FILE} /usr/share/app/app.jar

#HEALTHCHECK CMD curl --fail http://localhost:8888/healthz || exit 1

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/app/app.jar"]