package com.workintech.s18d4.dto;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public record AddressResponse(String message, List<Address> addressList) {
}
