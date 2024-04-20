package com.inditex.pricing.app.rest.api.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.pricing.app.domain.enums.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PricingResponseDTO {

  @Schema(description = "Product id")
  private String productId;

  @Schema(description = "Product id")
  private String brandId;

  @Schema(description = "Applying tariff on the product")
  private String tariffId;

  @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
  @Schema(description = "Application date of the pricing")
  private LocalDateTime applicationDate;

  @Schema(description = "Current price")
  private Float price;

  @Schema(description = "Currency")
  private Currency currency;
}
