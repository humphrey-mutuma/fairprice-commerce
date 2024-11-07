package com.fairprice.fairprice.user;

import com.fairprice.fairprice.reponse.ApiResponse;
import com.fairprice.fairprice.user.dto.UpdateAddressDto;
import com.fairprice.fairprice.user.dto.UpdateCardDetailsDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import com.fairprice.fairprice.user.model.Card;
import com.fairprice.fairprice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cards")
public class CardController {
    private final UserService userService;

     @GetMapping("/")
    public ResponseEntity<ApiResponse<Card>> findAllCards() {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,userService.findAllCards()));
    }

}
