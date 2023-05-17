package com.isc.crud.service;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.dto.CustomerResponseDto;
import com.isc.crud.entity.Customer;

public interface CustomerService extends BaseService<Customer, CustomerDto>{

    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(CustomerDto customerDto);
    Long deleteCustomer(Long customerId);
    CustomerDto getCustomerByCustomerId(Long customerId);
    CustomerResponseDto getAllCustomers(int pageNo, int pageSize);
}
