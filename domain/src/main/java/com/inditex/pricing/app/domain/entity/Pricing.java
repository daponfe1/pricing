package com.inditex.pricing.app.domain.entity;

import com.inditex.pricing.app.domain.enums.Currency;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pricing {
  private String productId;
  private String brandId;
  private String tariffId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Short priority;
  private Float price;
  private Currency currency;
}
