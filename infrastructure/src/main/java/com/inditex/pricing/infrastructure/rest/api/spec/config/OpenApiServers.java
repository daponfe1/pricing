package com.inditex.pricing.infrastructure.rest.api.spec.config;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("openapi")
public class OpenApiServers {

  private Map<String, String> servers;
}
