package com.inditex.pricing.application.port.out.repository;

import com.inditex.pricing.domain.entity.Pricing;
import java.time.LocalDateTime;

public interface PricingRepository {

  Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
