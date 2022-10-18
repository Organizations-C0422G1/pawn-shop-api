package com.pawn_shop.dto.projection;

import com.pawn_shop.model.login.AppUser;

public interface IEmployeeDto {
    String getId();
    String getCode();
    String getName();
    String getPhoneNumber();
    String getAddress();
    String getEmail();
    String getStatus();

}
