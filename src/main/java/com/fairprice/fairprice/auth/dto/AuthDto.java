package com.fairprice.fairprice.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    @NotNull
    @NotBlank(message = "Username is required!")
    private String username;

    @NotNull
    @NotBlank(message = "Password is required!")
    private String password;
}
