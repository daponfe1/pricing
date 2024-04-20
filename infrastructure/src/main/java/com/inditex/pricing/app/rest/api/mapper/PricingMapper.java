package com.inditex.pricing.app.rest.api.mapper;

import com.inditex.pricing.app.domain.entity.Pricing;
import com.inditex.pricing.app.rest.api.responses.PricingResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricingMapper {

  PricingResponseDTO map(Pricing draft);
}
