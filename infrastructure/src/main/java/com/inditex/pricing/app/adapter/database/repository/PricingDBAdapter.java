package com.inditex.pricing.app.adapter.database.repository;

import com.inditex.pricing.app.adapter.database.entity.PricingEntity;
import com.inditex.pricing.app.adapter.database.mapper.PricingRepositoryMapper;
import com.inditex.pricing.app.adapter.database.repository.h2.PricingH2Repository;
import com.inditex.pricing.app.application.exception.ApplicationException;
import com.inditex.pricing.app.application.port.out.repository.PricingRepository;
import com.inditex.pricing.app.domain.entity.Pricing;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
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

    List<PricingEntity> pricings =
        pricingH2Repository.findByApplicationDatesAndProductAndBrand(
            applicationDate, productId, brandId);

    if (pricings.isEmpty()) {
      throw new ApplicationException(
          HttpStatus.NOT_FOUND,
          String.format(ERROR_PRICING_NOT_FOUND, applicationDate.toString(), productId, brandId));
    }
    PricingEntity pricing =
        pricings.stream().max(Comparator.comparing(PricingEntity::getPriority)).get();
    return pricingRepositoryMapper.map(pricing);
  }
}
