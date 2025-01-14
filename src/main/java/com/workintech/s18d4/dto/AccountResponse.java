package com.workintech.s18d4.dto;

import com.workintech.s18d4.entity.Account;

import java.util.List;

public record AccountResponse(Long id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}
