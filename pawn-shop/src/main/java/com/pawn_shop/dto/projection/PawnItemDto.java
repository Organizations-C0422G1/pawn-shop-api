package com.pawn_shop.dto.projection;

import java.time.LocalDate;

public interface PawnItemDto {
    String getName();

    Boolean getStatus();

    String getPawnType();

    LocalDate getEndDate();

    Double getItemPrice();
}
