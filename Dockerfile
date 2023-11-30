FROM jboss/wildfly:latest
LABEL authors="lf"

ENV JAVA17_REPO_DIR /etc/yum.repos.d
ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments/
ENV APP_NAME target/teste-1.0.war

USER root

RUN yum -y install wget

RUN cd ~
RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.rpm"

RUN yum -y localinstall jdk-17_linux-x64_bin.rpm

ENV JAVA_HOME=/usr/lib/jvm/jdk-17-oracle-x64/

COPY target/${teste} ${DEPLOYMENT_DIR}

EXPOSE 8080 8443 9990

#USER root

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
