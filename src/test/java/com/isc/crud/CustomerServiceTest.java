package com.isc.crud;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.entity.Customer;
import com.isc.crud.mapper.CustomerMapper;
import com.isc.crud.repository.CustomerRepository;
import com.isc.crud.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;


    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);


    @Test
    void getCustomer() {
        List<Customer> mockCustomerList = new ArrayList<>();
        mockCustomerList.add(Customer.builder()
                .id(1L)
                .name("Sara")
                .family("Ahmadi")
                .nationalIdentifier("0039876543")
                .birthDate(13610606)
                .postalCode(BigDecimal.valueOf(1245698745))
                .address("addr1")
                .gender(1)
                .mobileNumber("091223456789")
                .personalEmail("sara@gmail.com")
                .build());
        mockCustomerList.add(Customer.builder()
                .id(2L)
                .name("Tara")
                .family("Akbari")
                .nationalIdentifier("0039876543")
                .birthDate(13680405)
                .postalCode(BigDecimal.valueOf(1245698987))
                .address("addr2")
                .gender(1)
                .mobileNumber("091223637864")
                .personalEmail("tara@gmail.com")
                .build());
        Mockito.when(customerRepository.findAll()).thenReturn(mockCustomerList);
        List<CustomerDto> mockCustomerDtoList = customerMapper.toDtoList(mockCustomerList);
        List<CustomerDto> result = customerService.findAll();
        Assertions.assertEquals(mockCustomerDtoList, result);
    }

    @Test
    void insert() {
        Customer customer = Customer.builder()
                .id(1L)
                .name("Sara")
                .family("Ahmadi")
                .nationalIdentifier("0039876543")
                .birthDate(13610606)
                .postalCode(BigDecimal.valueOf(1245698745))
                .address("addr1")
                .gender(1)
                .mobileNumber("091223456789")
                .personalEmail("sara@gmail.com")
                .build();
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        CustomerDto customerDto = customerService.createCustomer(customerMapper.toDto(customer));
        Assertions.assertEquals(customer.getName(), customerDto.getName());
    }

}
