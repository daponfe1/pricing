package com.inditex.pricing.application.port.in;

import com.inditex.pricing.domain.entity.Pricing;
import java.time.LocalDateTime;

public interface GetPricingUseCase {
  Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
