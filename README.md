[![Build Status](https://travis-ci.com/hche608/hax3-parent.svg?branch=master)](https://travis-ci.org/hche608/hax3-parent)
![](https://sonarcloud.io/api/project_badges/measure?project=me.hax3.parent%3Ahax3-parent&metric=alert_status)
![](https://sonarcloud.io/api/project_badges/measure?project=me.hax3.parent%3Ahax3-parent&metric=coverage)
# hax3-parent
This is a collections of pom that is used by all the hax3.me.* projects

## how to setup github mvn-repo
https://malalanayake.wordpress.com/2014/03/10/create-simple-maven-repository-on-github/

### The plugin for github mvn-repo
https://github.com/github/maven-plugins
https://stackoverflow.com/questions/14013644/hosting-a-maven-repository-on-github

How to Release Parent Pom
```mvn clean release:clean release:prepare -B```

Example travis template
```yaml
language: java
jdk: oraclejdk8
env:
  global:
  - secure: TQZGDK1eLnY/PFC41ESFRob0dfmhIehuY9n3OVu3gUKrLjEZS5VqTWczx54jrtB0bHH46ZogthATjpaJwgOoAI2AuqHiz3reCAgKA4XE/gGhgiIDLUTUg+fbG6frEPRjWB/OBamCWIip3pB6Acm/nqczFCAVfK2OIyQZvyCGFO0=
  - secure: E/b1Py2L8TaCfHIBskdm0RgjcvPjKwjE7CTcKoiTR6TI4fSb2CKjBJBNRW2spFG825OttGKNoaWlIFBTMnXYGswUnuTfQlL/ngTct62nlMQ1H8YI2+2UQ61R2q9vbl5DeREzrXzHrSTX7qPx4m5rwCmvA5D7suKdzqgz7ToIQ6I=

addons:
  apt:
    packages:
    - oracle-java8-installer
    - oracle-java8-unlimited-jce-policy
  coverity_scan:
    project:
      name: stevespringett/dependency-track
      description: Dependency-Track Coverity Scan
    notification_email: Steve.Springett@owasp.org
    build_command_prepend: 
    build_command: mvn clean package
    branch_pattern: coverity_scan
  sonarcloud:
    organization: "dependencytrack"
    token:
      secure: A2WvgrmCiiwS8k2ofWXL+LtRlLKtmDlEjjngQRRqj1Uk/p5CLsNHI65Nb8kpLJq83JpxmqK51KBJlC9ZuCVXSGWAx4pleouz4l8vp5qi38RzBTgUlhUXr5rGjDMpxsQZtDguC4/j+DmPSxDTdyDKsnXvwSJbboRAhrfPRqAzxJ4=

before_install:
  - java -version
  - sudo apt-get install jq
  - wget -O ~/codacy-coverage-reporter-assembly.jar https://github.com/codacy/codacy-coverage-reporter/releases/download/4.0.5/codacy-coverage-reporter-4.0.5-assembly.jar

before_script:
  - export REPO=owasp/dependency-track
  - export TAG=`if [ "$TRAVIS_BRANCH" == "master" ]; then echo "snapshot"; else echo $TRAVIS_BRANCH ; fi`

script:
  ~~- mvn clean package sonar:sonar~~
  - mvn package -Dmaven.test.skip=true -P embedded-jetty -Dlogback.configuration.file=src/main/docker/logback.xml
  - docker build -f src/main/docker/Dockerfile -t $REPO:$TAG .

after_success:
  - java -jar ~/codacy-coverage-reporter-assembly.jar report -l Java -r target/jacoco-ut/jacoco.xml
  - if [ "$TRAVIS_BRANCH" == "master" ]; then
    docker login -u "$DOCKER_USERNAME" -p "$DOCKER_PASSWORD";
    docker push $REPO;
    fi

notifications:
  slack:
    secure: FtU/UJX7A904c3JgrQ9AE5zYWO8gIMhzAfL8MFRbUd2AfFbNNpb1OaEbIr61Ho0V/HpBYiL/4YDaINKhy/VeUyz1hqAQingvwip6XrblpoEV2bGXZNVOLW72/z41qNwZ2q7Ebx3F1L1jHSUUPBs91FaqWWpwVNXi5FWPT7OkGv0=
  webhooks:
    urls:
      - https://webhooks.gitter.im/e/ade5cc3a87ec0ea4d2c8
    on_success: change  # options: [always|never|change] default: always
    on_failure: always  # options: [always|never|change] default: always
    on_start: never     # options: [always|never|change] default: always
```
