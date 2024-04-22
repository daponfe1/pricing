package com.inditex.pricing.infrastructure.rest.api.mapper;

import com.inditex.pricing.domain.entity.Pricing;
import com.inditex.pricing.infrastructure.rest.api.responses.PricingResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricingMapper {

  PricingResponseDTO map(Pricing draft);
}
