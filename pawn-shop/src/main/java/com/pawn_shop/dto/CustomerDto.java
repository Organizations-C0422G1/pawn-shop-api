package com.pawn_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private AddressDto addressDto;
}
