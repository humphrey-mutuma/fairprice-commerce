package com.fairprice.fairprice.address.services;

import com.fairprice.fairprice.address.entity.Address;
import com.fairprice.fairprice.address.repo.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public String deleteAddress(Long addressId) {
        addressRepository.findById(addressId).orElseThrow(() -> new ResolutionException("Address not found"));
        addressRepository.deleteById(addressId);
        return "Address deleted successfully";
    }
}
