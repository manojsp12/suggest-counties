# Suggest Counties

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

Get suggested counties based on provided query string. Responds with an array, limited to 5 results, of counties where the county name or state matches the provided query string.

## Features

* type-ahead suggestions for US counties
* suggestions based on provided fragment of a county name and/or state.


## Requirements
To run the application locally, below applications needs to be installed.

### Local
* [Java 8 SDK](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Github](https://central.github.com/deployments/desktop/desktop/latest/win32)

## Quick Start

Open Command Prompt/Terminal and execute below commands.

### Clone suggest-counties
```
git clone https://github.com/manojsp12/suggest-counties.git
cd suggest-counties
``` 
### Configuration
Below properties are configured by default. These properties can be updated [here](https://github.com/manojsp12/suggest-counties/blob/main/suggest-counties/src/main/resources/application.properties), if required.

```
# Minimum county length required as input
counties.min-length=3

# Minimum State length required, if State is provided as input
state.min-length=2

# Server port
server.port=3000
```
### Run Local
```
mvn spring-boot:run
```

Application will run by default on port `3000`

Configure the port by changing `server.port` in __application.properties__

## Testing
Application can be tested using [Swagger-UI](http://localhost:3000/swagger-ui/index.html)

## API
OpenAPI spec of suggest-counties endpoints can be found [here](https://github.com/manojsp12/suggest-counties/blob/main/suggest-counties/src/main/resources/spec.yaml)