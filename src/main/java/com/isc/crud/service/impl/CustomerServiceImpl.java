package com.isc.crud.service.impl;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.dto.CustomerResponseDto;
import com.isc.crud.entity.Customer;
import com.isc.crud.exception.NotFoundException;
import com.isc.crud.mapper.BaseMapper;
import com.isc.crud.mapper.CustomerMapper;
import com.isc.crud.repository.CustomerRepository;
import com.isc.crud.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
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
        Customer existingCustomer = getCustomer(customerDto.getId());

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setFamily(customerDto.getFamily());
        existingCustomer.setNationalIdentifier(customerDto.getNationalIdentifier());
        existingCustomer.setBirthDate(customerDto.getBirthDate());
        existingCustomer.setPostalCode(customerDto.getPostalCode());
        existingCustomer.setAddress(customerDto.getAddress());
        existingCustomer.setMobileNumber(customerDto.getMobileNumber());
        existingCustomer.setPersonalEmail(customerDto.getPersonalEmail());

        return getMapper().toDto(getRepository().save(existingCustomer));
    }

    private Customer getCustomer(Long customerId) {
        return getRepository().findById(customerId)
                .orElseThrow(() -> {
                    log.error("Customer with Id {} not found", customerId);
                    throw new NotFoundException("Customer not found");
                });
    }


    @Transactional
    @Override
    public Long deleteCustomer(CustomerDto customerDto) {
        Customer existingCustomer = getCustomer(customerDto.getId());
        getRepository().delete(existingCustomer);
        return customerDto.getId();
    }

    @Override
    public CustomerDto getCustomerByCustomerId(Long customerId) {
        return getMapper().toDto(getCustomer(customerId));
    }

    @Override
    public CustomerResponseDto getAllCustomers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Customer> customers = getRepository().findAll(pageable);
        List<CustomerDto> customerDtoList = customers.getContent().stream().map(customer -> getMapper().toDto(customer)).collect(Collectors.toList());

        return CustomerResponseDto.builder()
                .customerDtoList(customerDtoList)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalElements(customers.getTotalElements())
                .totalPages(customers.getTotalPages())
                .last(customers.isLast())
                .build();
    }

    @Override
    public BaseMapper<Customer, CustomerDto> getMapper() {
        return mapper;
    }

    @Override
    public JpaRepository<Customer, Long> getRepository() {
        return repository;
    }
}
