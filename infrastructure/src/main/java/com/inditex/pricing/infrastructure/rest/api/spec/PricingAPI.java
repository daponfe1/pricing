package com.inditex.pricing.infrastructure.rest.api.spec;

import com.inditex.pricing.application.exception.ApplicationException;
import com.inditex.pricing.infrastructure.rest.api.responses.PricingResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import org.springframework.http.MediaType;

@Tag(name = "/api/v1/pricing")
public interface PricingAPI {

  @Operation(
      summary = "Get pricing list",
      description =
          "Gets the requested pricing fields for a product having the provided start date of the pricing application, product id and brand id",
      parameters = {
        @Parameter(
            in = ParameterIn.QUERY,
            name = "applicationDate",
            description = "Applying date of the pricing",
            example = "2020-06-14T21:00:00",
            schema = @Schema(implementation = LocalDateTime.class)),
        @Parameter(
            in = ParameterIn.QUERY,
            name = "productId",
            description = "Product id",
            example = "35455",
            schema = @Schema(type = "string")),
        @Parameter(
            in = ParameterIn.QUERY,
            name = "brandId",
            example = "1",
            description = "Brand id of the product",
            schema = @Schema(type = "string")),
      },
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Pricing object retrieved successfully",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PricingResponseDTO.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Not found",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApplicationException.class)))
      })
  PricingResponseDTO getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
