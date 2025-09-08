package com.example.ceyda.service.impl;

import com.example.ceyda.entity.Customer;
import com.example.ceyda.repository.CustomerRepository;
import com.example.ceyda.repository.StudentRepository;
import com.example.ceyda.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }
}
