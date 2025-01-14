package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    @Override
    public List<Address> getAddressList() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(()->new RuntimeException("This address is not exist!"));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address updatedAddress) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            Address address1 = address.get();
            address1.setStreet(updatedAddress.getStreet());
            address1.setNo(updatedAddress.getNo());
            address1.setCity(updatedAddress.getCity());
            address1.setCountry(updatedAddress.getCountry());
            address1.setDescription(updatedAddress.getDescription());
            return addressRepository.save(address1);
        }
        else {
            throw new RuntimeException("A problem occured when updating the address");
        }
    }

    @Override
    public Address delete(Long id) {
        Address deletedAddress = findAddressById(id);
        addressRepository.delete(deletedAddress);
        return deletedAddress;
    }
}
