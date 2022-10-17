package com.pawn_shop.dto.projection;

import java.time.LocalDate;

public interface ContractProjection {
    Long getId();

    String getCode();

    String getCustomerName();

    String getPawnItemName();

    String getPawnTypeName();

    LocalDate getStartDate();

    LocalDate getEndDate();

    boolean getType();

    int getStatus();
}