FROM amazoncorretto:21-alpine3.16
LABEL authors="Prasanna Kumar"
MAINTAINER <msprasannakumar19@gmail.com>
WORKDIR /home/app
COPY target/springsecuritypasswordauthenticator.war  app.war
ENTRYPOINT ["java", "-jar", "app.war"]