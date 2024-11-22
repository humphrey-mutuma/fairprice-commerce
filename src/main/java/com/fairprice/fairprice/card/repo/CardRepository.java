package com.fairprice.fairprice.card.repo;

import com.fairprice.fairprice.card.dto.GetCardsDto;
import com.fairprice.fairprice.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

 @Query(value = """
         SELECT c.id, c.holder_name, c.card_number, c.expiry, c.cvv, c.created_at, c.updated_at FROM cards c;
         """, nativeQuery = true)

 List<GetCardsDto> findAllCards();

 }
