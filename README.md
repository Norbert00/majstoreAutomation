# majstoreAutomation
Sample framework for automatic GUI and API tests for an online store. 
A dedicated shop has been placed on AWS(free ec2 instance), that why the execution of tests can take about 20 minutes. 
#### Basic configuration to run tests
* Java 8 
* Maven
* TestNG
* Docker 

#### To run the tests
```shell script
$ docker-compose up -d
$ mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testSuite.xml

```
#### To generate a report 
```shell script
$ mvn allure:report
```
