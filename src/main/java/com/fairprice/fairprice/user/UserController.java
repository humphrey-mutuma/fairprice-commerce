package com.fairprice.fairprice.user;

import com.fairprice.fairprice.reponse.ApiResponse;
 import com.fairprice.fairprice.user.dto.UpdateUserDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import com.fairprice.fairprice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;

//     fetch user profile ***********************
    @GetMapping("/profile/{userId}")
   public ResponseEntity<ApiResponse<UserProfileResDto>> findUserProfile(@PathVariable UUID userId ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,userService.findUserProfile(userId)));
    }

    // update user profile **************************
    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> updateUserProfile(
            @PathVariable("userId") UUID userId,
            @RequestBody() UpdateUserDto updateUserProfileDto
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(userService.updateUserProfile(userId, updateUserProfileDto), null));
    }

    // delete user properties *******************
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(
            @PathVariable("userId") UUID userId
             )  {
        return ResponseEntity
                .ok(new ApiResponse<>( userService.deleteUser(userId), null));
    }

}
