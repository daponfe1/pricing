package com.inditex.pricing.app.adapter.database.mapper;

import com.inditex.pricing.app.adapter.database.entity.PricingEntity;
import com.inditex.pricing.app.domain.entity.Pricing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricingRepositoryMapper {

  @Mapping(target = "productId", source = "pricingEntity.product.id")
  @Mapping(target = "brandId", source = "pricingEntity.brand.id")
  @Mapping(target = "tariffId", source = "pricingEntity.tariff.id")
  Pricing map(PricingEntity pricingEntity);
}
