package com.inditex.pricing.app.application.port.in.interactor;

import com.inditex.pricing.app.application.port.in.GetPricingUseCase;
import com.inditex.pricing.app.application.port.out.repository.PricingRepository;
import com.inditex.pricing.app.domain.entity.Pricing;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPricingInteractor implements GetPricingUseCase {

  private final PricingRepository pricingRepository;

  @Override
  public Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId) {
    return pricingRepository.getPricing(applicationDate, productId, brandId);
  }
}
