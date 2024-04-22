package com.inditex.pricing.infrastructure.adapter.database.repository;

import com.inditex.pricing.application.exception.ApplicationException;
import com.inditex.pricing.application.port.out.repository.PricingRepository;
import com.inditex.pricing.domain.entity.Pricing;
import com.inditex.pricing.infrastructure.adapter.database.mapper.PricingRepositoryMapper;
import com.inditex.pricing.infrastructure.adapter.database.repository.h2.PricingH2Repository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricingDBAdapter implements PricingRepository {

  private final PricingH2Repository pricingH2Repository;
  private final PricingRepositoryMapper pricingRepositoryMapper;

  private static final String ERROR_PRICING_NOT_FOUND =
      "Pricing not found for application date %s, productId %s and brandId %s";

  public Pricing getPricing(LocalDateTime applicationDate, String productId, String brandId) {

    return pricingRepositoryMapper.map(
        pricingH2Repository
            .findByApplicationDatesAndProductAndBrand(applicationDate, productId, brandId)
            .orElseThrow(
                () ->
                    new ApplicationException(
                        HttpStatus.NOT_FOUND,
                        String.format(
                            ERROR_PRICING_NOT_FOUND,
                            applicationDate.toString(),
                            productId,
                            brandId))));
  }
}
