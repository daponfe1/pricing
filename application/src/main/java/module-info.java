module com.inditex.pricing.application {
  requires com.inditex.pricing.domain;
  requires lombok;
  requires spring.context;
  requires spring.web;

  exports com.inditex.pricing.application.exception;
  exports com.inditex.pricing.application.port.in;
  exports com.inditex.pricing.application.port.in.interactor;
  exports com.inditex.pricing.application.port.out.repository;
}
