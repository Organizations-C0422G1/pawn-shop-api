package com.pawn_shop.dto.projection;

import java.time.LocalDate;

public interface ContractDto {
    Long getId();

    String getCode();

    Double getItemPrice();

    Double getInterestRate();

    LocalDate getStartDate();

    LocalDate getEndDate();

    LocalDate getReturnDate();

    void setReturnDate(LocalDate returnDate);

    Double getLiquidationPrice();

    String getPawnItem();

    String getCustomer();

    String getEmployee();

    Boolean getType();

    Integer getStatus();
}
