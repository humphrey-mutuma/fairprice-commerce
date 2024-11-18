package com.fairprice.fairprice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResDto {

   private String id;

   private String username;
   private List<String> addresses;
   private List<String> cards;
   private List<String> products;
   private Integer points;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;

//   others

 }
