package com.isc.crud.rest;


import com.isc.crud.dto.CustomerDto;
import com.isc.crud.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/crud/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @GetMapping("/get-all-customer")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/find-by-id/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        return ResponseEntity.ok().body(customerService.findById(customerId));
    }

    @PostMapping("/add-customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(customerService.createCustomer(customerDto));
    }

    @PostMapping("/delete-customer")
    public ResponseEntity<Long> deleteCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(customerService.deleteCustomer(customerDto));
    }

    @PostMapping("/update-customer")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(customerService.editCustomer(customerDto));
    }








}
