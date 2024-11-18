package com.fairprice.fairprice.user.services;


import com.fairprice.fairprice.address.dto.UpdateAddressDto;
import com.fairprice.fairprice.card.dto.UpdateCardDetailsDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface IUserService {

    //     fetch user profile ***********************
    UserProfileResDto findUserProfile(UUID userId, UserDetails userDetails);

    // update user address **************************
    String updateUserPoints(
            Double points,
            UserDetails userDetails
    );
    // update user address **************************
    String updateUserAddress(
            UpdateAddressDto updateAddressDto,
            UserDetails userDetails
    );

    // update user address **************************
    String updateUserCards(
             UpdateCardDetailsDto updateCardDetailsDto,
            UserDetails userDetails
    );

    // delete user properties *******************
    String deleteUser(
           UUID userId,
           UserDetails userDetails
    );

}
