FROM tomcat:8-jdk15-openjdk-oracle

RUN rm -rf /usr/local/tomcat/webapps/HelloSpringMySQL.war

COPY webroot/webapps/HelloSpringMySQL.war /usr/local/tomcat/webapps/

CMD ["catalina.sh","run"]

