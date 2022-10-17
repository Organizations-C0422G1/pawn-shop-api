package com.pawn_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PawnItemDto {
    private Long id;
    private PawnTypeDto pawnTypeDto;
}
