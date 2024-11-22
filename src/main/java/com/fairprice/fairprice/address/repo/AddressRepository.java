package com.fairprice.fairprice.address.repo;

import com.fairprice.fairprice.address.dto.FetchAddressesDto;
import com.fairprice.fairprice.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

 @Query(value = """
         SELECT
             a.id,
             a.firstname,
             a.lastname,
             a.address1,
             a.address2,
             a.country,
             a.state,
             a.city,
             a.zipcode,
             a.phone_number,
             a.created_at,
             a.updated_at
             FROM addresses a;
         """, nativeQuery = true)
 List<FetchAddressesDto> findAllAddresses();
 }
