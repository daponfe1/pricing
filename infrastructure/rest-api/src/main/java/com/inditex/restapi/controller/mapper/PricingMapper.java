package com.inditex.restapi.controller.mapper;

import com.inditex.domain.entity.Pricing;
import com.inditex.restapi.controller.dto.responses.PricingResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricingMapper {

  PricingResponseDTO map(Pricing draft);
}
