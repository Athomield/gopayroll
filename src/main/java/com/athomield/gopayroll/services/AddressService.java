package com.athomield.gopayroll.services;

import com.athomield.gopayroll.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address saveAddress(Address address);

    Optional<Address> getAddressById(Long id);

    List<Address> getAllAddresses();

    Address updateAddress(Long id, Address addressDetails);

    void deleteAddress(Long id);
}