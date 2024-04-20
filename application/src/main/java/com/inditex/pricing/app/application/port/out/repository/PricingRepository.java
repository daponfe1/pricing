package com.inditex.pricing.app.application.port.out.repository;

import com.inditex.pricing.app.domain.entity.Pricing;
import java.time.LocalDateTime;

public interface PricingRepository {

  Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId);
}
