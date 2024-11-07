package com.fairprice.fairprice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResDto {

   private String email;

   private String name;

   private String image;

   private String phoneNumber;
}
