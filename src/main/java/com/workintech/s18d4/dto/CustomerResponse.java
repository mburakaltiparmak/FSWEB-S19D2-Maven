package com.workintech.s18d4.dto;

import com.workintech.s18d4.entity.Customer;

import java.util.List;

public record CustomerResponse(Long id,String email,double salary) {
}
