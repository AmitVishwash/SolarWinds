FROM  exoplatform/ubuntu:20.04

# Install OpenJdk Java 11 SDK
RUN apt-get update && apt-get -y install openjdk-11-jdk-headless && rm -rf /var/lib/apt

ENTRYPOINT ["/usr/local/bin/tini", "--", "/usr/bin/java"]

#Step 1 : Install the pre-requisite
RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install -y wget
RUN apt-get install -y p7zip \
    p7zip-full \
    unace \
    zip \
    unzip \
    bzip2
	
#Version numbers
ARG CHROMDRIVER_VERSION=120.0.6099.71

#Step 2: Install Chrome
RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
RUN apt-get install -y /chrome.deb
RUN rm /chrome.deb
#Step 3: Install chromedriver for Selenium
RUN mkdir -p /app/bin
RUN wget -N https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/$CHROMDRIVER_VERSION/linux64/chromedriver-linux64.zip -P ~/
RUN unzip ~/chromedriver-linux64.zip -d ~/
RUN rm ~/chromedriver-linux64.zip
RUN mv -f ~/chromedriver-linux64/chromedriver /app/bin/chromedriver
RUN chmod +x /app/bin/chromedriver
#Step 6: Install Maven
# 1- Define Maven version
ARG MAVEN_VERSION=3.9.6
# 2- Define a constant with the working directory
ARG USER_HOME_DIR="/root"

# 3- Define the SHA key to validate the maven download
ARG SHA=706f01b20dec0305a822ab614d51f32b07ee11d0218175e55450242e49d2156386483b506b3a4e8a03ac8611bae96395fd5eec15f50d3013d5deed6d1ee18224
        

# 4- Define the URL where maven can be downloaded from
ARG BASE_URL=https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries

# 5- Create the directories, download maven, validate the download, install it, remove downloaded file and set links
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downloading maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  \
  && echo "Checking download hash" \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# 6- Define environmental variables required by Maven, like Maven_Home directory and where the maven repo is located
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
#Step 7: Copy our project
COPY . /app
#Making our working directory as /app
WORKDIR /app
ENTRYPOINT mvn test