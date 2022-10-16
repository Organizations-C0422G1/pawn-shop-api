package com.pawn_shop.dto.projections;

public interface CustomerProjection {
    Long getId();
    String getName();
    String getCode();
    String getIdCard();
    String getPhoneNumber();
    Boolean getGender();
    Long getAmountContract();
    String getImgUrl();
}
