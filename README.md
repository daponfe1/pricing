<div align="center">
  <h1 align="center">
    Pricing microservice
    <br />
    <br />
    <a>
      <img src="https://img.freepik.com/free-vector/hand-drawn-cartoon-cash-register-illustration_23-2150946370.jpg?w=826&t=st=1713791010~exp=1713791610~hmac=e736c1c1f4932b02a0cc93950c334140578d3ad29e89b70acc4eb810d892bdbd">
    </a>
  </h1>
</div>


## OpenAPI documentation:

<p align="right">
    <a href="http://localhost:8080/swagger-ui/index.html"><img src="https://img.shields.io/badge/api-green" align="right" alt="Twitter Follow" /></a>
</p>

- this application uses openAPI to expose publicly the restAPI documentation.

## Available Services
* GET - Get the pricing of a product based on a date, tariff, brand and id

## Architecture
- This project follows hexagonal modular architecture, based on 3 main modules:
- domain, here the  model is defined
- application, where the business logic happens and where the in and out ports are exposed to interact with the infrastructure module.
- infrastructure, the most extern part of the project, here we can find the rest api controller and database layers, which interacts with the application ports.


## Build and test

Build and run tests for the _pricing_ with

```shell
./mvnw clean install
```


## Run in local
- Database: H2 with a populator service
  You need to select the "local" profile.
- With local running we can check the API 

```shell
./mvnw -Dspring-boot.run.profiles=local spring-boot:run -pl infrastructure
```

## Run stg,prod
You need to select the "infra" profile.

## Actuator endpoints:
  - this project allows for keeping track of the health of the service by calling to /actuator/health endpoint.

## Testing:
  - rest-api (controller) layer, so we can test both the http request validation and response.
  - interactor (service) layer, so we can test business logic.
## Suggested improvements:
  - centralise configuration properties in a remote service which shares all common properties between related microservices.
  - add web security via token.
  - add pr-check and deployment github actions.
