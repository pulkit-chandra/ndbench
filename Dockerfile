# we are extending everything from tomcat:8.0 image ...
FROM tomcat:8.5-jdk8-openjdk

LABEL maintainer=pulkitc@vmware.com

#change me according to what GemFire cluster name is in the k8s cluster.
#Format should be <cluster name>-<number of clusters in this k8s cluster>-locator.<namespace>
ARG locator_host={\"p-cloudcache\":[{\"credentials\":{\"locators\":[\"gemfire-1-locator.gemfire-cluster[10334]\"]}}]}
ENV DISCOVERY_ENV=K8S
ENV VCAP_SERVICES=$locator_host
COPY ndbench-web/build/libs/ndbench-web-0.5.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]