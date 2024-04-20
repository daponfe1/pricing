package com.inditex.pricing.app.rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pricing")
@RequiredArgsConstructor
public class PricingController {

  //  private final GetPricingUseCase getPricingUseCase;
  //  private final PricingMapper pricingMapper;

  @GetMapping
  public void getPricing() {
    //      @RequestParam("application_date") LocalDateTime applicationDate,
    //      @RequestParam("product_id") String productId,
    //      @RequestParam("brand_id") String brandId) {
    //    return pricingMapper.map(getPricingUseCase.getPricing(applicationDate, productId,
    // brandId));
  }
}
