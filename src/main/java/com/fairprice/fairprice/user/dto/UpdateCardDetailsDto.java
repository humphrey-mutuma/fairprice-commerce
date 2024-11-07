package com.fairprice.fairprice.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class UpdateCardDetailsDto {

     @NotBlank
    private String holderName;
     @NotBlank
    private String cardNumber;
     @NotBlank
    private String expiry;
     @NotBlank
    private String cvv;

}
