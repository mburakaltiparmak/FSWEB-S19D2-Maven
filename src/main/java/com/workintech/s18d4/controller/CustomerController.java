package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomerList(){
        return customerService.getCustomersList();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable("id") Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer){
        Customer savedCustomer = customerService.save(customer);
        return new CustomerResponse(
                savedCustomer.getId(),
                savedCustomer.getEmail(),
                savedCustomer.getSalary()
        );
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") Long id,@RequestBody Customer updatedCustomer){  // CustomerResponse yerine Customer döndürülecek
        return customerService.update(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable("id") Long id){
        return customerService.delete(id);
    }
}