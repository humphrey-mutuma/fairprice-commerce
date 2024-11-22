package com.fairprice.fairprice.address.services;


import com.fairprice.fairprice.address.dto.FetchAddressesDto;
import com.fairprice.fairprice.address.entity.Address;

import java.util.List;

public interface IAddressService {

    List<FetchAddressesDto> findAllAddresses( );
    String deleteAddress( Long addressId );

}
