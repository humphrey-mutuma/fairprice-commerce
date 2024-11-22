package com.fairprice.fairprice.address.dto;

public interface FetchAddressesDto {
    Long getId();
    String getFirstname();
    String getLastname();
    String getAddress1();
    String getAddress2();
    String getCountry();
    String getState();
    String getCity();
    String getZipcode();
    String getPhoneNumber();
    String getCreatedAt();
    String getUpdatedAt();
}
