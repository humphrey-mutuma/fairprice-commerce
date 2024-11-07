package com.fairprice.fairprice.card;

import com.fairprice.fairprice.card.entity.Card;
import com.fairprice.fairprice.address.services.AddressService;
import com.fairprice.fairprice.card.services.CardService;
import com.fairprice.fairprice.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cards")

public class CardController {
    private final CardService cardService;

     @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Card>>> findAllCards() {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,cardService.findAllCards()));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<ApiResponse<String>> deleteCard(
            @PathVariable("cardId") Long cardId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,cardService.deleteCard(cardId)));
    }

}
