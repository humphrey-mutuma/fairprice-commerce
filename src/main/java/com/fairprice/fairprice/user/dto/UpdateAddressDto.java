package com.fairprice.fairprice.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class UpdateAddressDto {
    @NotBlank
    private String firstname;
    @NotBlank
    private String  lastname;
    @NotBlank
    private String address1;
    @NotBlank
    private String  address2;
    @NotBlank
    private String country;
    @NotBlank
    private String  state;
    @NotBlank
    private String  city;
    @NotBlank
    private String  zipcode;
    @NotBlank
    private String  phoneNumber;

}
