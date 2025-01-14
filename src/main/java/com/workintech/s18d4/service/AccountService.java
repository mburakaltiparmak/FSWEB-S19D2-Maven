package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccountList();
    Account findAccountById(Long id);
    Account save(Account account);
    Account update(Long id,Account updatedAccount);
    Account delete(Long id);
}
