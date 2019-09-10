# Discount Calculator

Spring boot project which exposes web api for calculating discount on a given bill based on the user type.

## Build

[Please make sure maven and JDK 8 is installed in your machine]().

Navigate to the root of the project directory and use the the below command to build the maven project from command-line.

```bash
mvn clean install
```

## Running

Use the the below command to run the maven project from command-line.
```python
mvn spring-boot:run
```
Application will be available in the below URL, if 8099 port is already used change the 'server.port' property in the 'application.properties' file and re-run the project.

[http://localhost:8099/swagger-ui.html](http://localhost:8099/swagger-ui.html)

## Junit & Test Coverage

Use the the below command to run the unit test cases from command-line.
```python
mvn clean test
```
Coverage detail will be available in target/site/jacoco/index.html

#### Request Payload

Sample request payload is available in
>src\main\resources\sample-payload