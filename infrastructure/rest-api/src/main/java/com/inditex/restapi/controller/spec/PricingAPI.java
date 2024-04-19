package com.inditex.restapi.controller.spec;

import com.inditex.restapi.controller.dto.responses.PricingResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;

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
            schema = @Schema(implementation = LocalDateTime.class)),
        @Parameter(
            in = ParameterIn.QUERY,
            name = "endDate",
            description = "End date of the pricing application",
            schema = @Schema(implementation = LocalDateTime.class)),
        @Parameter(
            in = ParameterIn.QUERY,
            name = "productId",
            description = "Product id",
            schema = @Schema(type = "string")),
        @Parameter(
            in = ParameterIn.QUERY,
            name = "brandId",
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
                    schema = @Schema(implementation = ResponseStatusException.class)))
      })
  PricingResponseDTO getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
