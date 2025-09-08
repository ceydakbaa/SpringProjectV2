package com.example.ceyda.service;

import com.example.ceyda.entity.Customer;

import java.util.List;

public interface CustomerService {

  public Customer createCustomer(Customer customer);
  public Customer getCustomerById(Long id);


}
