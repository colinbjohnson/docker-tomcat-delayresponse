#!/bin/bash

# objective(s):
# create a Docker image in an automated fashion
# the Docker image will be built using a Dockerfile
# the Docker image will run tomcat

# references:
# https://coreos.com/docs/launching-containers/building/getting-started-with-docker/
# http://blog.trifork.com/2013/08/15/using-docker-to-efficiently-create-multiple-tomcat-instances/

apt-get -y update
# 
# pull a specific docker image
curl -sSL https://get.docker.com/ | sh
docker pull tomcat:7.0.64-jre7
mkdir /root/build_directory
cd /root/build_directory
cp /vagrant/webapp.war /root/build_directory
cat > Dockerfile <<EOF
FROM tomcat:7.0.64-jre7
MAINTAINER Colin Johnson "colin@cloudavail.com"
EXPOSE 8080
COPY webapp.war /usr/local/tomcat/webapps/
EOF
# 
docker build --tag colinbjohnson/docker-tomcat-delayresponse:0.1.0 /root/build_directory/
# test: docker run docker-tomcat -p 8080:8080
# curl localhost:8080/webapp
docker push colinbjohnson/docker-tomcat-delayresponse:0.1.0
# 
# # confirm the image has been built:
# # docker.io images
# 