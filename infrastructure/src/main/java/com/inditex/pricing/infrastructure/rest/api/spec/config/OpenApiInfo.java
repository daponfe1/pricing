package com.inditex.pricing.infrastructure.rest.api.spec.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("openapi.info")
public class OpenApiInfo {

  private String title;
  private String description;
}
