package com.fairprice.fairprice.address.services;


import com.fairprice.fairprice.address.entity.Address;
import com.fairprice.fairprice.card.entity.Card;

import java.util.List;

public interface IAddressService {

    List<Address> findAllAddresses( );
    String deleteAddress( Long addressId );

}
