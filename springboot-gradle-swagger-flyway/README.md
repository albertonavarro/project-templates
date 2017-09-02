# Gradle project templaye

## Gradle tips

### Gradle wrapper

You don't need to install Gradle in your system, only Java.
Gradle wrapper self-downloads the same version that the project needs.

### Multi-module tasks execution

Being in root folder (this one) and executing `./gradlew module_name:task` means
basically the same than being in module folder and execute `../gradlew task`.

Commands executed in root folder, without module name, will apply to all modules.

You can also combine modules and root `./gradlew clean module1:taskA module2:taskB`,
tasks are reordered using internal Gradle DAG reordering.

### Overriding variables

Gradle allows variable overriding by using parameters `-Pname=value` and using
user's local gradle configuration `~/.gradle/gradle.properties`.

### Knowing your options

`./gradlew tasks` will tell you what tasks are available.

## Features

### Independent Swagger contract

Module `contract`

Contract version editable in `contract/gradle.properties`

Push it to bintray (some names are hardcoded yet) using `./gradle contract:build contract:publish`.
In order to achieve a successful publish, you need to override `repositoryUser`
and `repositoryPass` (ideally) locally.

Once it has been pushed to `bintray` (preconfigured-hardcoded), it will be usable
from springboot module.

Bintray typically fails `push` if an artifact with same name and version exists,
it doesn't allow overriding by default.

### Flyway

This project comes with a working in-mem database Flyway example.

Goal is to publish a migrator configuration alongside the main project artifact.

More info about flyway commands: `https://flywaydb.org/getstarted/firststeps/gradle`

### Mapstruct

Mapstruct example used in rest controller.

### Springboot Java8 application

Module `springboot`

Run springboot application from gradle using `./gradlew springboot:swagger springboot:bootRun`

Springboot uses Swagger to create Controller classes, using the api version in
`springboot/gradle.properties`, property `supported_api_version`.

Useful links:

- http://localhost:8080/info.json -> info endpoint with commit, branch and version,
information is merged from properties file and CI environment variables.
- http://localhost:8080/health.json -> health endpoint
- http://localhost:8080/static/ -> delivers files under resources/public-resources. e.g. .empty
- http://localhost:8080/web/login/welcome -> Freemarker templates through Spring MVC
- http://localhost:8080/organizations -> Rest endpoint declared in Swagger

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

