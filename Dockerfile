FROM tomcat:7.0.64-jre8
MAINTAINER Colin Johnson "colin@cloudavail.com"
EXPOSE 8080
COPY webapp.war /usr/local/tomcat/webapps/
