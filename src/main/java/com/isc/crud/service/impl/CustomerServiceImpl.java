package com.isc.crud.service.impl;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.entity.Customer;
import com.isc.crud.mapper.BaseMapper;
import com.isc.crud.mapper.CustomerMapper;
import com.isc.crud.repository.CustomerRepository;
import com.isc.crud.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerDto>
        implements CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    @Transactional
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return mapper.toDto(repository.save(mapper.toEntity(customerDto)));
    }

    @Override
    public CustomerDto editCustomer(CustomerDto customerDto) {

        return null;
    }
    @Transactional
    @Override
    public Long deleteCustomer(CustomerDto customerDto) {

        getCrudRepository().delete(mapper.toEntity(customerDto));
        return customerDto.getId();
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return mapper.toDto(getCrudRepository().findById(id).orElse(null));
    }

    @Override
    public BaseMapper<Customer, CustomerDto> getMapper() {
        return mapper;
    }

    @Override
    public CrudRepository<Customer, Long> getCrudRepository() {
        return repository;
    }
}
