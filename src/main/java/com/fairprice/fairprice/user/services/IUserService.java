package com.fairprice.fairprice.user.services;


import com.fairprice.fairprice.user.dto.UpdateAddressDto;
import com.fairprice.fairprice.user.dto.UpdateCardDetailsDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;

import java.util.UUID;

public interface IUserService {

    //     fetch user profile ***********************
    UserProfileResDto findUserProfile( UUID userId );

    // update user address **************************
    String updateUserAddress(
            UUID userId,
            UpdateAddressDto updateAddressDto
    );

    // update user address **************************
    String updateUserCards(
            UUID userId,
            UpdateCardDetailsDto updateCardDetailsDto
    );

    // delete user properties *******************
    String deleteUser(
           UUID userId
    );

}
