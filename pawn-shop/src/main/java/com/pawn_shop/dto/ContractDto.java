package com.pawn_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Long id;
    private CustomerDto customerDto;
    private PawnItemDto pawnItemDto;
}
