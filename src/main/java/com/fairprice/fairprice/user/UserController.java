package com.fairprice.fairprice.user;

import com.fairprice.fairprice.reponse.ApiResponse;
import com.fairprice.fairprice.address.dto.UpdateAddressDto;
import com.fairprice.fairprice.card.dto.UpdateCardDetailsDto;
import com.fairprice.fairprice.user.dto.UserPointsDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import com.fairprice.fairprice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

//     fetch user profile ***********************
    @GetMapping("/profile/{userId}")
    public ResponseEntity<ApiResponse<UserProfileResDto>> findUserProfile(
            @PathVariable UUID userId,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,userService.findUserProfile(userId, userDetails)));
    }

    // update user address **************************
    @PatchMapping("/points")
    public ResponseEntity<ApiResponse<String>> updateUserProfile(
            @RequestBody() UserPointsDto userPointsDto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(userService.updateUserPoints(userPointsDto.getPoints(), userDetails), null));
    }

    // update user address **************************
    @PatchMapping("/address")
    public ResponseEntity<ApiResponse<String>> updateUserProfile(
             @RequestBody() UpdateAddressDto UpdateAddressDto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(userService.updateUserAddress(UpdateAddressDto, userDetails), null));
    }

    // update user card **************************
    @PatchMapping("/cards")
    public ResponseEntity<ApiResponse<String>> updateUserCards(
             @RequestBody() UpdateCardDetailsDto updateCardDetailsDto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(userService.updateUserCards(updateCardDetailsDto, userDetails), null));
    }

    // delete user *******************
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(
            @PathVariable("userId") UUID userId,
            @AuthenticationPrincipal UserDetails userDetails

    )  {
        return ResponseEntity
                .ok(new ApiResponse<>( userService.deleteUser(userId, userDetails), null));
    }

}
