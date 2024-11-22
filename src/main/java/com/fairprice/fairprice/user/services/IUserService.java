package com.fairprice.fairprice.user.services;


import com.fairprice.fairprice.address.dto.UpdateAddressDto;
import com.fairprice.fairprice.card.dto.UpdateCardDetailsDto;
import com.fairprice.fairprice.user.dto.AllUsersDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    //     fetch user profile ***********************
    UserProfileResDto findUserProfile(UserDetails userDetails);

    /**
     * fetch all users
     * @return
     */
    List<AllUsersDto> findAllUsersDto();

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
