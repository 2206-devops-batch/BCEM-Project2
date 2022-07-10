FROM debian:bookworm-backports
ENV DEBCONF_NOWARNINGS="yes"
ENV DEBIAN_FRONTEND noninteractive

# RUN apt-get update && apt-get install curl sudo git python3 python3-pip -y
RUN apt-get update && apt-get install curl sudo git -y
RUN curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | tee \
      /usr/share/keyrings/jenkins-keyring.asc > /dev/null; \
    echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
      https://pkg.jenkins.io/debian-stable binary/ | tee \
      /etc/apt/sources.list.d/jenkins.list > /dev/null; \
    apt-get update; \
    apt-get install jenkins -y
