package com.pawn_shop.dto;

import java.time.LocalDate;

public interface CustomerDto {
    Long getId();
    String getName();
    String getCode();
    String getIdCard();
    String getPhoneNumber();
    Boolean getGender();
    Long getAmountContract();
    String getImgUrl();
    LocalDate getDateOfBirth();
    String getEmail();
    Long getAddressId();
}
