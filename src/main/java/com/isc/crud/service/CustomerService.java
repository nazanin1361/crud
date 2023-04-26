package com.isc.crud.service;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.entity.Customer;

public interface CustomerService extends BaseService<Customer, CustomerDto>{

    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto editCustomer(CustomerDto customerDto);
    Long deleteCustomer(CustomerDto customerDto);
}
