package com.fairprice.fairprice.card.services;

import com.fairprice.fairprice.card.dto.GetCardsDto;
import com.fairprice.fairprice.card.model.Card;
import com.fairprice.fairprice.card.repo.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final CardRepository cardRepository ;

    @Override
    public List<GetCardsDto> findAllCards() {
        return cardRepository.findAllCards();
    }

    @Override
    public String deleteCard(Long cardId) {
        cardRepository.findById(cardId).orElseThrow(() -> new ResolutionException("Card not found"));
        cardRepository.deleteById(cardId);
        return "Card deleted successfully";
    }

}
