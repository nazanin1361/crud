package com.isc.crud.rest;


import com.isc.crud.dto.CustomerDto;
import com.isc.crud.dto.CustomerResponseDto;
import com.isc.crud.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/crud/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @GetMapping("/get-all-customer")
    public ResponseEntity<CustomerResponseDto> getAllCustomers(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(customerService.getAllCustomers(pageNo, pageSize));
    }

    @GetMapping("/find-by-id/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        return ResponseEntity.ok().body(customerService.getCustomerByCustomerId(customerId));
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
