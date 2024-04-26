package com.inditex.pricing.infrastructure.adapter.database.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.inditex.pricing.application.exception.ApplicationException;
import com.inditex.pricing.domain.entity.Pricing;
import com.inditex.pricing.infrastructure.adapter.database.entity.BrandEntity;
import com.inditex.pricing.infrastructure.adapter.database.entity.PricingEntity;
import com.inditex.pricing.infrastructure.adapter.database.entity.ProductEntity;
import com.inditex.pricing.infrastructure.adapter.database.entity.TariffEntity;
import com.inditex.pricing.infrastructure.adapter.database.mapper.PricingRepositoryMapper;
import com.inditex.pricing.infrastructure.adapter.database.repository.h2.PricingH2Repository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PricingAdapterDBTest {

  private PricingDBAdapter pricingDBAdapter;

  @Mock private PricingH2Repository pricingH2Repository;
  @Spy private PricingRepositoryMapper pricingRepositoryMapper;

  private final String productId = "1234";
  private final String brandId = "1";
  private final String tariffId = "1";

  @BeforeEach
  public void init() {
    pricingDBAdapter = new PricingDBAdapter(pricingH2Repository, pricingRepositoryMapper);
  }

  @Test
  void getPricingGivenParamsWhenPricingNotFoundThenThrowError() {
    when(pricingH2Repository.findByApplicationDatesAndProductAndBrand(
            any(LocalDateTime.class), anyString(), anyString()))
        .thenReturn(Optional.empty());
    ApplicationException result =
        Assertions.assertThrows(
            ApplicationException.class,
            () -> pricingDBAdapter.getPricing(LocalDateTime.now(), productId, brandId));

    assertEquals(HttpStatus.NOT_FOUND, result.getStatus());
    assertTrue(result.getMessage().contains(productId));
    assertTrue(result.getMessage().contains(brandId));
  }

  @Test
  void getPricingGivenParamsThenSuccess() {
    when(pricingRepositoryMapper.map(any(PricingEntity.class))).thenReturn(buildPricing());
    when(pricingH2Repository.findByApplicationDatesAndProductAndBrand(
            any(LocalDateTime.class), anyString(), anyString()))
        .thenReturn(Optional.of(buildPricingEntity()));
    Pricing result = pricingDBAdapter.getPricing(LocalDateTime.now(), "1234", "1");

    assertNotNull(result);
    assertEquals(productId, result.getProductId());
    assertEquals(brandId, result.getBrandId());
    assertEquals(tariffId, result.getTariffId());
  }

  private PricingEntity buildPricingEntity() {
    return PricingEntity.builder()
        .id(UUID.randomUUID())
        .product(ProductEntity.builder().id(Long.valueOf(productId)).build())
        .brand(BrandEntity.builder().id(Long.valueOf(brandId)).build())
        .tariff(TariffEntity.builder().id(Long.valueOf(tariffId)).build())
        .build();
  }

  private Pricing buildPricing() {
    return Pricing.builder().productId(productId).brandId(brandId).tariffId(tariffId).build();
  }
}
