package com.fairprice.fairprice.auth.dto;

import com.fairprice.fairprice.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {

    private String token;
    private Long id;
    private String username;
    private Double points;
    private Enum<UserRoles> roles;
 //    add other here
}
