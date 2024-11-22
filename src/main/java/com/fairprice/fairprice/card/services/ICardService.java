package com.fairprice.fairprice.card.services;

import com.fairprice.fairprice.card.dto.GetCardsDto;
import com.fairprice.fairprice.card.model.Card;

import java.util.List;

public interface ICardService {

    List<GetCardsDto> findAllCards( );
    String deleteCard( Long cardId );

}
