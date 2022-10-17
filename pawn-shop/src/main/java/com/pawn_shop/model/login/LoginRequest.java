package com.pawn_shop.model.login;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {
    @Range(max = 30)
    @NotBlank
    String username;

    @Range(max = 30)
    @NotBlank
    String password;

}
