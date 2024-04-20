package com.inditex.pricing.app.application.port.in;

import com.inditex.pricing.app.domain.entity.Pricing;
import java.time.LocalDateTime;

public interface GetPricingUseCase {
  Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
