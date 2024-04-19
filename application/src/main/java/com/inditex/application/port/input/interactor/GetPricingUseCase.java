package com.inditex.application.port.input.interactor;

import com.inditex.domain.entity.Pricing;
import java.time.LocalDateTime;

public interface GetPricingUseCase {
  Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
