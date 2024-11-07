package com.fairprice.fairprice.user.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CardDetails {

    private String holderName;
    private String cardNumber;
    private String expiry;
    private String cvv;
}
