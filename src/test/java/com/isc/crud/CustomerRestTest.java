package com.isc.crud;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    void getAllCustomers() throws Exception {
        List<CustomerDto> mockCustomerDtoList  = new ArrayList<>();
        mockCustomerDtoList.add(CustomerDto.builder()
                .id(1L)
                .name("Sara")
                .family("Ahmadi")
                .nationalIdentifier("0039876543")
                .birthDate(13610606)
                .postalCode(BigDecimal.valueOf(1245698745))
                .address("addr1")
                .mobileNumber("091223456789")
                .personalEmail("sara@gmail.com")
                .build());
        mockCustomerDtoList.add(CustomerDto.builder()
                .id(2L)
                .name("Tara")
                .family("Akbari")
                .nationalIdentifier("0039876543")
                .birthDate(13680405)
                .postalCode(BigDecimal.valueOf(1245698987))
                .address("addr2")
                .mobileNumber("091223637864")
                .personalEmail("tara@gmail.com")
                .build());
        Mockito.when(customerService.findAll()).thenReturn(mockCustomerDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/crud/customer/get-all-customer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Sara")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Tara")));
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    void updateCustomer() throws Exception {
        CustomerDto mockCustomerDto = CustomerDto.builder()
                .id(1L)
                .name("Sara")
                .family("Ahmadi")
                .nationalIdentifier("0039876543")
                .birthDate(13610606)
                .postalCode(BigDecimal.valueOf(1245698745))
                .address("addr1")
                .mobileNumber("091223456789")
                .personalEmail("sara@gmail.com")
                .build();

        CustomerDto mockUpdatedCustomerDto = CustomerDto.builder()
                .id(1L)
                .name("Sara")
                .family("Ahmadi")
                .nationalIdentifier("0039876543")
                .birthDate(13610606)
                .postalCode(BigDecimal.valueOf(1245698745))
                .address("Street1")
                .mobileNumber("091223456789")
                .personalEmail("sara.ahmadi@gmail.com")
                .build();

        Mockito.when(customerService.findById(mockCustomerDto.getId())).thenReturn(mockCustomerDto);

        Mockito.when(customerService.editCustomer(any(CustomerDto.class)))
                .thenReturn(mockUpdatedCustomerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/crud/customer/update-customer", mockCustomerDto.getId())
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "id": 1,
                                  "name": "Sara",
                                  "family": "Ahmadi",
                                  "nationalIdentifier": "0039876543",
                                  "birthDate": 13610606,
                                  "postalCode": 1245698745,
                                  "address": "Street1",
                                  "mobileNumber": "091223456789",
                                  "personalEmail": "sara.ahmadi@gmail.com"
                                  }
                                """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.personalEmail", Matchers.is("sara.ahmadi@gmail.com")));
    }


}
