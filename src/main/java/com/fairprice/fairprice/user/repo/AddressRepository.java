package com.fairprice.fairprice.user.repo;

import com.fairprice.fairprice.user.model.Address;
import com.fairprice.fairprice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

 }
