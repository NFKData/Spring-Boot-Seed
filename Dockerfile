FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=springboot-seed-1.0.0.jar
ENV JAR_FILE=${JAR_FILE}

USER root

ADD target/${JAR_FILE} /opt/${JAR_FILE}
ADD entrypoint.sh /entrypoint.sh

RUN chmod a+x /entrypoint.sh

CMD ["bin/sh"]

EXPOSE 8080

ENTRYPOINT [ "/entrypoint.sh" ]