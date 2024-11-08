package com.fairprice.fairprice.card.services;

import com.fairprice.fairprice.card.entity.Card;

import java.util.List;

public interface ICardService {

    List<Card> findAllCards( );
    String deleteCard( Long cardId );

}
