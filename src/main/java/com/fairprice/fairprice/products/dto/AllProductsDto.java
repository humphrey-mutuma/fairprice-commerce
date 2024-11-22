package com.fairprice.fairprice.products.dto;


import java.time.LocalDateTime;
import java.util.UUID;

public interface AllProductsDto {
    UUID getId();
    String getName();
    Double getPrice();
    String getImage();
    String getWeight();
    Boolean getIsHalal();
    Double getRating();
    Double getReviews();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
