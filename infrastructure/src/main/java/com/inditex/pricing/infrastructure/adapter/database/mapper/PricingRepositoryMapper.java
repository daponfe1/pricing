package com.inditex.pricing.infrastructure.adapter.database.mapper;

import com.inditex.pricing.domain.entity.Pricing;
import com.inditex.pricing.infrastructure.adapter.database.entity.PricingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricingRepositoryMapper {

  @Mapping(target = "productId", source = "pricingEntity.product.id")
  @Mapping(target = "brandId", source = "pricingEntity.brand.id")
  @Mapping(target = "tariffId", source = "pricingEntity.tariff.id")
  Pricing map(PricingEntity pricingEntity);
}
