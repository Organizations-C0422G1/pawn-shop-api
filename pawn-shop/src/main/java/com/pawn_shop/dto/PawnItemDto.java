package com.pawn_shop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.model.pawn.PawnImg;
import com.pawn_shop.model.pawn.PawnType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PawnItemDto {
    private Long id;

    @NotBlank (message = "Vui lòng nhập")
    private String name;

    private PawnType pawnType;

    private Set<PawnImg> pawnImg;

    private Contract contract;

    private Boolean status;
}
