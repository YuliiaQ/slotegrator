# CASINO

This is the test automation framework for automated testing of CASINO.

## Framework components 

This test automation framework uses the following libraries and frameworks:
- Java JDK 8 as the programming language
- Selenium WebDriver as web browser automation
- Maven as build tool and package management
- Cucumber as a testing tool that supports BDD
- AssertJ as a library for writing fluent and rich assertions in Java tests
- Allure framework as a reporting tool that provides modern-style reports
- JUnit as a testing framework to support the test creation, execution and reporting
- Lombok as a Java library that is used to minimize or remove the boilerplate code
- Bonigarcia/WebDriverManager as a Java library that carries out the management (download, setup, 
and maintenance) of the drivers required by Selenium WebDriver
- Rest Assured as a framework with a lot of additional methods and libraries for API test automation

## Running the tests

For executing the tests using Maven open the command prompt in the root directory and use the next command

```
mvn clean test
```

## Report generation

For report generation in the command prompt use the next command

```
allure serve target/allure-results
```

For opening cucumber pretty report run the tests and find the report in package "build/site/cucumber-pretty.html"

## Author

* **Yulia Denchuk**




