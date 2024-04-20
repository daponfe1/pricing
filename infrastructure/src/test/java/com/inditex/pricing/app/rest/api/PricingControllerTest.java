package com.inditex.pricing.app.rest.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.pricing.app.adapter.database.mapper.PricingRepositoryMapper;
import com.inditex.pricing.app.adapter.database.repository.h2.PricingH2Repository;
import com.inditex.pricing.app.application.port.in.GetPricingUseCase;
import com.inditex.pricing.app.application.port.out.repository.PricingRepository;
import com.inditex.pricing.app.domain.enums.Currency;
import com.inditex.pricing.app.model.ModelData;
import com.inditex.pricing.app.rest.api.mapper.PricingMapper;
import java.time.LocalDateTime;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(PricingController.class)
class PricingControllerTest {

  @Autowired private ModelData modelData;
  @Autowired private MockMvc mockMvc;
  @Autowired private GetPricingUseCase getPricingUseCase;
  @Autowired private PricingMapper pricingMapper;
  @Autowired private PricingRepository pricingRepository;
  @Autowired private PricingRepositoryMapper pricingRepositoryMapper;
  @Autowired private PricingH2Repository pricingH2Repository;

  @BeforeAll
  void init() {
    modelData.thereAreInsuranceTypesAndCompanies();
  }

  @Test
  void getPricingWithoutRequiredParametersThenBadRequestError() throws Exception {
    mockMvc.perform(get("/api/v1/pricing")).andExpect(status().isBadRequest());
  }

  @Test
  void getPricingGivenUnknownProductThenNotFoundError() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(1990, 1, 1, 0, 0, 0).toString())
                .param("product_id", "1234")
                .param("brand_id", "1"))
        .andExpect(status().isNotFound());
  }

  @Test
  void getPricingGivenRequestedValuesThenGetCorrect_1() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 06, 14, 10, 0, 0).toString())
                .param("product_id", "35455")
                .param("brand_id", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", Is.is("35455")))
        .andExpect(jsonPath("$.brand_id", Is.is("1")))
        .andExpect(jsonPath("$.tariff_id", Is.is("1")))
        .andExpect(jsonPath("$.start_date", Is.is("2020-06-14T00:00:00")))
        .andExpect(jsonPath("$.end_date", Is.is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", Is.is(35.50)))
        .andExpect(jsonPath("$.currency", Is.is(Currency.EUR.name())));
  }

  @Test
  void getPricingGivenRequestedValuesThenGetCorrect_2() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 06, 14, 16, 0, 0).toString())
                .param("product_id", "35455")
                .param("brand_id", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", Is.is("35455")))
        .andExpect(jsonPath("$.brand_id", Is.is("1")))
        .andExpect(jsonPath("$.tariff_id", Is.is("2")))
        .andExpect(jsonPath("$.start_date", Is.is("2020-06-14T15:00:00")))
        .andExpect(jsonPath("$.end_date", Is.is("2020-06-14T18:30:00")))
        .andExpect(jsonPath("$.price", Is.is(25.45)))
        .andExpect(jsonPath("$.currency", Is.is(Currency.EUR.name())));
  }

  @Test
  void getPricingGivenRequestedValuesThenGetCorrect_3() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 06, 14, 21, 0, 0).toString())
                .param("product_id", "35455")
                .param("brand_id", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", Is.is("35455")))
        .andExpect(jsonPath("$.brand_id", Is.is("1")))
        .andExpect(jsonPath("$.tariff_id", Is.is("1")))
        .andExpect(jsonPath("$.start_date", Is.is("2020-06-14T00:00:00")))
        .andExpect(jsonPath("$.end_date", Is.is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", Is.is(35.50)))
        .andExpect(jsonPath("$.currency", Is.is(Currency.EUR.name())));
  }

  @Test
  void getPricingGivenRequestedValuesThenGetCorrect_4() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 06, 15, 10, 0, 0).toString())
                .param("product_id", "35455")
                .param("brand_id", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", Is.is("35455")))
        .andExpect(jsonPath("$.brand_id", Is.is("1")))
        .andExpect(jsonPath("$.tariff_id", Is.is("3")))
        .andExpect(jsonPath("$.start_date", Is.is("2020-06-15T00:00:00")))
        .andExpect(jsonPath("$.end_date", Is.is("2020-06-15T11:00:00")))
        .andExpect(jsonPath("$.price", Is.is(30.50)))
        .andExpect(jsonPath("$.currency", Is.is(Currency.EUR.name())));
  }

  @Test
  void getPricingGivenRequestedValuesThenGetCorrect_5() throws Exception {
    mockMvc
        .perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 06, 16, 21, 0, 0).toString())
                .param("product_id", "35455")
                .param("brand_id", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.product_id", Is.is("35455")))
        .andExpect(jsonPath("$.brand_id", Is.is("1")))
        .andExpect(jsonPath("$.tariff_id", Is.is("4")))
        .andExpect(jsonPath("$.start_date", Is.is("2020-06-16T15:00:00")))
        .andExpect(jsonPath("$.end_date", Is.is("2020-12-31T23:59:59")))
        .andExpect(jsonPath("$.price", Is.is(38.95)))
        .andExpect(jsonPath("$.currency", Is.is(Currency.EUR.name())));
  }
}
