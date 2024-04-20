package com.inditex.pricing.app.application.port.in.interactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.inditex.pricing.app.application.port.in.GetPricingUseCase;
import com.inditex.pricing.app.application.port.out.repository.PricingRepository;
import com.inditex.pricing.app.domain.entity.Pricing;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPricingInteractorTest {

  private GetPricingUseCase getPricingUseCase;

  @Mock private PricingRepository pricingRepository;

  @BeforeEach
  public void init() {
    getPricingUseCase = new GetPricingInteractor(pricingRepository);
  }

  @Test
  void getPricingGivenParamsThenSuccess() {
    when(pricingRepository.getPricing(any(LocalDateTime.class), anyString(), anyString()))
        .thenReturn(buildPricingExample());
    Pricing result = getPricingUseCase.getPricing(LocalDateTime.now(), "1234", "1");
    assertNotNull(result);
    assertEquals("1234", result.getProductId());
  }

  private Pricing buildPricingExample() {
    return Pricing.builder().productId("1234").build();
  }
}
