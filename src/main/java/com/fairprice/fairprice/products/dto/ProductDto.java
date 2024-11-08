package com.fairprice.fairprice.products.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "Price is required")
    private double  price;
    private String  image;
    private String  weight;
    private Boolean isHalal;
    private double  rating;
    private double  reviews;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
