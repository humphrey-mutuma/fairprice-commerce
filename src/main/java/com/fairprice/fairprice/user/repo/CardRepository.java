package com.fairprice.fairprice.user.repo;

import com.fairprice.fairprice.user.model.Address;
import com.fairprice.fairprice.user.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

 }
