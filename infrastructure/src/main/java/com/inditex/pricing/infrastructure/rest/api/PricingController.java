package com.inditex.pricing.infrastructure.rest.api;

import com.inditex.pricing.application.port.in.GetPricingUseCase;
import com.inditex.pricing.infrastructure.rest.api.mapper.PricingMapper;
import com.inditex.pricing.infrastructure.rest.api.responses.PricingResponseDTO;
import com.inditex.pricing.infrastructure.rest.api.spec.PricingAPI;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pricing")
@RequiredArgsConstructor
public class PricingController implements PricingAPI {

  private final GetPricingUseCase getPricingUseCase;
  private final PricingMapper pricingMapper;

  @GetMapping
  public PricingResponseDTO getPricing(
      @RequestParam("application_date") LocalDateTime applicationDate,
      @RequestParam("product_id") String productId,
      @RequestParam("brand_id") String brandId) {
    return pricingMapper.map(getPricingUseCase.getPricing(applicationDate, productId, brandId));
 }
}
