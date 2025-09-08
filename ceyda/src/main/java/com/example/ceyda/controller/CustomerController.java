package com.example.ceyda.controller;

import com.example.ceyda.dto.request.CustomerRequest;
import com.example.ceyda.dto.response.CustomerResponse;
import com.example.ceyda.entity.Customer;
import com.example.ceyda.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        customerService.createCustomer(customer);
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);
        return customerResponse;
    }
    @GetMapping("/{id}")
    public CustomerResponse getCustomer( @PathVariable Long id){
        Customer customer=customerService.getCustomerById(id);
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);
        return customerResponse;
    }
}
