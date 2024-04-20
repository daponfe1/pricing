package com.inditex.pricing.app.model;

import com.inditex.pricing.app.adapter.database.entity.BrandEntity;
import com.inditex.pricing.app.adapter.database.entity.PricingEntity;
import com.inditex.pricing.app.adapter.database.entity.ProductEntity;
import com.inditex.pricing.app.adapter.database.entity.TariffEntity;
import com.inditex.pricing.app.adapter.database.repository.h2.BrandH2Repository;
import com.inditex.pricing.app.adapter.database.repository.h2.PricingH2Repository;
import com.inditex.pricing.app.adapter.database.repository.h2.ProductH2Repository;
import com.inditex.pricing.app.adapter.database.repository.h2.TariffH2Repository;
import com.inditex.pricing.app.domain.enums.Currency;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelData {

  private final ProductH2Repository productH2Repository;
  private final BrandH2Repository brandH2Repository;
  private final TariffH2Repository tariffH2Repository;
  private final PricingH2Repository pricingH2Repository;

  public void thereAreInsuranceTypesAndCompanies() {

    ProductEntity product = ProductEntity.builder().id(35455L).additional("white shirt").build();
    productH2Repository.save(product);

    BrandEntity brand = BrandEntity.builder().id(1L).name("ZARA").build();
    brandH2Repository.save(brand);

    TariffEntity tariff1 = TariffEntity.builder().id(1L).additional("spring promo").build();
    TariffEntity tariff2 = TariffEntity.builder().id(2L).additional("spring promo").build();
    TariffEntity tariff3 = TariffEntity.builder().id(3L).additional("spring promo").build();
    TariffEntity tariff4 = TariffEntity.builder().id(4L).additional("spring promo").build();
    tariffH2Repository.saveAll(List.of(tariff1, tariff2, tariff3, tariff4));

    PricingEntity pricing1 =
        PricingEntity.builder()
            .product(product)
            .brand(brand)
            .tariff(tariff1)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority((short) 0)
            .price(35.50f)
            .currency(Currency.EUR)
            .build();

    PricingEntity pricing2 =
        PricingEntity.builder()
            .product(product)
            .brand(brand)
            .tariff(tariff2)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
            .priority((short) 1)
            .price(25.45f)
            .currency(Currency.EUR)
            .build();

    PricingEntity pricing3 =
        PricingEntity.builder()
            .product(product)
            .brand(brand)
            .tariff(tariff3)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
            .priority((short) 1)
            .price(30.50f)
            .currency(Currency.EUR)
            .build();

    PricingEntity pricing4 =
        PricingEntity.builder()
            .product(product)
            .brand(brand)
            .tariff(tariff4)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priority((short) 1)
            .price(38.95f)
            .currency(Currency.EUR)
            .build();

    pricingH2Repository.saveAll(List.of(pricing1, pricing2, pricing3, pricing4));
  }
}
