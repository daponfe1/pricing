package com.inditex.pricing.infrastructure.rest.api.responses;

import com.inditex.pricing.domain.enums.Currency;
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

  @Schema(description = "Start date of the pricing")
  private LocalDateTime startDate;

  @Schema(description = "End date of the pricing")
  private LocalDateTime endDate;

  @Schema(description = "Current price")
  private Float price;

  @Schema(description = "Currency")
  private Currency currency;
}
