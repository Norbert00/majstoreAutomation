# majstoreAutomation

Sample framework for automatic GUI and API tests.
####Basic configuration to run tests
* Java 8 
* Maven
* TestNG
* Docker 

####To run the tests
```shell script
$ docker-compose up -d
$ mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testSuite.xml

```
###To generate a report 
```shell script
$ mvn allure:report
```
