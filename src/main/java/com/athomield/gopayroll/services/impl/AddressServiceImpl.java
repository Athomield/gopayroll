package com.athomield.gopayroll.services.impl;

import com.athomield.gopayroll.entities.Address;
import com.athomield.gopayroll.repositories.AddressRepository;
import com.athomield.gopayroll.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private  AddressRepository addressRepository;


    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setAddress_one(addressDetails.getAddress_one());
                    address.setAddress_two(addressDetails.getAddress_two());
                    address.setCity(addressDetails.getCity());
                    address.setProvince(addressDetails.getProvince());
                    address.setCountry(addressDetails.getCountry());
                    return addressRepository.save(address);
                }).orElse(null);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
