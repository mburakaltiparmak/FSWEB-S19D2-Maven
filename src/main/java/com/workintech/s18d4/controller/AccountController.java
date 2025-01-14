package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/account")  // /accounts yerine /account olarak değiştirildi
@AllArgsConstructor

public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;

    @GetMapping
    public List<Account> getAccountList(){
        return accountService.getAccountList();
    }

    @GetMapping("/{id}")
    public Account findAccountById(@PathVariable("id") Long id){  // AccountResponse yerine Account döndürülecek
        return accountService.findAccountById(id);
    }

    @PostMapping("/{customerId}")
    public Account save(@PathVariable("customerId") Long customerId, @RequestBody Account account) {
        Customer customer = customerService.findCustomerById(customerId);
        if (customer != null) {
            account.setCustomer(customer);
            customer.getAccounts().add(account);
            customerService.save(customer); // Önce customer'ı kaydet
            return accountService.save(account);
        }
        throw new RuntimeException("This customer is not exist!");
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable("customerId") Long customerId, @RequestBody Account updatedAccount) {
        Customer customer = customerService.findCustomerById(customerId);
        Account existingAccount = accountService.findAccountById(updatedAccount.getId());

        if (existingAccount == null) {
            throw new RuntimeException("Account(" + updatedAccount.getId() + ") not found for this customer: " + customerId);
        }

        existingAccount.setAccountName(updatedAccount.getAccountName());
        existingAccount.setMoneyAmount(updatedAccount.getMoneyAmount());
        existingAccount.setCustomer(customer);

        return accountService.save(existingAccount);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable("id") Long id){  // AccountResponse yerine Account döndürülecek
        Account account = accountService.findAccountById(id);
        if(account == null){
            throw new RuntimeException("This account is not exist!");
        }
        return accountService.delete(id);
    }
}

