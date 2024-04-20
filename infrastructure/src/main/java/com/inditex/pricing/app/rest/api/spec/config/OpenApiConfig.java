package com.inditex.pricing.app.rest.api.spec.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  private static final String SERVER_DESCRIPTION = "URL %s:";

  @Bean
  public OpenApiInfo openApiInfo() {
    return new OpenApiInfo();
  }

  @Bean
  public OpenApiServers openApiServers() {
    return new OpenApiServers();
  }

  @Bean
  public OpenAPI customOpenAPI(OpenApiInfo info, OpenApiServers servers) {

    return new OpenAPI()
        .info(new Info().title(info.getTitle()).description(info.getDescription()))
        .servers(
            servers.getServers().entrySet().stream()
                .map(
                    entry ->
                        new Server()
                            .description(
                                String.format(SERVER_DESCRIPTION, entry.getKey().toUpperCase()))
                            .url(entry.getValue()))
                .collect(Collectors.toList()));
  }

  @Bean
  public ModelResolver modelResolver(ObjectMapper objectMapper) {
    return new ModelResolver(objectMapper);
  }
}
