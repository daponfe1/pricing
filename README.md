# Pricing microservice

- Purpose of the microservice: manage the pricing of a product



## Build and test

Build and run tests for the _pricing_ with

```shell
./mvnw clean install
```


## Run in local
* Database: H2 with a populator service
  You need to select the "local" profile.
## Run stg,prod
You need to select the "infra" profile.

## Available Services
* GET - Get the pricing of a product based on a date, tariff, brand and id

## Actuator endpoints:
  - this project allows for keeping track of the health of the service by calling to /actuator/health endpoint.
## OpenAPI documentation:
  - this application uses openAPI to expose publicly the restAPI documentation. 
## Testing:
  - rest-api (controller) layer, so we can test both the http request validation and response.
  - interactor (service) layer, so we can test business logic.
## Suggested improvements:
  - centralise configuration properties in a remote service which shares all common properties between related microservices.
  - add web security via token.
  - add pr-check and deployment github actions.
