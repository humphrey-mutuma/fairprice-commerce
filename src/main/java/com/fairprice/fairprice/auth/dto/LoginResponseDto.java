package com.fairprice.fairprice.auth.dto;

import com.fairprice.fairprice.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String token;
    private UUID id;
    private String username;
    private Enum<UserRoles> roles;
 //    add other here
}
