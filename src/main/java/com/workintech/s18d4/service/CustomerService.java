package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getCustomersList();
    Customer findCustomerById(Long id);
    Customer save(Customer customer);
    Customer update(Long id,Customer updatedCustomer);
    Customer delete(Long id);
}
