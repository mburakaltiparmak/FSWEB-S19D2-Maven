package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomersList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("This customer is not exist!"));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            Customer customer1 = customer.get();
            customer1.setFirstName(updatedCustomer.getFirstName());
            customer1.setLastName(updatedCustomer.getLastName());
            customer1.setEmail(updatedCustomer.getEmail());
            customer1.setAddress(updatedCustomer.getAddress());
            customer1.setSalary(updatedCustomer.getSalary());
            return customerRepository.save(customer1);
        }
        else {
            throw new RuntimeException("A problem occured when updating the customer");
        }
    }

    @Override
    public Customer delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer deletedCustomer = customerOptional.get();
            customerRepository.delete(deletedCustomer);
            return deletedCustomer;
        }
        return null;
    }
}
