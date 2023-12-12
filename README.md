
Papertrail Application
**The code logins the user and edits the Name of the user under Profile section of Application**
# The code is based on BDD approach using java, cucumber and selenium.
Pre-requisite

1.) Maven

2.) java 11

3.) Any IDE of your choice

-> **Clone the project from the repo and export the project into IntelliJ**
-> **Build the project. It will download all dependencies listed in pom.xml to your local disk.**
-> **Run the tests using maven or simply Run TestRunner class**


-> The repo contains Dockerfile out of which image has been created and pushed to docker hub - https://hub.docker.com/repository/docker/amit7627/selenium-java-docker/general
You can download the image and simply run the tests using **docker run amit7627/selenium-java-docker:v1.0**


-> The latest report generated is placed at - https://reports.cucumber.io/reports/3a9677a1-7fc3-47fa-9e3b-3c881a7124e0. It's self detructible after 24 hour.

The folder structure follows :


-->
**src**

    _main_
    
    _test_
          _java_
          
              **pageObjects**
        
              **runner**

              **stepdef**

              **utilities**
        
          _resources_

              **features**
        

