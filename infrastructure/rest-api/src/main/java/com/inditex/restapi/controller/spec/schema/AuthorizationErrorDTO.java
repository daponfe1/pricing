package com.inditex.restapi.controller.spec.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Authorization error data")
public class AuthorizationErrorDTO {

  @JsonProperty("error")
  @Schema(description = "Error message")
  private String error;

  @JsonProperty("error_description")
  @Schema(description = "Error description")
  private String errorDescription;
}
