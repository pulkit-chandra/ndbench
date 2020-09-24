# we are extending everything from tomcat:8.0 image ...
FROM tomcat:8.5-jdk8-openjdk

LABEL maintainer=pulkitc@vmware.com

ARG locator_host={"p-cloudcache":[{"credentials":{"locators":["gemfire-1-locator[10334]"]}}]}
ENV DISCOVERY_ENV=K8S
ENV VCAP_SERVICES=$locator_host
COPY ndbench-web/build/libs/ndbench-web-0.5.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]