 package com.inditex.restapi.controller;

 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 import com.fasterxml.jackson.databind.ObjectMapper;
 import com.inditex.application.port.input.interactor.GetPricingUseCase;
 import com.inditex.restapi.controller.mapper.PricingMapper;
 import java.time.LocalDateTime;
 import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.boot.test.mock.mockito.MockBean;
 import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest(PricingController.class)
// @SpringBootTest(classes = {PricingController.class})
// @SpringBootTest(
//    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//    classes = {PricingController.class})
 @WebMvcTest(PricingController.class)
 public class PricingControllerTest {

  @Autowired private MockMvc mvc;
  @Autowired private ObjectMapper objectMapper;

//  @MockBean private GetPricingUseCase getPricingUseCase;
//  @MockBean private PricingMapper pricingMapper;

  @Test
  public void givenGetInsurerTypes_thenStatus200() throws Exception {

    mvc.perform(
            get("/api/v1/pricing")
                .param("application_date", LocalDateTime.of(2020, 6, 14, 10, 0, 0).toString())
                .param("product_id", "35455")
                //                    .param("brand_id", "1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
 }
////  //
////  //  @Test
////  //  public void givenGetInsurerCompaniesByType_thenStatus200() throws Exception {
////  //
////  //    mvc.perform(
////  //            get("/api/v1/application/insurer-companies")
////  //                .queryParam("insurer_type_id", "c49df48a-883c-424c-b325-27857a7bd570")
////  //                .contentType(MediaType.APPLICATION_JSON))
////  //        .andExpect(status().isOk())
////  //        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
////  //  }
////  //
////  //  @Test
////  //  public void
//// givenCreateSpecificApplication_whenInsuranceTypeOrCompanyIsMissing_thenStatus400()
////  //      throws Exception {
////  //
////  //    mvc.perform(
////  //            post("/api/v1/application")
////  //                .contentType(MediaType.APPLICATION_JSON)
////  //                .content(
////  //                    objectMapper.writeValueAsString(
////  //                        buildBadRequestMissingInsurerFieldsApplicationRequest())))
////  //        .andExpect(status().isBadRequest());
////  //  }
////  //
////  //  @Test
////  //  public void givenCreateSpecificApplication_whenDocsAreMissing_thenStatus400() throws
//// Exception
////  // {
////  //
////  //    mvc.perform(
////  //            post("/api/v1/application")
////  //                .contentType(MediaType.APPLICATION_JSON)
////  //                .content(
////  //                    objectMapper.writeValueAsString(
////  //                        buildBadRequestMissingDocFieldsApplicationRequest())))
////  //        .andExpect(status().isBadRequest());
////  //  }
////  //
////  //  @Test
////  //  public void givenCreateApplication_thenStatus200() throws Exception {
////  //
////  //    mvc.perform(
////  //            post("/api/v1/application")
////  //                .contentType(MediaType.APPLICATION_JSON)
////  //
// .content(objectMapper.writeValueAsString(buildSpecificApplicationRequest())))
////  //        .andExpect(status().isOk());
////  //  }
////  //
////  //  private ApplicationRequestDTO buildSpecificApplicationRequest() {
////  //    return ApplicationRequestDTO.builder()
////  //        .leadId("1234")
////  //        .isGeneralRequest(false)
////  //        .insuranceType(UUID.randomUUID())
////  //        .insuranceCompany(UUID.randomUUID())
////  //        .language(Language.de)
////  //        .selectedDocuments(List.of(DocumentDTO.builder().url("test").build()))
////  //        .applicationLines(
////  //            List.of(
////  //                ApplicationLineDTO.builder()
////  //                    .firstName("Tony")
////  //                    .lastName("Montana")
////  //                    .offerNumber("test")
////  //                    .build()))
////  //        .build();
////  //  }
////  //
////  //  private ApplicationRequestDTO buildBadRequestMissingInsurerFieldsApplicationRequest() {
////  //    return ApplicationRequestDTO.builder()
////  //        .leadId("1234")
////  //        .isGeneralRequest(false)
////  //        .language(Language.de)
////  //        .build();
////  //  }
////  //
////  //  private ApplicationRequestDTO buildBadRequestMissingDocFieldsApplicationRequest() {
////  //    return ApplicationRequestDTO.builder()
////  //        .leadId("1234")
////  //        .isGeneralRequest(false)
////  //        .insuranceType(UUID.randomUUID())
////  //        .insuranceCompany(UUID.randomUUID())
////  //        .language(Language.de)
////  //        .build();
////  //  }
//// }
