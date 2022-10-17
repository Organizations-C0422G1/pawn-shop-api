package com.pawn_shop.dto;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.model.pawn.PawnItem;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class ContractDto {

    @NotBlank
    private Double liquidationPrice;

    @NotBlank
    private String returnDate;

    @NotBlank
    private Long pawnItem;

    @NotNull
    private Long customer;
}
