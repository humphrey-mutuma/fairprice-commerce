package com.fairprice.fairprice.user.services;

 import com.fairprice.fairprice.user.dto.UpdateUserDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
 import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    @Override
    public UserProfileResDto findUserProfile(UUID userId) {
        return null;
    }

    @Override
    public String updateUserProfile(UUID userId, UpdateUserDto updateProductDto) {

        return null;
    }

    @Override
    public String deleteUser(UUID userId) {
        return null;
    }

}
