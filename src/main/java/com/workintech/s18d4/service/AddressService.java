package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAddressList();
    Address findAddressById(Long id);
    Address save (Address address);
    Address update (Long id,Address address);
    Address delete (Long id);

}
