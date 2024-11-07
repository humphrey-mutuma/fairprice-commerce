package com.fairprice.fairprice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResDto {

   private String id;

   private String username;
   private String addresses;
   private String cards;
   private String products;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

//   others

 }
