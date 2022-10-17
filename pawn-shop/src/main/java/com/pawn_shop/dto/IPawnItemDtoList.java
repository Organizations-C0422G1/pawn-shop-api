package com.pawn_shop.dto;

import org.springframework.beans.factory.annotation.Value;

public interface IPawnItemDtoList {
    Long getId();
    String getName();
    @Value("#{target.pawnType.name + ''}")
    String getPawnTypeId();
}
