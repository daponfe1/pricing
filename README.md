# Pricing microservice

- OpenAPI documentation:
  - this application uses openAPI to expose publicly the restAPI documentation. 
- testing:
  - rest-api (controller) layer, so we can test not only the http response and the request validation.
  - interactor (service) layer, so we can test business logic.
- improvements:
  - centralise configuration properties in a remote service which shares all common properties between related microservices.
  - add web security via token.
  - add pr-check and deployment github actions.