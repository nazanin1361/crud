package com.isc.crud.rest;


import com.isc.crud.dto.CustomerDto;
import com.isc.crud.dto.CustomerResponseDto;
import com.isc.crud.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<CustomerResponseDto> getAllCustomers(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(customerService.getAllCustomers(pageNo, pageSize));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        return ResponseEntity.ok().body(customerService.getCustomerByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(customerService.createCustomer(customerDto));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
        return ResponseEntity.ok().body(customerService.deleteCustomer(customerId));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok().body(customerService.editCustomer(customerDto));
    }








}
