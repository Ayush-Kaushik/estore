# Basic CRM RoadMap (Spring Boot)
_________________________________

## Stage 1

### Project setup
* [x] Setup directory structure for Java application
* [x] Get ~~gradle~~ Maven working in IntelliJ (found it much easier to work with)
* [ ] Document the setup process (Anatomy of pom.xml etc.)
* [x] Add sample unit tests (https://www.youtube.com/watch?v=Geq60OVyBPg)
* [x] Add sample integration tests (https://www.youtube.com/watch?v=Geq60OVyBPg)

### API setup
* [x] Get the API running
* [x] Add a simple GET endpoint
* [x] Setup a simple database table
* [x] Make connection to the database
* [x] Add a GET, POST and PUT endpoint
* [ ] Implement the entire JWT Auth workflow based on this: https://www.youtube.com/watch?v=KxqlJblhzfI
* [ ] Add authentication and authorization workflow

### Concepts covered
* [ ] Understand and document components of Spring-boot application
* [ ] Document the entire JWT Auth workflow based on this: https://www.youtube.com/watch?v=KxqlJblhzfI
* [ ] Document my learnings related to creating tests, github actions and uploaded test

### Deployment setup
* [x] Connect this to Github actions to build an executable (https://tomgregory.com/build-gradle-projects-with-github-actions/)
* [x] Run the unit and integration test as a stage inside GitHub actions
* [x] Generate report and publish that as an artifact
* [ ] Add a feature for user to externally provide the config file required to run the application

---------------------------------

## Stage 2:

### Project setup
* [ ] Find something like SwaggerAPI to generate documentation for all the endpoints

### API setup
* [ ] Create integration test for all endpoints created in Stage 1
* [ ] Add validation interceptors for the endpoints
* [ ] Add tests for all service endpoints (unit and integration with comments)
  
### Front-end SPA setup
* [ ] Setup a front-end React SPA for this service
* [ ] Connect it to the backend

### Concepts covered
* [ ] Document generics in Java concept along with method reference operator

### Deployment setup
* [ ] This service will not have a UI, so only API endpoints will be visible
* [ ] Find out how the service with React SPA could be deployed
* [ ] Find out if the two could be separated as two packages (one with Frontend and API only)
* [ ] Introduce caching to reduce deployment time
* [ ] Since GitHub actions take up resources, separate the workflow steps based on which branch the information is pushed on

----------------------------------

## Stage 3:
* [ ] Once the repository has enough information, make it public with wiki pages enabled and all the information transferred
* [ ] Make this repository public and add it as a SpringBoot experience section for future employers

* [ ] Learn how to use profiler for performance
* [ ] Learn how load testing can be performed
* [ ] Check if multi-threading is possible in this process

______________________________________________________________________________

### Important links
- https://spring.io/guides/gs/accessing-data-mysql/
- https://andriperera.medium.com/create-a-rest-api-in-spring-boot-with-mysql-b250ff3aaa9b
- https://www.javaguides.net/2021/02/spring-boot-dto-example-entity-to-dto.html
- https://www.baeldung.com/junit-5-gradle
- https://examples.javacodegeeks.com/core-java/junit/junit-setup-teardown-example/
- https://stackoverflow.com/questions/38586438/at-which-layer-validation-should-be-done-in-a-real-enterprise-java-based-applica#:~:text=Model%20layer%20check%20is%20mainly%20about%20data%20validation. (Which layer should have the validation)
- https://stackoverflow.com/questions/47457009/which-is-best-layer-to-place-mapper-code-service-layer-or-controller-layer (Perform mapping in service layer, this way I can establish separation of concerns)

______________________________________________________________________________

### Tasks in progress
- Fix the maven build issue - why is it starting a server in github build environment
- Maven issue is fixed now - check how to run junit tests upload the outcome
- Create integration tests
- Learn generics in Java
- Document the old video on Auth
- Add documentation for maven package - how to run with customer credentials

______________________________________________________________________________

### Future maybe
- create an executable that could be run anywhere
- Create a docker image and see if it works as expected in remote container

______________________________________________________________________________

### Guides covered

- [x] https://spring.io/guides/gs/accessing-data-mysql/

----------------------------------------------------------------------------

### Testing Guidelines

- Integration test classes are suffixed with IT
- Unit test classes are suffixed with Test
- Performing this to reduce the overhead of running integration test with each push to develop branch

----------------------------------------------------------------------------

### Actions Workflow

### Develop

- Applies for PR and direct push

* [ ] Only run unit tests - upload the test run artifacts
* [ ] Do not create a package unless manually specified in a re-run
* [ ] If a user really wants to run integration tests then they can run it on their own local machines

### Main/ Master
* [ ] Run both unit and integration tests
* [ ] Create a package