package com.fairprice.fairprice.card.services;

import com.fairprice.fairprice.card.entity.Card;
import com.fairprice.fairprice.card.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public String deleteCard(Long cardId) {
        cardRepository.findById(cardId).orElseThrow(() -> new ResolutionException("Card not found"));
        cardRepository.deleteById(cardId);
        return "Card deleted successfully";
    }
}
