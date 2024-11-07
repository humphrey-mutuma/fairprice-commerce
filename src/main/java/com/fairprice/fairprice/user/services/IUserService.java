package com.fairprice.fairprice.user.services;


import com.fairprice.fairprice.user.dto.UpdateUserDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;

import java.util.UUID;

public interface IUserService {

    //     fetch user profile ***********************
    UserProfileResDto findUserProfile( UUID userId );

    // update user profile **************************
    String updateUserProfile(
            UUID userId,
            UpdateUserDto updateUserProfileDto
    );

    // delete user properties *******************
    String deleteUser(
           UUID userId
    );

}
