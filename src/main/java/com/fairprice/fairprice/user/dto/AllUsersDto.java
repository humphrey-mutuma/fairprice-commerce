package com.fairprice.fairprice.user.dto;

import java.time.LocalDateTime;

public interface AllUsersDto {
    Long getId();
    String getUsername();
    Double getPoints();
    String getRole(); // Enum values are usually returned as strings
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
