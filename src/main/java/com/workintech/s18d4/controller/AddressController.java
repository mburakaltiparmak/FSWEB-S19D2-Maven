package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AddressResponse;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public AddressResponse getAddressList(){
    return new AddressResponse("Addresses are listed : " + "\n",addressService.getAddressList());
    }
    @GetMapping("/{id}")
    public AddressResponse findAddressById(@PathVariable("id") Long id){
        return new AddressResponse("Find address requests response : " + "\n",List.of(addressService.findAddressById(id)));
    }
    @PostMapping
    public AddressResponse save(@RequestBody Address address){
        return new AddressResponse("Save address requests response : " + "\n",List.of(addressService.save(address)));
    }
    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable("id") Long id,@RequestBody Address updatedAddress){
        return new AddressResponse("Update address requests response : " + "\n",List.of(addressService.update(id,updatedAddress)));
    }
    @DeleteMapping("/{id}")
    public AddressResponse delete(@PathVariable("id") Long id){
        return new AddressResponse("Delete address requests response : " + "\n",List.of(addressService.delete(id)));
    }
}
