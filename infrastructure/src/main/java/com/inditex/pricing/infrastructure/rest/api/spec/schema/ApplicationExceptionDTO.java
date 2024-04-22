package com.inditex.pricing.infrastructure.rest.api.spec.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Application exception data")
public class ApplicationExceptionDTO {

  @JsonProperty("path")
  @Schema(description = "Path of the request")
  private String path;

  @JsonProperty("status")
  @Schema(description = "Response status")
  private String status;

  @JsonProperty("error")
  @Schema(description = "Error naming of the status response")
  private String error;

  @JsonProperty("timestamp")
  @Schema
  private Date timestamp;

  @JsonProperty("message")
  @Schema(description = "Error message")
  private String message;
}
