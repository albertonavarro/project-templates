# Gradle project templaye

## Features

### Independent Swagger contract

Module `contract`

Contract version editable in `contract/gradle.properties`

Push it to bintray (some names are hardcoded yet) using `./gradle contract:publish`,
for this to work, you need to override `repositoryUser` and `repositoryPass` (ideally)
locally.

Once it has been pushed to `bintray` (preconfigured-hardcoded), it will be usable
from springboot module.

Bintray typically fails `push` if an artifact with same name and version exists,
it doesn't allow overriding by default.

### Flyway

This project comes with a working in-mem database Flyway example.

Goal is to publish a migrator configuration alongside the main project artifact.

### Springboot Java8 application

Module `springboot`

Run springboot application from gradle using `./gradlew springboot:bootRun`

Springboot uses Swagger to create Controller classes, using the api version in
`springboot/gradle.properties`, property `supported_api_version`.

### Dockerized Springboot

Module `springboot`, file `docker.gradle`

By running `./gradlew springboot:distDocker` it builds a docker image locally, edit
configuration `push` to true to publish your image to your docker repo. In order to
do this, ensure your user is logged in your docker hub previously.

### Unit tests

Module `springboot`, folder `src/test/groovy`

This project uses Spock for unit test.

### Component tests

Module `springboot`, folder `src/component-test/java`

This project uses Java for component tests

### Integration tests

Module `integration-tests`

This project uses CucumberJVM + Groovy for integration tests

### Code quality

#### Checkstyle

Configuration in `code_quality` folder, any violation would break the build.

#### Code coverage

This project uses jacoco to calculate test coverage (test + component tests)
Thresholds are configurable in `springboot/build.gradle`

