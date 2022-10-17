package com.pawn_shop.dto;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.model.pawn.PawnItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ContractDto {

    private Long id;

    @NotEmpty
    private String code;

    @NotNull
    private Double itemPrice;

    @NotNull
    private Double interestRate;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private LocalDate returnDate;

    private Double liquidationPrice;

    @NotNull
    private PawnItem pawnItem;

    @NotNull
    private Customer customer;

    private Employee employee;

    private Boolean type;

    @NotNull
    private int status;
}
