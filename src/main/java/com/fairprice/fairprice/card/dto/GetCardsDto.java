package com.fairprice.fairprice.card.dto;


import java.util.Date;

public interface GetCardsDto {
    Long getId();
    String getHolderName();
    String getCardNumber();
    String getExpiry();
    String getCvv();
    Date getCreatedAt();
    Date getUpdatedAt();
}
