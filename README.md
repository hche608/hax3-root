[![Build Status](https://travis-ci.org/hche608/hax3-parent.svg?branch=master)](https://travis-ci.org/hche608/hax3-parent)
![](https://sonarcloud.io/api/project_badges/measure?project=me.hax3.parent%3Ahax3-parent&metric=alert_status)
![](https://sonarcloud.io/api/project_badges/measure?project=me.hax3.parent%3Ahax3-parent&metric=coverage)
# hax3-parent
This is a collections of pom that is used by all the hax3.me.* projects

## how to setup github mvn-repo
https://malalanayake.wordpress.com/2014/03/10/create-simple-maven-repository-on-github/

###The plugin for github mvn-repo
https://github.com/github/maven-plugins
https://stackoverflow.com/questions/14013644/hosting-a-maven-repository-on-github

How to Release Parent Pom
```mvn clean release:clean release:prepare -B```