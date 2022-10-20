package com.pawn_shop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pawn_shop.model.login.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Validator {
    private Long id;

    @NotBlank(message = "Vui lòng nhập vào")
    @Pattern(regexp = "[A-Za-z ]+",message = "Vui lòng nhập đúng định dạng")
    @Size(min = 0,max = 30)
    private String name;

//    @NotBlank(message = "Vui lòng nhập vào")
    private String code;

    private Boolean gender;

    @NotNull(message = "Vui lòng nhập vào")
    private LocalDate dateOfBirth;

    @Email
    @NotNull(message = "Vui lòng nhập vào")
    @NotBlank(message = "Vui lòng nhập vào")
    private String email;

    @NotBlank(message = "Vui lòng nhập vào")
    @NotNull(message = "Vui lòng nhập vào")
    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)\\\\+90)|(\\\\(84\\\\)\\\\+91))[0-9]{7}$",message = "Vui lòng nhập đúng định dạng")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập vào")
    private String address;

    private Double salary;

//    @NotBlank(message = "Vui lòng nhập vào")
    private String imgUrl;

    private boolean status;

    @NotBlank
    @NotNull(message = "Vui lòng nhập vào")
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$",message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String idCard;

    private AppUser appUser;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}