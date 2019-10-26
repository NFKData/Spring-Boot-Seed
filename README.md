# Seed project

## Summary

- [Metadata](#metadata)
- [Current Architecture](#current-architecture)
- [Current properties](#current-properties)
- [Needed development environment](#needed-development-environment)
- [Versioning convention](#versioning-convention)
- [Readiness and Liveness probes](#readiness-and-liveness-probes)
- [Changelog](#changelog)

## Metadata

- **Version**: 4.1
- **GroupId**: com.nfkdata
- **ArtifactId**: springboot-seed

## Current Architecture

- `src/main/java`
	- **com.nfkdata.seed**: Contains the whole application and **SpringBootApplicationLauncher** on the root of the package
	- **com.nfkdata.seed.domain**: Contains Data Classes with Lombok annotations
	- **com.nfkdata.seed.rest**: Contains Root Endpoint
	- **com.nfkdata.seed.rest.probes**: Contains Readiness and Liveness probes
	- **com.nfkdata.seed.service**: Contains business logic services
	- **META-INF**: Contains metadata for custom application properties
- `src/main/resources`
	- **application.properties**: File containing some spring properties
- `src/test/java`
	- **com.nfkdata.seed**: Contains tests for Spring Boot Launcher
	- **com.nfkdata.seed.rest**: Contains tests for Root Endpoint

## Current properties

| Property                     | Description                                 |
|------------------------------|---------------------------------------------|
| spring.application.name      | Name for the current application            |
| server.servlet.context-path  | Context path for the current application    |
| package.to.scan.rest         | Package containing REST controllers         |
| package.to.scan.domain       | Package containing data classes             |
| package.to.scan.service      | Package containing business logic Services  |

## Needed development environment

- OpenJDK 11: [Windows](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip), [MAC](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_osx-x64_bin.tar.gz), [Linux](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz)
- [Lombok IDE processing on Eclipse and IntelliJ](https://www.baeldung.com/lombok-ide) `Just for development purposes, not needed for compilation`

## Versioning convention

For the versioning of this project is used the following convention:

`Feature Release`.`Fixes`

If some fixes are added with a feature release, it will be just `Feature Release`.0

## Readiness and Liveness probes

For checking if the application is alive, the `/${server.servlet.context-path}/actuator/live` should be called.

For checking if the application is ready, the `/${server.servlet.context-path}/actuator/ready` should be called.

## Changelog

- `1.0`
	- Creation of the seed
- `2.0`
	- Added Github Action for Maven build
	- Added Versioning convention on documentation
- `2.1`
	- Added right unit tests for Application Launcher
- `3.0`
	- Added services to code
- `3.1`
	- Added new property on documentation
- `4.0`
	- Added Readiness and Liveness Probes
- `4.1`
	- Added documentation about Readiness and Liveness Proves 